@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.RemoteObject
import kotlin.String
import kotlin.collections.List

/**
 * JavaScript call frame. Array of call frames form the call stack.
 */
@Serializable
data class CallFrame(
  @SerialName("callFrameId")
  val callFrameId: String,
  @SerialName("functionName")
  val functionName: String,
  @SerialName("functionLocation")
  @param:Optional
  val functionLocation: Location? = null,
  @SerialName("location")
  val location: Location,
  @SerialName("url")
  val url: String,
  @SerialName("scopeChain")
  val scopeChain: List<Scope>,
  @SerialName("this")
  val `this`: RemoteObject,
  @SerialName("returnValue")
  @param:Optional
  val returnValue: RemoteObject? = null,
)
