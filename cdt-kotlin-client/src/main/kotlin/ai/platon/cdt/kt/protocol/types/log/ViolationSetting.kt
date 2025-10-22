package ai.platon.cdt.kt.protocol.types.log

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

/**
 * Violation configuration setting.
 */
public data class ViolationSetting(
  @field:JsonProperty("name")
  public val name: ViolationSettingName,
  @field:JsonProperty("threshold")
  public val threshold: Double,
)
