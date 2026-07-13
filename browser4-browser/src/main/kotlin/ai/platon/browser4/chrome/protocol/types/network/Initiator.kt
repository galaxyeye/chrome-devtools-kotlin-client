@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.network

import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import ai.platon.browser4.chrome.protocol.types.runtime.StackTrace
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Information about the request initiator.
 */
@Serializable
data class Initiator(
  @property:SerialName("type")
  val type: InitiatorType,
  @property:SerialName("stack")
  @param:Optional
  val stack: StackTrace? = null,
  @property:SerialName("url")
  @param:Optional
  val url: String? = null,
  @property:SerialName("lineNumber")
  @param:Optional
  val lineNumber: Double? = null,
  @property:SerialName("columnNumber")
  @param:Optional
  val columnNumber: Double? = null,
  @property:SerialName("requestId")
  @param:Optional
  val requestId: String? = null,
)
