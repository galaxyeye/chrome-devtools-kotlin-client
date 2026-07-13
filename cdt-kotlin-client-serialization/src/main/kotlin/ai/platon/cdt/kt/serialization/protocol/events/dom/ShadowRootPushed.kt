@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.dom.Node
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Called when shadow root is pushed into the element.
 */
@Serializable
@Experimental
data class ShadowRootPushed(
  @property:SerialName("hostId")
  val hostId: Int,
  @property:SerialName("root")
  val root: Node,
)
