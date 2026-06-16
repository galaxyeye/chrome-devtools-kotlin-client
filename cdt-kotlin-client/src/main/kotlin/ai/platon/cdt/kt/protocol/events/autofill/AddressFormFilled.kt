@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.autofill

import ai.platon.cdt.kt.protocol.types.autofill.AddressUI
import ai.platon.cdt.kt.protocol.types.autofill.FilledField
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

/**
 * Emitted when an address form is filled.
 */
data class AddressFormFilled(
  @param:JsonProperty("filledFields")
  val filledFields: List<FilledField>,
  @param:JsonProperty("addressUi")
  val addressUi: AddressUI,
)
