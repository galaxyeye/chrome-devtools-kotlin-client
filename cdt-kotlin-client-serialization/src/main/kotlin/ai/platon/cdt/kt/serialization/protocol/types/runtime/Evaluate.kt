@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional

@Serializable
data class Evaluate(
  @SerialName("result")
  val result: RemoteObject,
  @SerialName("exceptionDetails")
  @param:Optional
  val exceptionDetails: ExceptionDetails? = null,
)
