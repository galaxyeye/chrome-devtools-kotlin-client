@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.smartcardemulation

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

data class ReaderStateOut(
  @param:JsonProperty("reader")
  val reader: String,
  @param:JsonProperty("eventState")
  val eventState: ReaderStateFlags,
  @param:JsonProperty("eventCount")
  val eventCount: Int,
  @param:JsonProperty("atr")
  val atr: String,
)
