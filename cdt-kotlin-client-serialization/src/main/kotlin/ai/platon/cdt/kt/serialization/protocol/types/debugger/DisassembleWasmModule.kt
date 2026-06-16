@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DisassembleWasmModule(
  @property:SerialName("streamId")
  @param:Optional
  val streamId: String? = null,
  @property:SerialName("totalNumberOfLines")
  val totalNumberOfLines: Int,
  @property:SerialName("functionBodyOffsets")
  val functionBodyOffsets: List<Int>,
  @property:SerialName("chunk")
  val chunk: WasmDisassemblyChunk,
)
