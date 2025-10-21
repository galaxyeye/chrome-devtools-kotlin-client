package ai.platon.cdt.definition.builder.support.kotlin

import ai.platon.cdt.definition.builder.support.protocol.builder.support.DomainTypeResolver
import ai.platon.cdt.definition.builder.support.utils.StringUtils
import ai.platon.cdt.protocol.definition.DevToolsProtocol
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import java.io.IOException
import java.nio.file.Path

/**
 * Kotlin protocol generator entry point.
 */
class KotlinProtocolGenerator(
    basePackage: String,
    typesPackageName: String,
    eventPackageName: String,
    commandPackageName: String,
    supportTypesPackageName: String,
    supportAnnotationsPackageName: String,
    private val outputRoot: Path
) {
    private val context =
        KotlinGenerationContext(
            basePackage,
            typesPackageName,
            eventPackageName,
            commandPackageName,
            supportTypesPackageName,
            supportAnnotationsPackageName
        )
    private val mapper = KotlinTypeMapper(context)
    private val typesBuilder = KotlinTypesBuilder(context, mapper)
    private val eventsBuilder = KotlinEventsBuilder(context, mapper)
    private val commandsBuilder = KotlinCommandsBuilder(context, mapper, typesBuilder)

    @Throws(IOException::class)
    fun generate(protocol: DevToolsProtocol, domainTypeResolver: DomainTypeResolver) {
        val project: KotlinSourceProject = KotlinSourceProjectImpl(outputRoot)

        protocol.domains?.forEach { domain ->
            typesBuilder.build(domain, domainTypeResolver).forEach(project::addFile)
            eventsBuilder.build(domain, domainTypeResolver).forEach(project::addFile)
            commandsBuilder.build(domain, domainTypeResolver).forEach(project::addFile)
        }

        project.addFile(buildChromeDevTools(protocol))

        // Generate Kotlin-native support annotations and types under the same base package
        generateKotlinSupportAnnotations(project)
        generateKotlinSupportTypes(project)

        project.writeAll()
    }

    private fun buildChromeDevTools(protocol: DevToolsProtocol): KotlinSourceFile {
        val interfaceBuilder = TypeSpec.interfaceBuilder("ChromeDevTools")
        // For each domain generate a Kotlin property instead of a Java-style getter
        protocol.domains?.forEach { domain ->
            val typeName = ClassName(context.commandDomainPackage(domain), StringUtils.toEnumClass(domain.domain))
            val propertyName = toCamelCase(domain.domain)
            val propertyBuilder = PropertySpec.builder(propertyName, typeName)
            domain.description?.takeIf { it.isNotBlank() }?.let { propertyBuilder.addKdoc("%L", it) }
            interfaceBuilder.addProperty(propertyBuilder.build())
        }

        val file = FileSpec.builder(context.basePackage, "ChromeDevTools")
            .addType(interfaceBuilder.build())
            .build()
        return KotlinSourceFile(file)
    }

    /**
     * Camel case means capitalize the first letter of each subsequent word and keep the first letter lowercase.
     *
     * When using acronyms like DOM, HTML, or URL in variable or property names,
     * use lowercase for the acronym’s first letter in camelCase style.
     *
     * For example:
     * val dom: DOM, val domDebugger: DOMDebugger, val htmlParser: HTMLParser.
     *
     * - "DOM" -> "dom"
     * - "DOMDebugger" -> "domDebugger"
     * - "Network" -> "network"
     */
    fun toCamelCase(input: String): String {
        // 分割所有常见分隔符（_、-、空格）或大小写边界
        val parts = input
            .split(Regex("[_\\-\\s]+"))         // 根据下划线、横线、空格切分
            .flatMap {                          // 再按大小写边界进一步切
                Regex("(?<=[a-z0-9])(?=[A-Z])").split(it)
            }
            .filter { it.isNotBlank() }          // 移除空字符串

        if (parts.isEmpty()) return input

        val first = parts.first().lowercase()
        val rest = parts.drop(1).joinToString("") {
            it.lowercase().replaceFirstChar { c -> c.titlecase() }
        }

        return first + rest
    }

    private fun generateKotlinSupportAnnotations(project: KotlinSourceProject) {
        val annotationsPkg = context.supportAnnotationsPackage

        fun annotationType(
            name: String,
            targets: List<AnnotationTarget>,
            retention: AnnotationRetention,
            params: List<ParameterSpec> = emptyList()
        ): TypeSpec {
            val builder = TypeSpec.annotationBuilder(name)
            // Use fully qualified kotlin.annotation.* meta-annotations so KotlinPoet treats them as default imports and does not emit import statements.
            val targetAnn = AnnotationSpec.builder(ClassName("kotlin.annotation", "Target"))
                .addMember(targets.joinToString(",\n") { "AnnotationTarget.%L" }, *targets.map { it.name }.toTypedArray())
                .build()
            builder.addAnnotation(targetAnn)
            val retentionAnn = AnnotationSpec.builder(ClassName("kotlin.annotation", "Retention"))
                .addMember("AnnotationRetention.%L", retention.name)
                .build()
            builder.addAnnotation(retentionAnn)
            // params
            params.forEach { p ->
                builder.addProperty(PropertySpec.builder(p.name, p.type).initializer(p.name).build())
                builder.primaryConstructor(FunSpec.constructorBuilder().addParameters(params).build())
            }
            return builder.build()
        }

        val files = mutableListOf<FileSpec>()

        // Build annotations in a single file
        val fileBuilder = FileSpec.builder(annotationsPkg, "SupportAnnotations")

        // Optional
        fileBuilder.addType(
            annotationType(
                name = "Optional",
                targets = listOf(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.PROPERTY),
                retention = AnnotationRetention.RUNTIME
            )
        )
        // Experimental
        fileBuilder.addType(
            annotationType(
                name = "Experimental",
                targets = listOf(
                    AnnotationTarget.FUNCTION,
                    AnnotationTarget.CLASS,
                    AnnotationTarget.PROPERTY,
                    AnnotationTarget.VALUE_PARAMETER,
                    AnnotationTarget.PROPERTY_GETTER,
                    AnnotationTarget.PROPERTY_SETTER
                ),
                retention = AnnotationRetention.RUNTIME
            )
        )
        // ParamName(val value: String)
        val paramNameCtor = listOf(ParameterSpec.builder("value", STRING).build())
        fileBuilder.addType(
            annotationType(
                name = "ParamName",
                targets = listOf(AnnotationTarget.VALUE_PARAMETER),
                retention = AnnotationRetention.RUNTIME,
                params = paramNameCtor
            )
        )
        // Returns(val value: String)
        val returnsCtor = listOf(ParameterSpec.builder("value", STRING).build())
        fileBuilder.addType(
            annotationType(
                name = "Returns",
                targets = listOf(AnnotationTarget.FUNCTION),
                retention = AnnotationRetention.RUNTIME,
                params = returnsCtor
            )
        )
        // ReturnTypeParameter(vararg val value: KClass<*>)
        val kClassStar = ClassName("kotlin.reflect", "KClass").parameterizedBy(STAR)
        val rtpCtor = listOf(ParameterSpec.builder("value", kClassStar).addModifiers(KModifier.VARARG).build())
        fileBuilder.addType(
            annotationType(
                name = "ReturnTypeParameter",
                targets = listOf(AnnotationTarget.FUNCTION),
                retention = AnnotationRetention.RUNTIME,
                params = rtpCtor
            )
        )
        // EventName(val value: String)
        val eventNameCtor = listOf(ParameterSpec.builder("value", STRING).build())
        fileBuilder.addType(
            annotationType(
                name = "EventName",
                targets = listOf(AnnotationTarget.FUNCTION),
                retention = AnnotationRetention.RUNTIME,
                params = eventNameCtor
            )
        )

        files.add(fileBuilder.build())

        files.distinctBy { it.packageName + "." + it.name }
            .map(::KotlinSourceFile)
            .forEach(project::addFile)
    }

    private fun generateKotlinSupportTypes(project: KotlinSourceProject) {
        val typesPkg = context.supportTypesPackage

        val fileBuilder = FileSpec.builder(typesPkg, "SupportTypes")

        // fun interface EventHandler<T> { fun onEvent(event: T) }
        val tType = TypeVariableName("T")
        val handleFun = FunSpec.builder("onEvent")
            .addModifiers(KModifier.ABSTRACT)
            .addParameter("event", tType)
            .build()
        val eventHandler = TypeSpec.interfaceBuilder("EventHandler")
            .addTypeVariable(tType)
            .addModifiers(KModifier.FUN)
            .addFunction(handleFun)
            .build()
        fileBuilder.addType(eventHandler)

        // interface EventListener with standard unsubscribe methods
        val offFun = FunSpec.builder("off")
            .addKdoc("Alias to unsubscribe.  ")
            .addModifiers(KModifier.ABSTRACT)
            .build()
        val unsubscribeFun = FunSpec.builder("unsubscribe")
            .addKdoc("Unsubscribe this event listener.  ")
            .addModifiers(KModifier.ABSTRACT)
            .build()
        val eventListener = TypeSpec.interfaceBuilder("EventListener")
            .addFunction(offFun)
            .addFunction(unsubscribeFun)
            .build()
        fileBuilder.addType(eventListener)

        KotlinSourceFile(fileBuilder.build()).also(project::addFile)
    }
}
