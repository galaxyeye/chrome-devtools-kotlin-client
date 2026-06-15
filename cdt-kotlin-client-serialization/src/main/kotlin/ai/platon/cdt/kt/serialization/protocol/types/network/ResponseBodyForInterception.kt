@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Boolean
import kotlin.String

@Serializable
data class ResponseBodyForInterception(
  @SerialName("body")
  val body: String,
  @SerialName("base64Encoded")
  val base64Encoded: Boolean,
)
