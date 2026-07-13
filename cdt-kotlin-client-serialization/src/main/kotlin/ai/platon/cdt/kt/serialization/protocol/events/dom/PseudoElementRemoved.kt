@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Called when a pseudo element is removed from an element.
 */
@Serializable
@Experimental
data class PseudoElementRemoved(
  @property:SerialName("parentId")
  val parentId: Int,
  @property:SerialName("pseudoElementId")
  val pseudoElementId: Int,
)
