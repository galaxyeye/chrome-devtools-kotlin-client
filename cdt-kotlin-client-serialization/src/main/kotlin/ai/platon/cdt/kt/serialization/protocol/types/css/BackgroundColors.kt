@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BackgroundColors(
  @property:SerialName("backgroundColors")
  @param:Optional
  val backgroundColors: List<String>? = null,
  @property:SerialName("computedFontSize")
  @param:Optional
  val computedFontSize: String? = null,
  @property:SerialName("computedFontWeight")
  @param:Optional
  val computedFontWeight: String? = null,
)
