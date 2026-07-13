@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.smartcardemulation

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Fired when |SCardReleaseContext| is called.
 *
 * This maps to:
 * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#ga6aabcba7744c5c9419fdd6404f73a934
 * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardreleasecontext
 */
data class ReleaseContextRequested(
  @param:JsonProperty("requestId")
  val requestId: String,
  @param:JsonProperty("contextId")
  val contextId: Int,
)
