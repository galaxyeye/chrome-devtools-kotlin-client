@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTrace
import kotlin.Double
import kotlin.String

/**
 * Information about the request initiator.
 */
@Serializable
data class Initiator(
  @SerialName("type")
  val type: InitiatorType,
  @SerialName("stack")
  @param:Optional
  val stack: StackTrace? = null,
  @SerialName("url")
  @param:Optional
  val url: String? = null,
  @SerialName("lineNumber")
  @param:Optional
  val lineNumber: Double? = null,
  @SerialName("columnNumber")
  @param:Optional
  val columnNumber: Double? = null,
  @SerialName("requestId")
  @param:Optional
  val requestId: String? = null,
)
