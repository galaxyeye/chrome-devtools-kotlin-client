@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.autofill

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A list of address fields.
 */
@Serializable
data class AddressFields(
  @property:SerialName("fields")
  val fields: List<AddressField>,
)
