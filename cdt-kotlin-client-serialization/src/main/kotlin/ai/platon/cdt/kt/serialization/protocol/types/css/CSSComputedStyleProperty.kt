@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

@Serializable
data class CSSComputedStyleProperty(
  @SerialName("name")
  val name: String,
  @SerialName("value")
  val `value`: String,
)
