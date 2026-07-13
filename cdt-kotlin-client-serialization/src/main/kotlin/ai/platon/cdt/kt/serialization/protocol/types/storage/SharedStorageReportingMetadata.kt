@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.storage

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Pair of reporting metadata details for a candidate URL for `selectURL()`.
 */
@Serializable
data class SharedStorageReportingMetadata(
  @property:SerialName("eventType")
  val eventType: String,
  @property:SerialName("reportingUrl")
  val reportingUrl: String,
)
