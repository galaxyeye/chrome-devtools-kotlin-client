@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * CSS media rule descriptor.
 */
@Serializable
data class CSSMedia(
  @property:SerialName("text")
  val text: String,
  @property:SerialName("source")
  val source: CSSMediaSource,
  @property:SerialName("sourceURL")
  @param:Optional
  val sourceURL: String? = null,
  @property:SerialName("range")
  @param:Optional
  val range: SourceRange? = null,
  @property:SerialName("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
  @property:SerialName("mediaList")
  @param:Optional
  val mediaList: List<MediaQuery>? = null,
)
