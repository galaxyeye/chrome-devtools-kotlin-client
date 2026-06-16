package ai.platon.cdt.definition.builder.support.kotlin

import ai.platon.cdt.definition.builder.support.protocol.builder.support.DomainTypeResolver
import ai.platon.cdt.definition.builder.support.utils.StringUtils
import ai.platon.cdt.protocol.definition.types.Domain
import ai.platon.cdt.protocol.definition.types.Type
import ai.platon.cdt.protocol.definition.types.type.ArrayType
import ai.platon.cdt.protocol.definition.types.type.EnumType
import ai.platon.cdt.protocol.definition.types.type.StringType
import ai.platon.cdt.protocol.definition.types.type.`object`.ObjectType
import ai.platon.cdt.protocol.definition.types.type.`object`.Property
import ai.platon.cdt.protocol.definition.types.type.`object`.properties.*
import ai.platon.cdt.protocol.definition.types.type.`object`.properties.array.items.*
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import java.util.*
import ai.platon.cdt.protocol.definition.types.type.array.items.IntegerArrayItem as TopLevelIntegerArrayItem
import ai.platon.cdt.protocol.definition.types.type.array.items.NumberArrayItem as TopLevelNumberArrayItem
import ai.platon.cdt.protocol.definition.types.type.array.items.RefArrayItem as TopLevelRefArrayItem
import ai.platon.cdt.protocol.definition.types.type.array.items.StringArrayItem as TopLevelStringArrayItem

/**
 * Shared Kotlin generation context and helpers backing Kotlin CDP output.
 *
 * @property useSerialization When true, generates kotlinx.serialization annotations
 *   (@Serializable, @SerialName) instead of Jackson annotations (@JsonProperty, @JsonEnumDefaultValue).
 */
class KotlinGenerationContext(
    val basePackage: String,
    val typesPackage: String,
    val eventsPackage: String,
    val commandsPackage: String,
    val supportTypesPackage: String,
    val supportAnnotationsPackage: String,
    val useSerialization: Boolean = false
) {
    val optionalAnnotation = ClassName(supportAnnotationsPackage, "Optional")
    @Deprecated("Deprecated")
    val deprecatedJavaAnnotation = ClassName("java.lang", "Deprecated")
    val deprecatedAnnotation = ClassName("kotlin", "Deprecated")
    val experimentalAnnotation = ClassName(supportAnnotationsPackage, "Experimental")
    val returnsAnnotation = ClassName(supportAnnotationsPackage, "Returns")
    val returnTypeParameterAnnotation = ClassName(supportAnnotationsPackage, "ReturnTypeParameter")
    val paramNameAnnotation = ClassName(supportAnnotationsPackage, "ParamName")
    val eventNameAnnotation = ClassName(supportAnnotationsPackage, "EventName")

    val eventHandlerClass = ClassName(supportTypesPackage, "EventHandler")
    val eventListenerClass = ClassName(supportTypesPackage, "EventListener")

    /** kotlinx.serialization annotations */
    val serializableAnnotation = ClassName("kotlinx.serialization", "Serializable")
    val serialNameAnnotation = ClassName("kotlinx.serialization", "SerialName")

    /** Jackson annotations (used when useSerialization is false) */
    val jsonEnumDefaultValue = ClassName("com.fasterxml.jackson.annotation", "JsonEnumDefaultValue")
    val jsonProperty = ClassName("com.fasterxml.jackson.annotation", "JsonProperty")

    fun typeDomainPackage(domain: Domain): String =
        StringUtils.buildPackageName(typesPackage, domain.domain.lowercase(Locale.ROOT))

    fun eventDomainPackage(domain: Domain): String =
        StringUtils.buildPackageName(eventsPackage, domain.domain.lowercase(Locale.ROOT))

    fun commandDomainPackage(domain: Domain): String {
        // StringUtils.buildPackageName(commandsPackage, domain.domain.lowercase(Locale.ROOT))
        return commandsPackage
    }
}

/**
 * Result of resolving a property or type into a Kotlin type.
 */
data class KotlinResolvedType(
    val typeName: TypeName,
    val supportingFiles: List<FileSpec> = emptyList()
)

/**
 * Helpers for mapping protocol schema to KotlinPoet models.
 */
