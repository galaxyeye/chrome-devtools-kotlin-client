@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.emulation

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * Screen information similar to the one returned by window.getScreenDetails() method,
 * see https://w3c.github.io/window-management/#screendetailed.
 */
@Experimental
data class ScreenInfo(
  @param:JsonProperty("left")
  val left: Int,
  @param:JsonProperty("top")
  val top: Int,
  @param:JsonProperty("width")
  val width: Int,
  @param:JsonProperty("height")
  val height: Int,
  @param:JsonProperty("availLeft")
  val availLeft: Int,
  @param:JsonProperty("availTop")
  val availTop: Int,
  @param:JsonProperty("availWidth")
  val availWidth: Int,
  @param:JsonProperty("availHeight")
  val availHeight: Int,
  @param:JsonProperty("devicePixelRatio")
  val devicePixelRatio: Double,
  @param:JsonProperty("orientation")
  val orientation: ScreenOrientation,
  @param:JsonProperty("colorDepth")
  val colorDepth: Int,
  @param:JsonProperty("isExtended")
  val isExtended: Boolean,
  @param:JsonProperty("isInternal")
  val isInternal: Boolean,
  @param:JsonProperty("isPrimary")
  val isPrimary: Boolean,
  @param:JsonProperty("label")
  val label: String,
  @param:JsonProperty("id")
  val id: String,
)
