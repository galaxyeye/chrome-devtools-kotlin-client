@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.smartcardemulation

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when |SCardBeginTransaction| is called.
 *
 * This maps to:
 * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#gaddb835dce01a0da1d6ca02d33ee7d861
 * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardbegintransaction
 */
@Serializable
data class BeginTransactionRequested(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("handle")
  val handle: Int,
)
