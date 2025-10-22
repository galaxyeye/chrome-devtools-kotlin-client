package ai.platon.cdt.definition.builder.support.kotlin

import ai.platon.cdt.definition.builder.support.protocol.builder.support.DomainTypeResolver
import ai.platon.cdt.definition.builder.support.utils.StringUtils
import ai.platon.cdt.protocol.definition.types.Command
import ai.platon.cdt.protocol.definition.types.Domain
import ai.platon.cdt.protocol.definition.types.type.`object`.ObjectType
import ai.platon.cdt.protocol.definition.types.type.`object`.Property
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy

/**
 * Generates Kotlin command interfaces with suspend signatures and listener helpers.
 */
class KotlinCommandsBuilder(
    private val context: KotlinGenerationContext,
    private val mapper: KotlinTypeMapper,
    private val typesBuilder: KotlinTypesBuilder
) {
    fun build(domain: Domain, resolver: DomainTypeResolver): List<KotlinSourceFile> {
        val interfaceName = StringUtils.toEnumClass(domain.domain)
        val packageName = context.commandDomainPackage(domain)
        val interfaceBuilder = TypeSpec.interfaceBuilder(interfaceName)

        domain.description?.takeIf { it.isNotBlank() }?.let { interfaceBuilder.addKdoc("%L", it) }

        if (domain.experimental == java.lang.Boolean.TRUE) {
            interfaceBuilder.addAnnotation(context.experimentalAnnotation)
        }
        if (domain.deprecated == java.lang.Boolean.TRUE) {
            interfaceBuilder.addAnnotation(
                AnnotationSpec.builder(context.deprecatedAnnotation)
                    .addMember("%S", "Deprecated by protocol")
                    .build()
            )
        }

        val additionalFiles = mutableListOf<FileSpec>()

        domain.commands?.forEach { command ->
            if (!command.redirect.isNullOrBlank()) {
                return@forEach
            }

            val result = buildCommand(domain, command, resolver)
            interfaceBuilder.addFunction(result.primary)
            result.overload?.let { interfaceBuilder.addFunction(it) }
            additionalFiles.addAll(result.supportingFiles)
        }

        domain.events?.forEach { event ->
            val payloadClass =
                ClassName(context.eventDomainPackage(domain), StringUtils.toEnumClass(event.name))
            val handlerType = context.eventHandlerClass.parameterizedBy(payloadClass)

            val funBuilder = FunSpec.builder("on" + StringUtils.capitalize(event.name))
                .addModifiers(KModifier.ABSTRACT)
                .returns(context.eventListenerClass)
                .addParameter(ParameterSpec.builder("eventListener", handlerType).build())
            val eventNameAnnotation = AnnotationSpec.builder(context.eventNameAnnotation)
                .addMember("%S", event.name)
                .build()
            funBuilder.addAnnotation(eventNameAnnotation)

            // Overload variant taking `suspend (Payload) -> Unit`
            val suspendLambdaType = LambdaTypeName.get(
                null,
                parameters = arrayOf<TypeName>(payloadClass),
                returnType = UNIT
            ).copy(suspending = true)
            val suspendFunBuilder = FunSpec.builder("on" + StringUtils.capitalize(event.name))
                .addModifiers(KModifier.ABSTRACT)
                .returns(context.eventListenerClass)
                .addParameter(ParameterSpec.builder("eventListener", suspendLambdaType).build())
                .addAnnotation(eventNameAnnotation)

            if (event.deprecated == java.lang.Boolean.TRUE) {
                funBuilder.addAnnotation(
                    AnnotationSpec.builder(context.deprecatedAnnotation)
                        .addMember("%S", "Deprecated by protocol")
                        .build()
                )
                suspendFunBuilder.addAnnotation(
                    AnnotationSpec.builder(context.deprecatedAnnotation)
                        .addMember("%S", "Deprecated by protocol")
                        .build()
                )
            }
            if (event.experimental == java.lang.Boolean.TRUE) {
                funBuilder.addAnnotation(context.experimentalAnnotation)
                suspendFunBuilder.addAnnotation(context.experimentalAnnotation)
            }

            interfaceBuilder.addFunction(funBuilder.build())
            interfaceBuilder.addFunction(suspendFunBuilder.build())
        }

        val interfaceFile = FileSpec.builder(packageName, interfaceName)
            .addType(interfaceBuilder.build())
            .build()

        return (additionalFiles + interfaceFile)
            .distinctBy { it.packageName + "." + it.name }
            .map(::KotlinSourceFile)
    }

    private fun buildCommand(
        domain: Domain,
        command: Command,
        resolver: DomainTypeResolver
    ): CommandGenerationResult {
        val methodName = command.name
        val ownerForParams = ObjectType().apply { id = StringUtils.toEnumClass(command.name) }
        val ownerForReturns = ObjectType().apply { id = StringUtils.toEnumClass(domain.domain) }

        val parameters = command.parameters ?: emptyList()
        val commandParams = parameters.map { property ->
            val resolution = mapper.resolveProperty(property, domain, ownerForParams, resolver)
            CommandParameter(
                property = property,
                spec = buildParameterSpec(property, resolution.typeName),
                supportingFiles = resolution.supportingFiles
            )
        }

        val returnComputation = computeReturnType(domain, command, ownerForReturns, resolver)

        val primaryMethod = FunSpec.builder(methodName)
            .addModifiers(KModifier.SUSPEND, KModifier.ABSTRACT)
            .returns(returnComputation.returnType)
        commandParams.forEach { primaryMethod.addParameter(it.spec) }

        buildMethodKdoc(command, commandParams.map { it.property })?.let {
            primaryMethod.addKdoc("%L", it)
        }

        if (command.deprecated == java.lang.Boolean.TRUE) {
            primaryMethod.addAnnotation(
                AnnotationSpec.builder(context.deprecatedAnnotation)
                    .addMember("%S", "Deprecated by protocol")
                    .build()
            )
        }
        if (command.experimental == java.lang.Boolean.TRUE) {
            primaryMethod.addAnnotation(
                AnnotationSpec.builder(context.deprecatedAnnotation)
                    .addMember("%S", "Deprecated by protocol")
                    .build()
            )
        }

        if (returnComputation.returnsAnnotation != null) {
            primaryMethod.addAnnotation(returnComputation.returnsAnnotation)
        }
        returnComputation.returnTypeParameterAnnotation?.let { primaryMethod.addAnnotation(it) }

        val overloadMethod =
            createOverloadIfNeeded(
                methodName,
                returnComputation.returnType,
                commandParams,
                command.deprecated == java.lang.Boolean.TRUE,
                command.experimental == java.lang.Boolean.TRUE,
                returnComputation.returnsAnnotation,
                returnComputation.returnTypeParameterAnnotation
            )

        return CommandGenerationResult(
            primary = primaryMethod.build(),
            overload = overloadMethod,
            supportingFiles =
                commandParams.flatMap { it.supportingFiles } + returnComputation.supportingFiles)
    }

    private fun buildParameterSpec(property: Property, typeName: TypeName): ParameterSpec {
        val paramBuilder = ParameterSpec.builder(property.name, typeName)
        val paramAnnotation = AnnotationSpec.builder(context.paramNameAnnotation)
            .addMember("%S", property.name)
            .build()
        paramBuilder.addAnnotation(paramAnnotation)

        if (property.optional == java.lang.Boolean.TRUE) {
            paramBuilder.addAnnotation(context.optionalAnnotation)
            // Set default to null for optional params so callers can omit them
            paramBuilder.defaultValue("null")
        }
        if (property.deprecated == java.lang.Boolean.TRUE) {
            paramBuilder.addAnnotation(
                AnnotationSpec.builder(context.deprecatedAnnotation)
                    .addMember("%S", "Deprecated by protocol")
                    .build()
            )
        }
        if (property.experimental == java.lang.Boolean.TRUE) {
            paramBuilder.addAnnotation(context.experimentalAnnotation)
        }

        return paramBuilder.build()
    }

    private fun buildMethodKdoc(command: Command, params: List<Property>): String? {
        val description = command.description.orEmpty()
        val paramDocs = params.joinToString(separator = "\n") { property ->
            if (property.description.isNullOrBlank()) {
                "@param ${property.name}"
            } else {
                "@param ${property.name} ${property.description}"
            }
        }

        return when {
            description.isBlank() && paramDocs.isBlank() -> null
            paramDocs.isBlank() -> description
            description.isBlank() -> paramDocs
            else -> description + "\n" + paramDocs
        }
    }

    private fun computeReturnType(
        domain: Domain,
        command: Command,
        ownerForReturns: ObjectType,
        resolver: DomainTypeResolver
    ): CommandReturn {
        val returns = command.returns ?: emptyList()
        if (returns.isEmpty()) {
            return CommandReturn(UNIT, emptyList())
        }

        if (returns.size == 1) {
            val property = returns.first()
            val resolution = mapper.resolveProperty(property, domain, ownerForReturns, resolver)
            val returnsAnnotation = AnnotationSpec.builder(context.returnsAnnotation)
                .addMember("%S", property.name)
                .build()
            val returnTypeArgs = context.collectReturnGenerics(resolution.typeName)
            val returnTypeAnnotation = if (returnTypeArgs.isEmpty()) {
                null
            } else {
                val members = returnTypeArgs.map { CodeBlock.of("%T::class", it) }
                val builder = AnnotationSpec.builder(context.returnTypeParameterAnnotation)
                if (members.size == 1) {
                    builder.addMember("%L", members.first())
                } else {
                    builder.addMember("%L", members.joinToCode(separator = ", "))
                }
                builder.build()
            }
            return CommandReturn(
                resolution.typeName,
                resolution.supportingFiles,
                returnsAnnotation,
                returnTypeAnnotation
            )
        }

        val syntheticName = StringUtils.getReturnTypeFromGetter(command.name)
        val files = typesBuilder.buildSyntheticReturnType(domain, syntheticName, returns, resolver)
        val typeName = ClassName(context.typeDomainPackage(domain), syntheticName)
        return CommandReturn(typeName, files)
    }

    private fun createOverloadIfNeeded(
        methodName: String,
        returnType: TypeName,
        allParams: List<CommandParameter>,
        isDeprecated: Boolean,
        isExperimental: Boolean,
        returnsAnnotation: AnnotationSpec?,
        returnTypeParameterAnnotation: AnnotationSpec?
    ): FunSpec? {
        val optionalParams = allParams.filter { it.property.optional == java.lang.Boolean.TRUE }
        if (optionalParams.isEmpty()) {
            return null
        }

        val requiredParams = allParams - optionalParams.toSet()
        val overloadBuilder = FunSpec.builder(methodName)
            .addModifiers(KModifier.SUSPEND)
            .returns(returnType)

        if (isDeprecated) {
            overloadBuilder.addAnnotation(
                AnnotationSpec.builder(context.deprecatedAnnotation)
                    .addMember("%S", "Deprecated by protocol")
                    .build()
            )
        }
        if (isExperimental) {
            overloadBuilder.addAnnotation(context.experimentalAnnotation)
        }
        returnsAnnotation?.let { overloadBuilder.addAnnotation(it) }
        returnTypeParameterAnnotation?.let { overloadBuilder.addAnnotation(it) }

        requiredParams.forEach { overloadBuilder.addParameter(it.spec) }

        val argumentBlocks = mutableListOf<CodeBlock>()
        requiredParams.forEach { argumentBlocks.add(CodeBlock.of("%N", it.spec)) }
        optionalParams.forEach { argumentBlocks.add(CodeBlock.of("null")) }

        val call = CodeBlock.builder()
            .add("return %N(", methodName)
        if (argumentBlocks.isNotEmpty()) {
            call.add(argumentBlocks.joinToCode(separator = ", "))
        }
        call.add(")")
        overloadBuilder.addStatement("%L", call.build())

        return overloadBuilder.build()
    }

    private data class CommandParameter(
        val property: Property,
        val spec: ParameterSpec,
        val supportingFiles: List<FileSpec>
    )

    private data class CommandReturn(
        val returnType: TypeName,
        val supportingFiles: List<FileSpec>,
        val returnsAnnotation: AnnotationSpec? = null,
        val returnTypeParameterAnnotation: AnnotationSpec? = null
    )

    private data class CommandGenerationResult(
        val primary: FunSpec,
        val overload: FunSpec?,
        val supportingFiles: List<FileSpec>
    )
}
