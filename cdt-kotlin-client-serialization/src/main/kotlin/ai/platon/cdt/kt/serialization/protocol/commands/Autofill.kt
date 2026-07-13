@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.commands

import ai.platon.cdt.kt.serialization.protocol.events.autofill.AddressFormFilled
import ai.platon.cdt.kt.serialization.protocol.support.annotations.EventName
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.support.annotations.ParamName
import ai.platon.cdt.kt.serialization.protocol.support.types.EventHandler
import ai.platon.cdt.kt.serialization.protocol.support.types.EventListener
import ai.platon.cdt.kt.serialization.protocol.types.autofill.Address
import ai.platon.cdt.kt.serialization.protocol.types.autofill.CreditCard
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

/**
 * Defines commands and events for Autofill.
 */
@Experimental
interface Autofill {
  /**
   * Trigger autofill on a form identified by the fieldId.
   * If the field and related form cannot be autofilled, returns an error.
   * @param fieldId Identifies a field that serves as an anchor for autofill.
   * @param frameId Identifies the frame that field belongs to.
   * @param card Credit card information to fill out the form. Credit card data is not saved.  Mutually exclusive with `address`.
   * @param address Address to fill out the form. Address data is not saved. Mutually exclusive with `card`.
   */
  suspend fun trigger(
    @ParamName("fieldId") fieldId: Int,
    @ParamName("frameId") @Optional frameId: String? = null,
    @ParamName("card") @Optional card: CreditCard? = null,
    @ParamName("address") @Optional address: Address? = null,
  )

  suspend fun trigger(@ParamName("fieldId") fieldId: Int) {
    return trigger(fieldId, null, null, null)
  }

  /**
   * Set addresses so that developers can verify their forms implementation.
   * @param addresses
   */
  suspend fun setAddresses(@ParamName("addresses") addresses: List<Address>)

  /**
   * Disables autofill domain notifications.
   */
  suspend fun disable()

  /**
   * Enables autofill domain notifications.
   */
  suspend fun enable()

  @EventName("addressFormFilled")
  fun onAddressFormFilled(eventListener: EventHandler<AddressFormFilled>): EventListener

  @EventName("addressFormFilled")
  fun onAddressFormFilled(eventListener: suspend (AddressFormFilled) -> Unit): EventListener
}
