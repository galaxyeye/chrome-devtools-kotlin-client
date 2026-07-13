@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class ContentSecurityPolicyStatus(
  @property:SerialName("effectiveDirectives")
  val effectiveDirectives: String,
  @property:SerialName("isEnforced")
  val isEnforced: Boolean,
  @property:SerialName("source")
  val source: ContentSecurityPolicySource,
)
