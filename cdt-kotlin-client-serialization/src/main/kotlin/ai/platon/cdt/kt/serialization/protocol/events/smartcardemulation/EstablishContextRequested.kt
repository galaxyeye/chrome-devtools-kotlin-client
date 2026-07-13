@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.smartcardemulation

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when |SCardEstablishContext| is called.
 *
 * This maps to:
 * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#gaa1b8970169fd4883a6dc4a8f43f19b67
 * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardestablishcontext
 */
@Serializable
data class EstablishContextRequested(
  @property:SerialName("requestId")
  val requestId: String,
)
