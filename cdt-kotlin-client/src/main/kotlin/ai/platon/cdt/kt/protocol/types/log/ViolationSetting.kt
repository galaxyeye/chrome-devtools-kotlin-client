package ai.platon.cdt.kt.protocol.types.log

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

/**
 * Violation configuration setting.
 */
data class ViolationSetting(
  @field:JsonProperty("name")
  val name: ViolationSettingName,
  @field:JsonProperty("threshold")
  val threshold: Double,
)
