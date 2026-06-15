@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.schema
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * Description of the protocol domain.
 */
@Serializable
data class Domain(
  @SerialName("name")
  val name: String,
  @SerialName("version")
  val version: String,
)
