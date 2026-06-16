@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A device bound session's inclusion URL rule.
 */
@Serializable
@Experimental
data class DeviceBoundSessionUrlRule(
  @property:SerialName("ruleType")
  val ruleType: DeviceBoundSessionUrlRuleRuleType,
  @property:SerialName("hostPattern")
  val hostPattern: String,
  @property:SerialName("pathPrefix")
  val pathPrefix: String,
)
