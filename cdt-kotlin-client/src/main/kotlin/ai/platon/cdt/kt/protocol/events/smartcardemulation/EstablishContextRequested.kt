@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.smartcardemulation

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Fired when |SCardEstablishContext| is called.
 *
 * This maps to:
 * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#gaa1b8970169fd4883a6dc4a8f43f19b67
 * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardestablishcontext
 */
data class EstablishContextRequested(
  @param:JsonProperty("requestId")
  val requestId: String,
)
