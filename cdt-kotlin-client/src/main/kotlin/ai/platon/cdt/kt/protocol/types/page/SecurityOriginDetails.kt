@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

/**
 * Additional information about the frame document's security origin.
 */
@Experimental
data class SecurityOriginDetails(
  @param:JsonProperty("isLocalhost")
  val isLocalhost: Boolean,
)
