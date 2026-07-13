@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.storage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Pair of reporting metadata details for a candidate URL for `selectURL()`.
 */
data class SharedStorageReportingMetadata(
  @param:JsonProperty("eventType")
  val eventType: String,
  @param:JsonProperty("reportingUrl")
  val reportingUrl: String,
)
