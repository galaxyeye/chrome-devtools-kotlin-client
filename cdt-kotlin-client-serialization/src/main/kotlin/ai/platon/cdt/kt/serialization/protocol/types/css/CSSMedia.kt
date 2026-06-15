@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List

/**
 * CSS media rule descriptor.
 */
@Serializable
data class CSSMedia(
  @SerialName("text")
  val text: String,
  @SerialName("source")
  val source: CSSMediaSource,
  @SerialName("sourceURL")
  @param:Optional
  val sourceURL: String? = null,
  @SerialName("range")
  @param:Optional
  val range: SourceRange? = null,
  @SerialName("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
  @SerialName("mediaList")
  @param:Optional
  val mediaList: List<MediaQuery>? = null,
)
