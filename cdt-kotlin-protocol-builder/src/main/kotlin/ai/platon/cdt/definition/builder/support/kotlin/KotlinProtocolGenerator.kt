package ai.platon.cdt.definition.builder.support.kotlin

import ai.platon.cdt.definition.builder.support.protocol.builder.support.DomainTypeResolver
import ai.platon.cdt.definition.builder.support.utils.StringUtils
import ai.platon.cdt.protocol.definition.DevToolsProtocol
import ai.platon.cdt.protocol.definition.types.Domain
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.TypeSpec
import java.io.IOException
import java.nio.file.Path
import kotlin.jvm.Throws

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
          supportAnnotationsPackageName)
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

    project.writeAll()
  }

  private fun buildChromeDevTools(protocol: DevToolsProtocol): KotlinSourceFile {
    val interfaceBuilder = TypeSpec.interfaceBuilder("ChromeDevTools")
        .addModifiers(KModifier.PUBLIC)

    protocol.domains?.forEach { domain ->
      val methodName = "get" + StringUtils.toEnumClass(domain.domain)
    val returnType =
      ClassName(context.commandDomainPackage(domain), StringUtils.toEnumClass(domain.domain))
      val funSpec = FunSpec.builder(methodName)
          .addModifiers(KModifier.ABSTRACT)
          .returns(returnType)
          .build()
      interfaceBuilder.addFunction(funSpec)
    }

    val file = FileSpec.builder(context.basePackage, "ChromeDevTools")
        .addType(interfaceBuilder.build())
        .build()
    return KotlinSourceFile(file)
  }
}
