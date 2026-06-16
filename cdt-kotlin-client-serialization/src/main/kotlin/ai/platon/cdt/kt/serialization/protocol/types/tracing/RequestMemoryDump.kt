@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.tracing

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestMemoryDump(
  @property:SerialName("dumpGuid")
  val dumpGuid: String,
  @property:SerialName("success")
  val success: Boolean,
)
