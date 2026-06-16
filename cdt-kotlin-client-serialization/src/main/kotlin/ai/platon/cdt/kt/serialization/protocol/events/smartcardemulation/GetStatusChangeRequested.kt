@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.smartcardemulation

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.smartcardemulation.ReaderStateIn
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when |SCardGetStatusChange| is called. Timeout is specified in milliseconds.
 *
 * This maps to:
 * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#ga33247d5d1257d59e55647c3bb717db24
 * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardgetstatuschangea
 */
@Serializable
data class GetStatusChangeRequested(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("contextId")
  val contextId: Int,
  @property:SerialName("readerStates")
  val readerStates: List<ReaderStateIn>,
  @property:SerialName("timeout")
  @param:Optional
  val timeout: Int? = null,
)
