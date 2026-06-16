@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.crashreportcontext

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Key-value pair in CrashReportContext.
 */
data class CrashReportContextEntry(
  @param:JsonProperty("key")
  val key: String,
  @param:JsonProperty("value")
  val `value`: String,
  @param:JsonProperty("frameId")
  val frameId: String,
)
