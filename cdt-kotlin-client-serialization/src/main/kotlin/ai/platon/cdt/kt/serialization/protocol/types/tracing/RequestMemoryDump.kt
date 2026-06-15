@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.tracing
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Boolean
import kotlin.String

@Serializable
data class RequestMemoryDump(
  @SerialName("dumpGuid")
  val dumpGuid: String,
  @SerialName("success")
  val success: Boolean,
)
