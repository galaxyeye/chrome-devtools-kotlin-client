@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.smartcardemulation

import ai.platon.cdt.kt.serialization.protocol.types.smartcardemulation.Disposition
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when |SCardDisconnect| is called.
 *
 * This maps to:
 * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#ga4be198045c73ec0deb79e66c0ca1738a
 * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scarddisconnect
 */
@Serializable
data class DisconnectRequested(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("handle")
  val handle: Int,
  @property:SerialName("disposition")
  val disposition: Disposition,
)
