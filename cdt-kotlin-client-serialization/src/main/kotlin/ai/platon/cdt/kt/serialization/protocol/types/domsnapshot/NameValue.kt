@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domsnapshot
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * A name/value pair.
 */
@Serializable
data class NameValue(
  @SerialName("name")
  val name: String,
  @SerialName("value")
  val `value`: String,
)
