@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.animation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List

/**
 * Keyframes Rule
 */
@Serializable
data class KeyframesRule(
  @SerialName("name")
  @param:Optional
  val name: String? = null,
  @SerialName("keyframes")
  val keyframes: List<KeyframeStyle>,
)
