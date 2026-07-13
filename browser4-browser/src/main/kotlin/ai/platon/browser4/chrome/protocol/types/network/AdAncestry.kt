@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.network

import ai.platon.browser4.chrome.protocol.support.annotations.Experimental
import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Encapsulates the script ancestry and the root script filter list rule that
 * caused the resource or element to be labeled as an ad.
 */
@Serializable
@Experimental
data class AdAncestry(
  @property:SerialName("ancestryChain")
  val ancestryChain: List<AdScriptIdentifier>,
  @property:SerialName("rootScriptFilterlistRule")
  @param:Optional
  val rootScriptFilterlistRule: String? = null,
)
