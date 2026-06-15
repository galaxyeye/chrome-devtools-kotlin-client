@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domdebugger
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.RemoteObject
import kotlin.Boolean
import kotlin.Int
import kotlin.String

/**
 * Object event listener.
 */
@Serializable
data class EventListener(
  @SerialName("type")
  val type: String,
  @SerialName("useCapture")
  val useCapture: Boolean,
  @SerialName("passive")
  val passive: Boolean,
  @SerialName("once")
  val once: Boolean,
  @SerialName("scriptId")
  val scriptId: String,
  @SerialName("lineNumber")
  val lineNumber: Int,
  @SerialName("columnNumber")
  val columnNumber: Int,
  @SerialName("handler")
  @param:Optional
  val handler: RemoteObject? = null,
  @SerialName("originalHandler")
  @param:Optional
  val originalHandler: RemoteObject? = null,
  @SerialName("backendNodeId")
  @param:Optional
  val backendNodeId: Int? = null,
)
