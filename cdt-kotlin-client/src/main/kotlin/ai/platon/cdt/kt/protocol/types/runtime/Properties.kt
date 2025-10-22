package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

data class Properties(
  @field:JsonProperty("result")
  val result: List<PropertyDescriptor>,
  @field:JsonProperty("internalProperties")
  @param:Optional
  val internalProperties: List<InternalPropertyDescriptor>? = null,
  @field:JsonProperty("privateProperties")
  @param:Optional
  @param:Experimental
  val privateProperties: List<PrivatePropertyDescriptor>? = null,
  @field:JsonProperty("exceptionDetails")
  @param:Optional
  val exceptionDetails: ExceptionDetails? = null,
)
