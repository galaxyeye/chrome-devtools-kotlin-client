@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.dom.Node
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Called when a pseudo element is added to an element.
 */
@Serializable
@Experimental
data class PseudoElementAdded(
  @property:SerialName("parentId")
  val parentId: Int,
  @property:SerialName("pseudoElement")
  val pseudoElement: Node,
)
