@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CompileScript(
  @property:SerialName("scriptId")
  @param:Optional
  val scriptId: String? = null,
  @property:SerialName("exceptionDetails")
  @param:Optional
  val exceptionDetails: ExceptionDetails? = null,
)
