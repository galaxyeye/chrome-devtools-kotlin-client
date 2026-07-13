@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ScriptSource(
  @property:SerialName("scriptSource")
  val scriptSource: String,
  @property:SerialName("bytecode")
  @param:Optional
  val bytecode: String? = null,
)
