@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.autofill

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

/**
 * A list of address fields.
 */
data class AddressFields(
  @param:JsonProperty("fields")
  val fields: List<AddressField>,
)
