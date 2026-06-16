@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domdebugger

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.RemoteObject
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Object event listener.
 */
@Serializable
data class EventListener(
  @property:SerialName("type")
  val type: String,
  @property:SerialName("useCapture")
  val useCapture: Boolean,
  @property:SerialName("passive")
  val passive: Boolean,
  @property:SerialName("once")
  val once: Boolean,
  @property:SerialName("scriptId")
  val scriptId: String,
  @property:SerialName("lineNumber")
  val lineNumber: Int,
  @property:SerialName("columnNumber")
  val columnNumber: Int,
  @property:SerialName("handler")
  @param:Optional
  val handler: RemoteObject? = null,
  @property:SerialName("originalHandler")
  @param:Optional
  val originalHandler: RemoteObject? = null,
  @property:SerialName("backendNodeId")
  @param:Optional
  val backendNodeId: Int? = null,
)
