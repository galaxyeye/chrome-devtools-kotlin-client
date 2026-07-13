@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.smartcardemulation

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Fired when |SCardCancel| is called.
 *
 * This maps to:
 * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#gaacbbc0c6d6c0cbbeb4f4debf6fbeeee6
 * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardcancel
 */
data class CancelRequested(
  @param:JsonProperty("requestId")
  val requestId: String,
  @param:JsonProperty("contextId")
  val contextId: Int,
)
