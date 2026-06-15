@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int

/**
 * Called when a pseudo element is removed from an element.
 */
@Experimental
@Serializable
data class PseudoElementRemoved(
  @SerialName("parentId")
  val parentId: Int,
  @SerialName("pseudoElementId")
  val pseudoElementId: Int,
)
