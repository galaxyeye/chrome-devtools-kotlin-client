@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.autofill

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilledField(
  @property:SerialName("htmlType")
  val htmlType: String,
  @property:SerialName("id")
  val id: String,
  @property:SerialName("name")
  val name: String,
  @property:SerialName("value")
  val `value`: String,
  @property:SerialName("autofillType")
  val autofillType: String,
  @property:SerialName("fillingStrategy")
  val fillingStrategy: FillingStrategy,
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("fieldId")
  val fieldId: Int,
)
