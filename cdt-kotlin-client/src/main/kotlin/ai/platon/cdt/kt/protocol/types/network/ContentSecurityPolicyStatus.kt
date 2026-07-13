@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

@Experimental
data class ContentSecurityPolicyStatus(
  @param:JsonProperty("effectiveDirectives")
  val effectiveDirectives: String,
  @param:JsonProperty("isEnforced")
  val isEnforced: Boolean,
  @param:JsonProperty("source")
  val source: ContentSecurityPolicySource,
)
