package ai.platon.cdt.kt.protocol.types.storage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.collections.List

data class UsageAndQuota(
  @field:JsonProperty("usage")
  val usage: Double,
  @field:JsonProperty("quota")
  val quota: Double,
  @field:JsonProperty("overrideActive")
  val overrideActive: Boolean,
  @field:JsonProperty("usageBreakdown")
  val usageBreakdown: List<UsageForType>,
)
