@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.storage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Boolean
import kotlin.Double
import kotlin.collections.List

@Serializable
data class UsageAndQuota(
  @SerialName("usage")
  val usage: Double,
  @SerialName("quota")
  val quota: Double,
  @SerialName("overrideActive")
  val overrideActive: Boolean,
  @SerialName("usageBreakdown")
  val usageBreakdown: List<UsageForType>,
)
