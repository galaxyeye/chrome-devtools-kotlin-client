@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.autofill

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

data class AddressField(
  @param:JsonProperty("name")
  val name: String,
  @param:JsonProperty("value")
  val `value`: String,
)
