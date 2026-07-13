@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.autofill

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreditCard(
  @property:SerialName("number")
  val number: String,
  @property:SerialName("name")
  val name: String,
  @property:SerialName("expiryMonth")
  val expiryMonth: String,
  @property:SerialName("expiryYear")
  val expiryYear: String,
  @property:SerialName("cvc")
  val cvc: String,
)
