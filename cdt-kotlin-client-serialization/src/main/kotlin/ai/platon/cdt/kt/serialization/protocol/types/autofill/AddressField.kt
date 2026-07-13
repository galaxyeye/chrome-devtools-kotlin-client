@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.autofill

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddressField(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("value")
  val `value`: String,
)
