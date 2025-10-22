package ai.platon.cdt.kt.protocol.types.accessibility

import com.fasterxml.jackson.`annotation`.JsonProperty

public data class AXProperty(
  @field:JsonProperty("name")
  public val name: AXPropertyName,
  @field:JsonProperty("value")
  public val `value`: AXValue,
)
