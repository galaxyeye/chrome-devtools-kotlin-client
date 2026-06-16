@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.smartcardemulation

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when |SCardControl| is called.
 *
 * This maps to:
 * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#gac3454d4657110fd7f753b2d3d8f4e32f
 * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardcontrol
 */
@Serializable
data class ControlRequested(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("handle")
  val handle: Int,
  @property:SerialName("controlCode")
  val controlCode: Int,
  @property:SerialName("data")
  val `data`: String,
)
