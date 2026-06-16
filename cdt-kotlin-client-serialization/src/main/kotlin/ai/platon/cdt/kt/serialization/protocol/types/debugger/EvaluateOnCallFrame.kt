@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.ExceptionDetails
import ai.platon.cdt.kt.serialization.protocol.types.runtime.RemoteObject
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EvaluateOnCallFrame(
  @property:SerialName("result")
  val result: RemoteObject,
  @property:SerialName("exceptionDetails")
  @param:Optional
  val exceptionDetails: ExceptionDetails? = null,
)
