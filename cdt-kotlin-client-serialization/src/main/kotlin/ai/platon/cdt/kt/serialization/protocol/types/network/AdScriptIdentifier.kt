@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Identifies the script on the stack that caused a resource or element to be
 * labeled as an ad. For resources, this indicates the context that triggered
 * the fetch. For elements, this indicates the context that caused the element
 * to be appended to the DOM.
 */
@Serializable
@Experimental
data class AdScriptIdentifier(
  @property:SerialName("scriptId")
  val scriptId: String,
  @property:SerialName("debuggerId")
  val debuggerId: String,
  @property:SerialName("name")
  val name: String,
)
