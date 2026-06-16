@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.RemoteObject
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * JavaScript call frame. Array of call frames form the call stack.
 */
@Serializable
data class CallFrame(
  @property:SerialName("callFrameId")
  val callFrameId: String,
  @property:SerialName("functionName")
  val functionName: String,
  @property:SerialName("functionLocation")
  @param:Optional
  val functionLocation: Location? = null,
  @property:SerialName("location")
  val location: Location,
  @property:SerialName("url")
  val url: String,
  @property:SerialName("scopeChain")
  val scopeChain: List<Scope>,
  @property:SerialName("this")
  val `this`: RemoteObject,
  @property:SerialName("returnValue")
  @param:Optional
  val returnValue: RemoteObject? = null,
)
