package ai.platon.cdt.kt.protocol.types.accessibility

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * A single source for a computed AX property.
 */
public data class AXValueSource(
  @field:JsonProperty("type")
  public val type: AXValueSourceType,
  @field:JsonProperty("value")
  @param:Optional
  public val `value`: AXValue? = null,
  @field:JsonProperty("attribute")
  @param:Optional
  public val attribute: String? = null,
  @field:JsonProperty("attributeValue")
  @param:Optional
  public val attributeValue: AXValue? = null,
  @field:JsonProperty("superseded")
  @param:Optional
  public val superseded: Boolean? = null,
  @field:JsonProperty("nativeSource")
  @param:Optional
  public val nativeSource: AXValueNativeSourceType? = null,
  @field:JsonProperty("nativeSourceValue")
  @param:Optional
  public val nativeSourceValue: AXValue? = null,
  @field:JsonProperty("invalid")
  @param:Optional
  public val invalid: Boolean? = null,
  @field:JsonProperty("invalidReason")
  @param:Optional
  public val invalidReason: String? = null,
)
