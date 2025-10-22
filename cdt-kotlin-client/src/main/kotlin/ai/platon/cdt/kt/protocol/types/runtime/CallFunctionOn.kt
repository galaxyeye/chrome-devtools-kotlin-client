package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty

public data class CallFunctionOn(
  @field:JsonProperty("result")
  public val result: RemoteObject,
  @field:JsonProperty("exceptionDetails")
  @param:Optional
  public val exceptionDetails: ExceptionDetails? = null,
)
