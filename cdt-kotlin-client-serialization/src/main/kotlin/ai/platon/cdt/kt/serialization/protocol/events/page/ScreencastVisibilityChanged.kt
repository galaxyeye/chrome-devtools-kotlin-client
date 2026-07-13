@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when the page with currently enabled screencast was shown or hidden `.
 */
@Serializable
@Experimental
data class ScreencastVisibilityChanged(
  @property:SerialName("visible")
  val visible: Boolean,
)
