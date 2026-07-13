@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.debugger

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String
import kotlin.collections.List

@Experimental
data class WasmDisassemblyChunk(
  @param:JsonProperty("lines")
  val lines: List<String>,
  @param:JsonProperty("bytecodeOffsets")
  val bytecodeOffsets: List<Int>,
)