class KotlinTypeMapper(private val context: KotlinGenerationContext) {
    private val anyNullable = ANY.copy(nullable = true)
    private val stringNullable = STRING.copy(nullable = true)
    private val booleanType = Boolean::class.asTypeName()
    private val booleanNullable = booleanType.copy(nullable = true)
    private val doubleType = Double::class.asTypeName()
    private val intType = Int::class.asTypeName()
    private val mapType = MAP.parameterizedBy(STRING, anyNullable)

    /** kotlinx.serialization JSON types — used when [context.useSerialization] is true */
    private val jsonElement = ClassName("kotlinx.serialization.json", "JsonElement")
    private val jsonElementNullable = jsonElement.copy(nullable = true)
    private val jsonObject = ClassName("kotlinx.serialization.json", "JsonObject")
    private val jsonObjectNullable = jsonObject.copy(nullable = true)

    fun resolveProperty(
        property: Property,
        domain: Domain,
        owner: ObjectType,
        resolver: DomainTypeResolver
    ): KotlinResolvedType {
        val resolution = when (property) {
            is StringProperty -> KotlinResolvedType(STRING)
            is IntegerProperty -> KotlinResolvedType(intType)
            is NumberProperty -> KotlinResolvedType(doubleType)
            is BooleanProperty -> KotlinResolvedType(booleanType)
            is AnyProperty -> KotlinResolvedType(
                if (context.useSerialization) jsonElementNullable else anyNullable
            )
            is ObjectProperty -> KotlinResolvedType(
                if (context.useSerialization) jsonObjectNullable else mapType
            )
            is EnumProperty -> buildInlineEnum(property, domain, owner)
            is ArrayProperty -> resolveArray(property.name, property.items, domain, owner, resolver)
            is RefProperty -> resolveRef(property.ref, domain, owner, resolver)
            else -> KotlinResolvedType(
                if (context.useSerialization) jsonElementNullable else anyNullable
            )
        }
        return if (property.optional == java.lang.Boolean.TRUE) {
            resolution.copy(typeName = resolution.typeName.copy(nullable = true))
        } else {
            resolution
        }
    }

    fun resolveRef(
        refValue: String,
        domain: Domain,
        owner: ObjectType,
        resolver: DomainTypeResolver
    ): KotlinResolvedType {
        val namespace: String
        val refName: String
        val index = refValue.indexOf('.')
        if (index != -1) {
            namespace = refValue.substring(0, index)
            refName = refValue.substring(index + 1)
        } else {
            namespace = domain.domain
            refName = refValue
        }

        val type = resolver.resolve(namespace, refName)
        return when (type) {
            null -> {
                val packageName =
                    StringUtils.buildPackageName(context.typesPackage, namespace.lowercase(Locale.ROOT))
                KotlinResolvedType(ClassName(packageName, refName))
            }

            is StringType -> KotlinResolvedType(STRING)
            is ai.platon.cdt.protocol.definition.types.type.IntegerType -> KotlinResolvedType(intType)
            is ai.platon.cdt.protocol.definition.types.type.NumberType -> KotlinResolvedType(doubleType)
            is ArrayType -> resolveArrayType(refName, type, namespace, refName, owner, domain, resolver)
            is ObjectType -> {
                if (type.properties == null || type.properties.isEmpty()) {
                    KotlinResolvedType(
                        if (context.useSerialization) jsonObjectNullable else mapType
                    )
                } else {
                    val pkg = StringUtils.buildPackageName(
                        context.typesPackage, namespace.lowercase(Locale.ROOT)
                    )
                    KotlinResolvedType(ClassName(pkg, refName))
                }
            }

            is EnumType -> {
                val pkg = StringUtils.buildPackageName(
                    context.typesPackage, namespace.lowercase(Locale.ROOT)
                )
                KotlinResolvedType(ClassName(pkg, refName))
            }

            else -> KotlinResolvedType(ClassName(context.typeDomainPackage(domain), refName))
        }
    }

