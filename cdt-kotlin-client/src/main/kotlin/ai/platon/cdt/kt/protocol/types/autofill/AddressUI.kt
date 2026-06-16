@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.autofill

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

/**
 * Defines how an address can be displayed like in chrome://settings/addresses.
 * Address UI is a two dimensional array, each inner array is an "address information line", and when rendered in a UI surface should be displayed as such.
 * The following address UI for instance:
 * [[{name: "GIVE_NAME", value: "Jon"}, {name: "FAMILY_NAME", value: "Doe"}], [{name: "CITY", value: "Munich"}, {name: "ZIP", value: "81456"}]]
 * should allow the receiver to render:
 * Jon Doe
 * Munich 81456
 */
data class AddressUI(
  @param:JsonProperty("addressFields")
  val addressFields: List<AddressFields>,
)
