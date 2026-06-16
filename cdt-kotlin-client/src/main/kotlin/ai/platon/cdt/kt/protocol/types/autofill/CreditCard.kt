@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.autofill

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

data class CreditCard(
  @param:JsonProperty("number")
  val number: String,
  @param:JsonProperty("name")
  val name: String,
  @param:JsonProperty("expiryMonth")
  val expiryMonth: String,
  @param:JsonProperty("expiryYear")
  val expiryYear: String,
  @param:JsonProperty("cvc")
  val cvc: String,
)