    private fun resolveArrayType(
        propertyName: String,
        arrayType: ArrayType,
        namespace: String,
        refName: String,
        owner: ObjectType,
        domain: Domain,
        resolver: DomainTypeResolver
    ): KotlinResolvedType {
        val elementResolution = when (val item = arrayType.items) {
            is TopLevelStringArrayItem -> KotlinResolvedType(STRING)
            is TopLevelIntegerArrayItem -> KotlinResolvedType(intType)
            is TopLevelNumberArrayItem -> KotlinResolvedType(doubleType)
            is TopLevelRefArrayItem -> resolveRef(item.ref, domain, owner, resolver)
            else -> KotlinResolvedType(
                if (context.useSerialization) jsonElementNullable else anyNullable
            )
        }
        val listType = LIST.parameterizedBy(elementResolution.typeName)
        return elementResolution.copy(typeName = listType)
    }

    private fun resolveArray(
        propertyName: String,
        item: ai.platon.cdt.protocol.definition.types.type.`object`.properties.array.ArrayItem?,
        domain: Domain,
        owner: ObjectType,
        resolver: DomainTypeResolver
    ): KotlinResolvedType {
        val element = when (item) {
            null -> KotlinResolvedType(
                if (context.useSerialization) jsonElementNullable else anyNullable
            )
            is ObjectArrayItem -> KotlinResolvedType(
                if (context.useSerialization) jsonObjectNullable else mapType
            )
            is AnyArrayItem -> KotlinResolvedType(
                if (context.useSerialization) jsonElementNullable else anyNullable
            )
            is StringArrayItem -> KotlinResolvedType(STRING)
            is IntegerArrayItem -> KotlinResolvedType(intType)
            is NumberArrayItem -> KotlinResolvedType(doubleType)
            is EnumArrayItem -> {
                val inline = buildInlineEnum(propertyName, item.enumValues ?: emptyList(), domain, owner)
                inline.copy(typeName = inline.typeName)
            }

            is RefArrayItem -> resolveRef(item.ref, domain, owner, resolver)
            else -> KotlinResolvedType(
                if (context.useSerialization) jsonElementNullable else anyNullable
            )
        }
        return element.copy(typeName = LIST.parameterizedBy(element.typeName))
    }

    fun resolveTopLevelType(
        domain: Domain,
        type: Type,
        resolver: DomainTypeResolver
    ): KotlinResolvedType? {
        return when (type) {
            is ObjectType -> {
                val result = buildObjectTypeSpec(context.typeDomainPackage(domain), domain, type, resolver)
                val files = mutableListOf<FileSpec>()
                result.file?.let { files.add(it) }
                files.addAll(result.additionalFiles)
                KotlinResolvedType(
                    ClassName(context.typeDomainPackage(domain), result.typeName),
                    files
                )
            }

            is EnumType -> {
                val enumName = StringUtils.toEnumClass(type.id)
                val file = createEnumFile(
                    context.typeDomainPackage(domain), enumName, type.description, type.enumValues ?: emptyList()
                )
                KotlinResolvedType(ClassName(context.typeDomainPackage(domain), enumName), listOf(file))
            }

            is ArrayType -> {
                val typeId = type.id ?: return null
                val owner = ObjectType().apply { id = typeId }
                val element = resolveArrayType(typeId, type, domain.domain, typeId, owner, domain, resolver)
                val aliasName = StringUtils.toEnumClass(typeId)
                val file = FileSpec.builder(context.typeDomainPackage(domain), aliasName)
                    .addTypeAlias(TypeAliasSpec.builder(aliasName, element.typeName).build())
                    .build()
                KotlinResolvedType(
                    ClassName(context.typeDomainPackage(domain), aliasName),
                    element.supportingFiles + file
                )
            }

            is StringType -> simpleAlias(domain, type.id, STRING)
            is ai.platon.cdt.protocol.definition.types.type.IntegerType ->
                simpleAlias(domain, type.id, intType)

            is ai.platon.cdt.protocol.definition.types.type.NumberType ->
                simpleAlias(domain, type.id, doubleType)

            else -> null
        }
    }

    private fun simpleAlias(domain: Domain, id: String?, target: TypeName): KotlinResolvedType? {
        val aliasId = id ?: return null
        val aliasName = StringUtils.toEnumClass(aliasId)
        val packageName = context.typeDomainPackage(domain)
        val file = FileSpec.builder(packageName, aliasName)
            .addTypeAlias(TypeAliasSpec.builder(aliasName, target).build())
            .build()
        return KotlinResolvedType(ClassName(packageName, aliasName), listOf(file))
    }

    data class ObjectTypeResult(val typeName: String, val file: FileSpec?, val additionalFiles: List<FileSpec>)

