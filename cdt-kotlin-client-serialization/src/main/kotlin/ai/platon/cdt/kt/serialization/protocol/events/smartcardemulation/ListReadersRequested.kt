@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.smartcardemulation

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when |SCardListReaders| is called.
 *
 * This maps to:
 * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#ga93b07815789b3cf2629d439ecf20f0d9
 * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardlistreadersa
 */
@Serializable
data class ListReadersRequested(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("contextId")
  val contextId: Int,
)
