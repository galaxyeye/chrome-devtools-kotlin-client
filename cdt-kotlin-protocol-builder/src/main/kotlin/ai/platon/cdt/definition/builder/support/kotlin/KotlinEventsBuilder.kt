package ai.platon.cdt.definition.builder.support.kotlin

import ai.platon.cdt.definition.builder.support.protocol.builder.support.DomainTypeResolver
import ai.platon.cdt.protocol.definition.types.Domain
import ai.platon.cdt.protocol.definition.types.type.`object`.ObjectType
import com.squareup.kotlinpoet.FileSpec

/**
 * Generates Kotlin event payload data classes.
 */
class KotlinEventsBuilder(
    private val context: KotlinGenerationContext,
    private val mapper: KotlinTypeMapper
) {
  fun build(domain: Domain, resolver: DomainTypeResolver): List<KotlinSourceFile> {
    val files = mutableListOf<FileSpec>()
    domain.events?.forEach { event ->
      val objectType = ObjectType().apply {
        id = event.name
        description = event.description
        deprecated = event.deprecated
        experimental = event.experimental
        properties = event.parameters
      }

      val result = mapper.buildObjectTypeSpec(
          context.eventDomainPackage(domain),
          domain,
          objectType,
          resolver)

      result.file?.let { files.add(it) }
      files.addAll(result.additionalFiles)
    }

    return files.distinctBy { it.packageName + "." + it.name }.map(::KotlinSourceFile)
  }
}
