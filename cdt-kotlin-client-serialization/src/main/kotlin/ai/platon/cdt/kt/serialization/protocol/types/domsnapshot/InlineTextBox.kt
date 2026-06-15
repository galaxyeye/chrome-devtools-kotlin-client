@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domsnapshot
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.dom.Rect
import kotlin.Int

/**
 * Details of post layout rendered text positions. The exact layout should not be regarded as
 * stable and may change between versions.
 */
@Serializable
data class InlineTextBox(
  @SerialName("boundingBox")
  val boundingBox: Rect,
  @SerialName("startCharacterIndex")
  val startCharacterIndex: Int,
  @SerialName("numCharacters")
  val numCharacters: Int,
)
