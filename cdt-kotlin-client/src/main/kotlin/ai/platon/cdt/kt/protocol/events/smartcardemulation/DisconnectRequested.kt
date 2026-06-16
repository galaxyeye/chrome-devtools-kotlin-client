@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.smartcardemulation

import ai.platon.cdt.kt.protocol.types.smartcardemulation.Disposition
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Fired when |SCardDisconnect| is called.
 *
 * This maps to:
 * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#ga4be198045c73ec0deb79e66c0ca1738a
 * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scarddisconnect
 */
data class DisconnectRequested(
  @param:JsonProperty("requestId")
  val requestId: String,
  @param:JsonProperty("handle")
  val handle: Int,
  @param:JsonProperty("disposition")
  val disposition: Disposition,
)
