@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.autofill

import ai.platon.cdt.kt.serialization.protocol.types.autofill.AddressUI
import ai.platon.cdt.kt.serialization.protocol.types.autofill.FilledField
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Emitted when an address form is filled.
 */
@Serializable
data class AddressFormFilled(
  @property:SerialName("filledFields")
  val filledFields: List<FilledField>,
  @property:SerialName("addressUi")
  val addressUi: AddressUI,
)
