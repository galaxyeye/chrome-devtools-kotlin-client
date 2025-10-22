package ai.platon.cdt.kt.protocol.types.storage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.collections.List

public data class UsageAndQuota(
  @field:JsonProperty("usage")
  public val usage: Double,
  @field:JsonProperty("quota")
  public val quota: Double,
  @field:JsonProperty("overrideActive")
  public val overrideActive: Boolean,
  @field:JsonProperty("usageBreakdown")
  public val usageBreakdown: List<UsageForType>,
)
