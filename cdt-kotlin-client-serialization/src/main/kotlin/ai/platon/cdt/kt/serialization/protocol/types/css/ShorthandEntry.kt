@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String

@Serializable
data class ShorthandEntry(
  @SerialName("name")
  val name: String,
  @SerialName("value")
  val `value`: String,
  @SerialName("important")
  @param:Optional
  val important: Boolean? = null,
)
