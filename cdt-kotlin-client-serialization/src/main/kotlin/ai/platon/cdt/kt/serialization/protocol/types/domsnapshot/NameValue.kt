@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domsnapshot

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A name/value pair.
 */
@Serializable
data class NameValue(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("value")
  val `value`: String,
)
