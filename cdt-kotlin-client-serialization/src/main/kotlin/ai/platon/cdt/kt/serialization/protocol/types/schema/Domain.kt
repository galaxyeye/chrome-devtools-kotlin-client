@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.schema

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Description of the protocol domain.
 */
@Serializable
data class Domain(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("version")
  val version: String,
)
