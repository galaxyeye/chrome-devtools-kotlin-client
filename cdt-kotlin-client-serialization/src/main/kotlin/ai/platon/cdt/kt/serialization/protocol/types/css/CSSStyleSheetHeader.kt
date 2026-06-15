@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * CSS stylesheet metainformation.
 */
@Serializable
data class CSSStyleSheetHeader(
  @SerialName("styleSheetId")
  val styleSheetId: String,
  @SerialName("frameId")
  val frameId: String,
  @SerialName("sourceURL")
  val sourceURL: String,
  @SerialName("sourceMapURL")
  @param:Optional
  val sourceMapURL: String? = null,
  @SerialName("origin")
  val origin: StyleSheetOrigin,
  @SerialName("title")
  val title: String,
  @SerialName("ownerNode")
  @param:Optional
  val ownerNode: Int? = null,
  @SerialName("disabled")
  val disabled: Boolean,
  @SerialName("hasSourceURL")
  @param:Optional
  val hasSourceURL: Boolean? = null,
  @SerialName("isInline")
  val isInline: Boolean,
  @SerialName("isMutable")
  val isMutable: Boolean,
  @SerialName("isConstructed")
  val isConstructed: Boolean,
  @SerialName("startLine")
  val startLine: Double,
  @SerialName("startColumn")
  val startColumn: Double,
  @SerialName("length")
  val length: Double,
  @SerialName("endLine")
  val endLine: Double,
  @SerialName("endColumn")
  val endColumn: Double,
)
