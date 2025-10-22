package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

public data class Properties(
  @field:JsonProperty("result")
  public val result: List<PropertyDescriptor>,
  @field:JsonProperty("internalProperties")
  @param:Optional
  public val internalProperties: List<InternalPropertyDescriptor>? = null,
  @field:JsonProperty("privateProperties")
  @param:Optional
  @param:Experimental
  public val privateProperties: List<PrivatePropertyDescriptor>? = null,
  @field:JsonProperty("exceptionDetails")
  @param:Optional
  public val exceptionDetails: ExceptionDetails? = null,
)
