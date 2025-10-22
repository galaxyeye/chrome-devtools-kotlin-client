package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty

data class AwaitPromise(
  @field:JsonProperty("result")
  val result: RemoteObject,
  @field:JsonProperty("exceptionDetails")
  @param:Optional
  val exceptionDetails: ExceptionDetails? = null,
)
