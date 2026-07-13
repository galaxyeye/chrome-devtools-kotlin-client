@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domsnapshot

import ai.platon.cdt.kt.serialization.protocol.types.dom.Rect
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Details of post layout rendered text positions. The exact layout should not be regarded as
 * stable and may change between versions.
 */
@Serializable
data class InlineTextBox(
  @property:SerialName("boundingBox")
  val boundingBox: Rect,
  @property:SerialName("startCharacterIndex")
  val startCharacterIndex: Int,
  @property:SerialName("numCharacters")
  val numCharacters: Int,
)