    fun buildObjectTypeSpec(
        packageName: String,
        domain: Domain,
        objectType: ObjectType,
        resolver: DomainTypeResolver
    ): ObjectTypeResult {
        val className = StringUtils.toEnumClass(objectType.id)

        val properties = objectType.properties ?: emptyList()
        if (properties.isEmpty()) {
            val typeBuilder = TypeSpec.objectBuilder(className)
            objectType.description?.takeIf { it.isNotBlank() }?.let { typeBuilder.addKdoc("%L", it) }
            if (objectType.experimental == java.lang.Boolean.TRUE) {
                typeBuilder.addAnnotation(context.experimentalAnnotation)
            }
            if (objectType.deprecated == java.lang.Boolean.TRUE) {
                typeBuilder.addAnnotation(
                    AnnotationSpec.builder(context.deprecatedAnnotation)
                        .addMember("%S", "Deprecated by protocol")
                        .build()
                )
            }
            val file = FileSpec.builder(packageName, className)
                .addType(typeBuilder.build())
                .build()
            return ObjectTypeResult(className, file, emptyList())
        }

        val ctorBuilder = FunSpec.constructorBuilder()
        val typeBuilder = TypeSpec.classBuilder(className)
            .addModifiers(KModifier.DATA)

        if (context.useSerialization) {
            typeBuilder.addAnnotation(context.serializableAnnotation)
        }

        objectType.description?.takeIf { it.isNotBlank() }?.let { typeBuilder.addKdoc("%L", it) }

        val additionalFiles = mutableListOf<FileSpec>()

        for (property in properties) {
            val resolution = resolveProperty(property, domain, objectType, resolver)
            additionalFiles.addAll(resolution.supportingFiles)

            // Build constructor parameter without JsonProperty (move it to the getter)
            val paramBuilder = ParameterSpec.builder(property.name, resolution.typeName)
            // Apply Optional and other param-only annotations with explicit use-site target when needed
            // JsonProperty should target the getter, so don't add it here

            if (property.optional == java.lang.Boolean.TRUE) {
                paramBuilder.addAnnotation(
                    AnnotationSpec.builder(context.optionalAnnotation)
                        .useSiteTarget(AnnotationSpec.UseSiteTarget.PARAM)
                        .build()
                )
                paramBuilder.defaultValue("null")
            }

            if (property.deprecated == java.lang.Boolean.TRUE) {
                // paramBuilder.addAnnotation(context.deprecatedAnnotation)
                paramBuilder.addAnnotation(
                    AnnotationSpec.builder(context.deprecatedAnnotation)
                        .addMember("%S", "Deprecated by protocol")
                        .build()
                )
            }

            if (property.experimental == java.lang.Boolean.TRUE) {
                // paramBuilder.addAnnotation(context.experimentalAnnotation)
                paramBuilder.addAnnotation(
                    AnnotationSpec.builder(context.experimentalAnnotation)
                        .useSiteTarget(AnnotationSpec.UseSiteTarget.PARAM)
                        .build()
                )
            }

            val parameter = paramBuilder.build()
            ctorBuilder.addParameter(parameter)

            val propertyBuilder = PropertySpec.builder(property.name, resolution.typeName)
                .initializer(property.name)
            // Attach property name annotation to the getter explicitly
            if (context.useSerialization) {
                propertyBuilder.addAnnotation(
                    AnnotationSpec.builder(context.serialNameAnnotation)
                        .useSiteTarget(AnnotationSpec.UseSiteTarget.PROPERTY)
                        .addMember("%S", property.name)
                        .build()
                )
            } else {
                propertyBuilder.addAnnotation(
                    AnnotationSpec.builder(context.jsonProperty)
                        .useSiteTarget(AnnotationSpec.UseSiteTarget.PARAM)
                        .addMember("%S", property.name)
                        .build()
                )
            }
            typeBuilder.addProperty(propertyBuilder.build())
        }

        if (objectType.experimental == java.lang.Boolean.TRUE) {
            typeBuilder.addAnnotation(context.experimentalAnnotation)
        }
        if (objectType.deprecated == java.lang.Boolean.TRUE) {
            typeBuilder.addAnnotation(
                AnnotationSpec.builder(context.deprecatedAnnotation)
                    .addMember("%S", "Deprecated")
                    .build()
            )
        }

        typeBuilder.primaryConstructor(ctorBuilder.build())

        val file = FileSpec.builder(packageName, className)
            .addType(typeBuilder.build())
            .build()

        return ObjectTypeResult(className, file, additionalFiles)
    }

