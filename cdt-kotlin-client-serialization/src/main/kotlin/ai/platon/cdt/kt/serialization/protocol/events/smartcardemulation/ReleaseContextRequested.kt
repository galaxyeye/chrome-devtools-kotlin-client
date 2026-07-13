@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.smartcardemulation

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when |SCardReleaseContext| is called.
 *
 * This maps to:
 * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#ga6aabcba7744c5c9419fdd6404f73a934
 * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardreleasecontext
 */
@Serializable
data class ReleaseContextRequested(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("contextId")
  val contextId: Int,
)
