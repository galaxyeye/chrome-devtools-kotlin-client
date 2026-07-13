@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.debugger

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String
import kotlin.collections.List

data class DisassembleWasmModule(
  @param:JsonProperty("streamId")
  @param:Optional
  val streamId: String? = null,
  @param:JsonProperty("totalNumberOfLines")
  val totalNumberOfLines: Int,
  @param:JsonProperty("functionBodyOffsets")
  val functionBodyOffsets: List<Int>,
  @param:JsonProperty("chunk")
  val chunk: WasmDisassemblyChunk,
)
