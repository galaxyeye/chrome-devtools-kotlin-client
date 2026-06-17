@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.fetch

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseBody(
  @property:SerialName("body")
  val body: String,
  @property:SerialName("base64Encoded")
  val base64Encoded: Boolean,
) {
  companion object {
    /** Fallback instance used when CDP deserialization fails due to protocol mismatch. */
    fun degraded(): ResponseBody = ResponseBody(body = "", base64Encoded = false)
  }
}
