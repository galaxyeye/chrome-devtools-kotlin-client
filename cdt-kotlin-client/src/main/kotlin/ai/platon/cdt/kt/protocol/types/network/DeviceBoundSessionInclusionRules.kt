@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

/**
 * A device bound session's inclusion rules.
 */
@Experimental
data class DeviceBoundSessionInclusionRules(
  @param:JsonProperty("origin")
  val origin: String,
  @param:JsonProperty("includeSite")
  val includeSite: Boolean,
  @param:JsonProperty("urlRules")
  val urlRules: List<DeviceBoundSessionUrlRule>,
)
