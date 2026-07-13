@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.smartcardemulation

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.smartcardemulation.Protocol
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when |SCardTransmit| is called.
 *
 * This maps to:
 * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#ga9a2d77242a271310269065e64633ab99
 * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardtransmit
 */
@Serializable
data class TransmitRequested(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("handle")
  val handle: Int,
  @property:SerialName("data")
  val `data`: String,
  @property:SerialName("protocol")
  @param:Optional
  val protocol: Protocol? = null,
)
