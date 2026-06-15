@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int

/**
 * Called when shadow root is popped from the element.
 */
@Experimental
@Serializable
data class ShadowRootPopped(
  @SerialName("hostId")
  val hostId: Int,
  @SerialName("rootId")
  val rootId: Int,
)
