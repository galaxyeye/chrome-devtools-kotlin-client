@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.smartcardemulation

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.smartcardemulation.ReaderStateIn
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Fired when |SCardGetStatusChange| is called. Timeout is specified in milliseconds.
 *
 * This maps to:
 * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#ga33247d5d1257d59e55647c3bb717db24
 * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardgetstatuschangea
 */
data class GetStatusChangeRequested(
  @param:JsonProperty("requestId")
  val requestId: String,
  @param:JsonProperty("contextId")
  val contextId: Int,
  @param:JsonProperty("readerStates")
  val readerStates: List<ReaderStateIn>,
  @param:JsonProperty("timeout")
  @param:Optional
  val timeout: Int? = null,
)
