@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Screen information similar to the one returned by window.getScreenDetails() method,
 * see https://w3c.github.io/window-management/#screendetailed.
 */
@Serializable
@Experimental
data class ScreenInfo(
  @property:SerialName("left")
  val left: Int,
  @property:SerialName("top")
  val top: Int,
  @property:SerialName("width")
  val width: Int,
  @property:SerialName("height")
  val height: Int,
  @property:SerialName("availLeft")
  val availLeft: Int,
  @property:SerialName("availTop")
  val availTop: Int,
  @property:SerialName("availWidth")
  val availWidth: Int,
  @property:SerialName("availHeight")
  val availHeight: Int,
  @property:SerialName("devicePixelRatio")
  val devicePixelRatio: Double,
  @property:SerialName("orientation")
  val orientation: ScreenOrientation,
  @property:SerialName("colorDepth")
  val colorDepth: Int,
  @property:SerialName("isExtended")
  val isExtended: Boolean,
  @property:SerialName("isInternal")
  val isInternal: Boolean,
  @property:SerialName("isPrimary")
  val isPrimary: Boolean,
  @property:SerialName("label")
  val label: String,
  @property:SerialName("id")
  val id: String,
)
