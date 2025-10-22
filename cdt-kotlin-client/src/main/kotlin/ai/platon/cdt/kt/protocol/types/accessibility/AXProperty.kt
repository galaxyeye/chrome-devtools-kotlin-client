package ai.platon.cdt.kt.protocol.types.accessibility

import com.fasterxml.jackson.`annotation`.JsonProperty

data class AXProperty(
  @field:JsonProperty("name")
  val name: AXPropertyName,
  @field:JsonProperty("value")
  val `value`: AXValue,
)
