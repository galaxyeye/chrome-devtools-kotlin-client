@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class WasmDisassemblyChunk(
  @property:SerialName("lines")
  val lines: List<String>,
  @property:SerialName("bytecodeOffsets")
  val bytecodeOffsets: List<Int>,
)
