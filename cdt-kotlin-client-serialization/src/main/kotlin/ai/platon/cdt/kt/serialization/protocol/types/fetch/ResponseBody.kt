@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.fetch
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Boolean
import kotlin.String

@Serializable
data class ResponseBody(
  @SerialName("body")
  val body: String,
  @SerialName("base64Encoded")
  val base64Encoded: Boolean,
)
