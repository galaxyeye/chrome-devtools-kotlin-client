@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Called when shadow root is popped from the element.
 */
@Serializable
@Experimental
data class ShadowRootPopped(
  @property:SerialName("hostId")
  val hostId: Int,
  @property:SerialName("rootId")
  val rootId: Int,
)
