@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.crashreportcontext

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Key-value pair in CrashReportContext.
 */
@Serializable
data class CrashReportContextEntry(
  @property:SerialName("key")
  val key: String,
  @property:SerialName("value")
  val `value`: String,
  @property:SerialName("frameId")
  val frameId: String,
)
