@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.dom.Node
import kotlin.Int

/**
 * Called when shadow root is pushed into the element.
 */
@Experimental
@Serializable
data class ShadowRootPushed(
  @SerialName("hostId")
  val hostId: Int,
  @SerialName("root")
  val root: Node,
)
