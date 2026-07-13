@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.smartcardemulation

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

data class ReaderStateIn(
  @param:JsonProperty("reader")
  val reader: String,
  @param:JsonProperty("currentState")
  val currentState: ReaderStateFlags,
  @param:JsonProperty("currentInsertionCount")
  val currentInsertionCount: Int,
)
