package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

public data class CompileScript(
  @field:JsonProperty("scriptId")
  @param:Optional
  public val scriptId: String? = null,
  @field:JsonProperty("exceptionDetails")
  @param:Optional
  public val exceptionDetails: ExceptionDetails? = null,
)
