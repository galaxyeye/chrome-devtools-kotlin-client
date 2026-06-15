@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String

@Serializable
data class ScriptSource(
  @SerialName("scriptSource")
  val scriptSource: String,
  @SerialName("bytecode")
  @param:Optional
  val bytecode: String? = null,
)
