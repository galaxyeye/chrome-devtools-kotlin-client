package ai.platon.cdt.kt.protocol.types.accessibility

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * A single source for a computed AX property.
 */
data class AXValueSource(
  @field:JsonProperty("type")
  val type: AXValueSourceType,
  @field:JsonProperty("value")
  @param:Optional
  val `value`: AXValue? = null,
  @field:JsonProperty("attribute")
  @param:Optional
  val attribute: String? = null,
  @field:JsonProperty("attributeValue")
  @param:Optional
  val attributeValue: AXValue? = null,
  @field:JsonProperty("superseded")
  @param:Optional
  val superseded: Boolean? = null,
  @field:JsonProperty("nativeSource")
  @param:Optional
  val nativeSource: AXValueNativeSourceType? = null,
  @field:JsonProperty("nativeSourceValue")
  @param:Optional
  val nativeSourceValue: AXValue? = null,
  @field:JsonProperty("invalid")
  @param:Optional
  val invalid: Boolean? = null,
  @field:JsonProperty("invalidReason")
  @param:Optional
  val invalidReason: String? = null,
)
