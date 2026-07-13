@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.smartcardemulation

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when |SCardGetAttrib| is called.
 *
 * This maps to:
 * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#gaacfec51917255b7a25b94c5104961602
 * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardgetattrib
 */
@Serializable
data class GetAttribRequested(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("handle")
  val handle: Int,
  @property:SerialName("attribId")
  val attribId: Int,
)
