@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.storage

import kotlin.Boolean
import kotlin.Double
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UsageAndQuota(
  @property:SerialName("usage")
  val usage: Double,
  @property:SerialName("quota")
  val quota: Double,
  @property:SerialName("overrideActive")
  val overrideActive: Boolean,
  @property:SerialName("usageBreakdown")
  val usageBreakdown: List<UsageForType>,
)
