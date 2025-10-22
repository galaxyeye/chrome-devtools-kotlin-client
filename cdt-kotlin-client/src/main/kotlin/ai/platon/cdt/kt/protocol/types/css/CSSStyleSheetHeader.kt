package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * CSS stylesheet metainformation.
 */
data class CSSStyleSheetHeader(
  @field:JsonProperty("styleSheetId")
  val styleSheetId: String,
  @field:JsonProperty("frameId")
  val frameId: String,
  @field:JsonProperty("sourceURL")
  val sourceURL: String,
  @field:JsonProperty("sourceMapURL")
  @param:Optional
  val sourceMapURL: String? = null,
  @field:JsonProperty("origin")
  val origin: StyleSheetOrigin,
  @field:JsonProperty("title")
  val title: String,
  @field:JsonProperty("ownerNode")
  @param:Optional
  val ownerNode: Int? = null,
  @field:JsonProperty("disabled")
  val disabled: Boolean,
  @field:JsonProperty("hasSourceURL")
  @param:Optional
  val hasSourceURL: Boolean? = null,
  @field:JsonProperty("isInline")
  val isInline: Boolean,
  @field:JsonProperty("isMutable")
  val isMutable: Boolean,
  @field:JsonProperty("isConstructed")
  val isConstructed: Boolean,
  @field:JsonProperty("startLine")
  val startLine: Double,
  @field:JsonProperty("startColumn")
  val startColumn: Double,
  @field:JsonProperty("length")
  val length: Double,
  @field:JsonProperty("endLine")
  val endLine: Double,
  @field:JsonProperty("endColumn")
  val endColumn: Double,
)
