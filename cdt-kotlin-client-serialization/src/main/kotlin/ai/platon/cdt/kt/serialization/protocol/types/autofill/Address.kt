@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.autofill

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Address(
  @property:SerialName("fields")
  val fields: List<AddressField>,
)
