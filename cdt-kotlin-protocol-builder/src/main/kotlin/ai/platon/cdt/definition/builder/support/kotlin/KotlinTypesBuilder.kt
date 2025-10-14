package ai.platon.cdt.definition.builder.support.kotlin

import ai.platon.cdt.definition.builder.support.protocol.builder.support.DomainTypeResolver
import ai.platon.cdt.protocol.definition.types.Domain
import ai.platon.cdt.protocol.definition.types.type.`object`.ObjectType
import ai.platon.cdt.protocol.definition.types.type.`object`.Property
import com.squareup.kotlinpoet.FileSpec

/**
 * Builds Kotlin type representations for protocol domains.
 */
class KotlinTypesBuilder(
    private val context: KotlinGenerationContext,
    private val mapper: KotlinTypeMapper
) {
  fun build(domain: Domain, resolver: DomainTypeResolver): List<KotlinSourceFile> {
    val files = mutableListOf<FileSpec>()
    domain.types?.forEach { type ->
      val result = mapper.resolveTopLevelType(domain, type, resolver) ?: return@forEach
      files.addAll(result.supportingFiles)
    }
    return files.distinctBy { it.packageName + "." + it.name }.map(::KotlinSourceFile)
  }

  fun buildObjectType(
      domain: Domain,
      objectType: ObjectType,
      resolver: DomainTypeResolver
  ): List<KotlinSourceFile> {
    val result = mapper.buildObjectTypeSpec(
      context.typeDomainPackage(domain),
      domain,
      objectType,
      resolver)
    val files = mutableListOf<FileSpec>()
    result.file?.let { files.add(it) }
    files.addAll(result.additionalFiles)
    return files.map(::KotlinSourceFile)
  }

  fun buildSyntheticReturnType(
      domain: Domain,
      name: String,
      properties: List<Property>,
      resolver: DomainTypeResolver
  ): List<KotlinSourceFile> {
    val synthetic = ObjectType().apply {
      id = name
      this.properties = properties
    }
    return buildObjectType(
      domain,
      synthetic,
      resolver)
  }
}
