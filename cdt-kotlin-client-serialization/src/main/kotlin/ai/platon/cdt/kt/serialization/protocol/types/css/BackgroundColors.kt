@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List

@Serializable
data class BackgroundColors(
  @SerialName("backgroundColors")
  @param:Optional
  val backgroundColors: List<String>? = null,
  @SerialName("computedFontSize")
  @param:Optional
  val computedFontSize: String? = null,
  @SerialName("computedFontWeight")
  @param:Optional
  val computedFontWeight: String? = null,
)
