@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.smartcardemulation

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Fired when |SCardSetAttrib| is called.
 *
 * This maps to:
 * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#ga060f0038a4ddfd5dd2b8fadf3c3a2e4f
 * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardsetattrib
 */
data class SetAttribRequested(
  @param:JsonProperty("requestId")
  val requestId: String,
  @param:JsonProperty("handle")
  val handle: Int,
  @param:JsonProperty("attribId")
  val attribId: Int,
  @param:JsonProperty("data")
  val `data`: String,
)
