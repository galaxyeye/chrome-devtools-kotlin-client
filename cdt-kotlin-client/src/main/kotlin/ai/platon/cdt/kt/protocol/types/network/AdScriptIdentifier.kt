@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Identifies the script on the stack that caused a resource or element to be
 * labeled as an ad. For resources, this indicates the context that triggered
 * the fetch. For elements, this indicates the context that caused the element
 * to be appended to the DOM.
 */
@Experimental
data class AdScriptIdentifier(
  @param:JsonProperty("scriptId")
  val scriptId: String,
  @param:JsonProperty("debuggerId")
  val debuggerId: String,
  @param:JsonProperty("name")
  val name: String,
)
