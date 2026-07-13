@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.smartcardemulation

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Fired when |SCardControl| is called.
 *
 * This maps to:
 * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#gac3454d4657110fd7f753b2d3d8f4e32f
 * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardcontrol
 */
data class ControlRequested(
  @param:JsonProperty("requestId")
  val requestId: String,
  @param:JsonProperty("handle")
  val handle: Int,
  @param:JsonProperty("controlCode")
  val controlCode: Int,
  @param:JsonProperty("data")
  val `data`: String,
)
