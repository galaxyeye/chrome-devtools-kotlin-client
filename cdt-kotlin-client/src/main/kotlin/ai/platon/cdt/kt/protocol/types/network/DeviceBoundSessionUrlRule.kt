@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * A device bound session's inclusion URL rule.
 */
@Experimental
data class DeviceBoundSessionUrlRule(
  @param:JsonProperty("ruleType")
  val ruleType: DeviceBoundSessionUrlRuleRuleType,
  @param:JsonProperty("hostPattern")
  val hostPattern: String,
  @param:JsonProperty("pathPrefix")
  val pathPrefix: String,
)
