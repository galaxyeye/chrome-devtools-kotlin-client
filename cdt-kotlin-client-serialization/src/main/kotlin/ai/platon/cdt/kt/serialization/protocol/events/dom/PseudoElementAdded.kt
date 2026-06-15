@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.dom.Node
import kotlin.Int

/**
 * Called when a pseudo element is added to an element.
 */
@Experimental
@Serializable
data class PseudoElementAdded(
  @SerialName("parentId")
  val parentId: Int,
  @SerialName("pseudoElement")
  val pseudoElement: Node,
)