    private fun buildInlineEnum(
        enumProperty: EnumProperty,
        domain: Domain,
        owner: ObjectType
    ): KotlinResolvedType {
        val enumName =
            StringUtils.toEnumClass(owner.id) + StringUtils.toEnumClass(enumProperty.name)
        val packageName = context.typeDomainPackage(domain)
        val file =
            createEnumFile(
                packageName,
                enumName,
                enumProperty.description,
                enumProperty.enumValues ?: emptyList()
            )
        return KotlinResolvedType(ClassName(packageName, enumName), listOf(file))
    }

    private fun buildInlineEnum(
        propertyName: String,
        enumValues: List<String>,
        domain: Domain,
        owner: ObjectType
    ): KotlinResolvedType {
        val enumName =
            StringUtils.toEnumClass(owner.id) + StringUtils.toEnumClass(propertyName) + "Item"
        val packageName = context.typeDomainPackage(domain)
        val file = createEnumFile(packageName, enumName, null, enumValues)
        return KotlinResolvedType(ClassName(packageName, enumName), listOf(file))
    }

    private fun createEnumFile(
        packageName: String,
        enumName: String,
        description: String?,
        values: List<String>
    ): FileSpec {
        val enumBuilder = TypeSpec.enumBuilder(enumName)
        description?.takeIf { it.isNotBlank() }?.let { enumBuilder.addKdoc("%L", it) }

        if (context.useSerialization) {
            enumBuilder.addAnnotation(context.serializableAnnotation)
        }

        val nameAnnotationClass = if (context.useSerialization) {
            context.serialNameAnnotation
        } else {
            context.jsonProperty
        }

        var hasExplicitUnknown = false
        if (values.isNotEmpty()) {
            values.forEach { rawValue ->
                val constName = StringUtils.toEnumConstant(rawValue)
                val constantBuilder = TypeSpec.anonymousClassBuilder()
                    .addAnnotation(
                        AnnotationSpec.builder(nameAnnotationClass)
                            .addMember("%S", rawValue)
                            .build()
                    )

                if (constName == "UNKNOWN") {
                    hasExplicitUnknown = true
                    if (!context.useSerialization) {
                        constantBuilder.addAnnotation(
                            AnnotationSpec.builder(context.jsonEnumDefaultValue).build()
                        )
                    }
                    // Note: kotlinx.serialization has no equivalent of @JsonEnumDefaultValue.
                    // Users should configure Json { coerceInputValues = true } or use a custom
                    // serializer if they need to gracefully handle unknown enum values.
                }

                enumBuilder.addEnumConstant(constName, constantBuilder.build())
            }
        }

        if (!hasExplicitUnknown) {
            val unknownBuilder = TypeSpec.anonymousClassBuilder()
            if (!context.useSerialization) {
                unknownBuilder.addAnnotation(
                    AnnotationSpec.builder(context.jsonEnumDefaultValue).build()
                )
            }
            enumBuilder.addEnumConstant("UNKNOWN", unknownBuilder.build())
        }

        return FileSpec.builder(packageName, enumName)
            .addType(enumBuilder.build())
            .build()
    }
}

fun KotlinGenerationContext.collectReturnGenerics(typeName: TypeName): List<TypeName> {
    val result = mutableListOf<TypeName>()
    this.collectReturnGenerics(typeName, result)
    return result
}

private fun KotlinGenerationContext.collectReturnGenerics(typeName: TypeName, acc: MutableList<TypeName>) {
    if (typeName is com.squareup.kotlinpoet.ParameterizedTypeName) {
        typeName.typeArguments.forEach { argument ->
            if (argument is com.squareup.kotlinpoet.ParameterizedTypeName) {
                // Add the raw type (e.g., List from List<Double>) for parameterized type arguments
                acc.add(argument.rawType.copy(nullable = false))
            }
            this.collectReturnGenerics(argument, acc)
            if (argument is ClassName) {
                // Strip nullability from type arguments for @ReturnTypeParameter annotation
                acc.add(argument.copy(nullable = false))
            }
        }
    }
}
