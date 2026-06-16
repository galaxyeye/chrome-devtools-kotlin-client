@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * CSS stylesheet metainformation.
 */
@Serializable
data class CSSStyleSheetHeader(
  @property:SerialName("styleSheetId")
  val styleSheetId: String,
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("sourceURL")
  val sourceURL: String,
  @property:SerialName("sourceMapURL")
  @param:Optional
  val sourceMapURL: String? = null,
  @property:SerialName("origin")
  val origin: StyleSheetOrigin,
  @property:SerialName("title")
  val title: String,
  @property:SerialName("ownerNode")
  @param:Optional
  val ownerNode: Int? = null,
  @property:SerialName("disabled")
  val disabled: Boolean,
  @property:SerialName("hasSourceURL")
  @param:Optional
  val hasSourceURL: Boolean? = null,
  @property:SerialName("isInline")
  val isInline: Boolean,
  @property:SerialName("isMutable")
  val isMutable: Boolean,
  @property:SerialName("isConstructed")
  val isConstructed: Boolean,
  @property:SerialName("startLine")
  val startLine: Double,
  @property:SerialName("startColumn")
  val startColumn: Double,
  @property:SerialName("length")
  val length: Double,
  @property:SerialName("endLine")
  val endLine: Double,
  @property:SerialName("endColumn")
  val endColumn: Double,
)
