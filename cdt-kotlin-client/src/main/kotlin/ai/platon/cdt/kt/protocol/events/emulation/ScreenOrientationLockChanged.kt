@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.emulation

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.emulation.ScreenOrientation
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

/**
 * Fired when a page calls screen.orientation.lock() or screen.orientation.unlock()
 * while device emulation is enabled. This allows the DevTools frontend to update the
 * emulated device orientation accordingly.
 */
@Experimental
data class ScreenOrientationLockChanged(
  @param:JsonProperty("locked")
  val locked: Boolean,
  @param:JsonProperty("orientation")
  @param:Optional
  val orientation: ScreenOrientation? = null,
)
