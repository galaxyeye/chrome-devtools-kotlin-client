@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * CSS function argument representation.
 */
@Serializable
data class CSSFunctionParameter(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("type")
  val type: String,
)
