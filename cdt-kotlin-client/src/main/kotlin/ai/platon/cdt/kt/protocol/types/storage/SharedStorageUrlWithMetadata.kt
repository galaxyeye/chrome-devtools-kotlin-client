@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.storage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * Bundles a candidate URL with its reporting metadata.
 */
data class SharedStorageUrlWithMetadata(
  @param:JsonProperty("url")
  val url: String,
  @param:JsonProperty("reportingMetadata")
  val reportingMetadata: List<SharedStorageReportingMetadata>,
)
