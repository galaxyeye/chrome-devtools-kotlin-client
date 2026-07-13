@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.emulation

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.emulation.ScreenOrientation
import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when a page calls screen.orientation.lock() or screen.orientation.unlock()
 * while device emulation is enabled. This allows the DevTools frontend to update the
 * emulated device orientation accordingly.
 */
@Serializable
@Experimental
data class ScreenOrientationLockChanged(
  @property:SerialName("locked")
  val locked: Boolean,
  @property:SerialName("orientation")
  @param:Optional
  val orientation: ScreenOrientation? = null,
)
