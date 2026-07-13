@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShorthandEntry(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("value")
  val `value`: String,
  @property:SerialName("important")
  @param:Optional
  val important: Boolean? = null,
)
