@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.storage

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Bundles a candidate URL with its reporting metadata.
 */
@Serializable
data class SharedStorageUrlWithMetadata(
  @property:SerialName("url")
  val url: String,
  @property:SerialName("reportingMetadata")
  val reportingMetadata: List<SharedStorageReportingMetadata>,
)
