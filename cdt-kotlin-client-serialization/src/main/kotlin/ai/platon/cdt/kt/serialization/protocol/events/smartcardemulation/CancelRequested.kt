@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.smartcardemulation

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when |SCardCancel| is called.
 *
 * This maps to:
 * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#gaacbbc0c6d6c0cbbeb4f4debf6fbeeee6
 * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardcancel
 */
@Serializable
data class CancelRequested(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("contextId")
  val contextId: Int,
)
