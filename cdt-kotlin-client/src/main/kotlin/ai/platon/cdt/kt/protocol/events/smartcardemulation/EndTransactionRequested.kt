@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.smartcardemulation

import ai.platon.cdt.kt.protocol.types.smartcardemulation.Disposition
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Fired when |SCardEndTransaction| is called.
 *
 * This maps to:
 * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#gae8742473b404363e5c587f570d7e2f3b
 * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardendtransaction
 */
data class EndTransactionRequested(
  @param:JsonProperty("requestId")
  val requestId: String,
  @param:JsonProperty("handle")
  val handle: Int,
  @param:JsonProperty("disposition")
  val disposition: Disposition,
)
