@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.runtime

import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Evaluate(
  @property:SerialName("result")
  val result: RemoteObject,
  @property:SerialName("exceptionDetails")
  @param:Optional
  val exceptionDetails: ExceptionDetails? = null,
) {
  companion object {
    /** Fallback instance used when CDP deserialization fails due to protocol mismatch. */
    fun degraded(): Evaluate = Evaluate(result = RemoteObject.degraded())
  }
}
