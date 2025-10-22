package ai.platon.cdt.kt.protocol.types.debugger

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

data class ScriptSource(
  @field:JsonProperty("scriptSource")
  val scriptSource: String,
  @field:JsonProperty("bytecode")
  @param:Optional
  val bytecode: String? = null,
)
