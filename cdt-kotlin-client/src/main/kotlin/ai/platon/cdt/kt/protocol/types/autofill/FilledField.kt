@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.autofill

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

data class FilledField(
  @param:JsonProperty("htmlType")
  val htmlType: String,
  @param:JsonProperty("id")
  val id: String,
  @param:JsonProperty("name")
  val name: String,
  @param:JsonProperty("value")
  val `value`: String,
  @param:JsonProperty("autofillType")
  val autofillType: String,
  @param:JsonProperty("fillingStrategy")
  val fillingStrategy: FillingStrategy,
  @param:JsonProperty("frameId")
  val frameId: String,
  @param:JsonProperty("fieldId")
  val fieldId: Int,
)
