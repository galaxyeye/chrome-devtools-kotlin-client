@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * Encapsulates the script ancestry and the root script filter list rule that
 * caused the resource or element to be labeled as an ad.
 */
@Experimental
data class AdAncestry(
  @param:JsonProperty("ancestryChain")
  val ancestryChain: List<AdScriptIdentifier>,
  @param:JsonProperty("rootScriptFilterlistRule")
  @param:Optional
  val rootScriptFilterlistRule: String? = null,
)
