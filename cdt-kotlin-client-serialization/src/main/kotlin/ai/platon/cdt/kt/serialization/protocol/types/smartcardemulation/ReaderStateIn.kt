@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.smartcardemulation

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReaderStateIn(
  @property:SerialName("reader")
  val reader: String,
  @property:SerialName("currentState")
  val currentState: ReaderStateFlags,
  @property:SerialName("currentInsertionCount")
  val currentInsertionCount: Int,
)
