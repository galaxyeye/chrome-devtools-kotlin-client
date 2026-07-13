@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.animation

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Keyframes Rule
 */
@Serializable
data class KeyframesRule(
  @property:SerialName("name")
  @param:Optional
  val name: String? = null,
  @property:SerialName("keyframes")
  val keyframes: List<KeyframeStyle>,
)
