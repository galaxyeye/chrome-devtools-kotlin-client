@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Boolean

/**
 * Fired when the page with currently enabled screencast was shown or hidden `.
 */
@Experimental
@Serializable
data class ScreencastVisibilityChanged(
  @SerialName("visible")
  val visible: Boolean,
)
