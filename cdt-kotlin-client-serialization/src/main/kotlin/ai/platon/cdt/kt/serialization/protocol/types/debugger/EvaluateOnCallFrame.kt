@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.ExceptionDetails
import ai.platon.cdt.kt.serialization.protocol.types.runtime.RemoteObject

@Serializable
data class EvaluateOnCallFrame(
  @SerialName("result")
  val result: RemoteObject,
  @SerialName("exceptionDetails")
  @param:Optional
  val exceptionDetails: ExceptionDetails? = null,
)
