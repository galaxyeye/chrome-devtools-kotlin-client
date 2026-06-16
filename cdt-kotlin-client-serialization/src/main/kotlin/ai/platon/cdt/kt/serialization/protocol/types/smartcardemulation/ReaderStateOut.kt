@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.smartcardemulation

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReaderStateOut(
  @property:SerialName("reader")
  val reader: String,
  @property:SerialName("eventState")
  val eventState: ReaderStateFlags,
  @property:SerialName("eventCount")
  val eventCount: Int,
  @property:SerialName("atr")
  val atr: String,
)
