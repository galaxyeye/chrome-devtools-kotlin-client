@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.smartcardemulation

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.smartcardemulation.Protocol
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Fired when |SCardTransmit| is called.
 *
 * This maps to:
 * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#ga9a2d77242a271310269065e64633ab99
 * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardtransmit
 */
data class TransmitRequested(
  @param:JsonProperty("requestId")
  val requestId: String,
  @param:JsonProperty("handle")
  val handle: Int,
  @param:JsonProperty("data")
  val `data`: String,
  @param:JsonProperty("protocol")
  @param:Optional
  val protocol: Protocol? = null,
)
