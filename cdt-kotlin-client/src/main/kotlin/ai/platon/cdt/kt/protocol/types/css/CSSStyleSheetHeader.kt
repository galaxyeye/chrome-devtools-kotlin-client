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
public data class CSSStyleSheetHeader(
  @field:JsonProperty("styleSheetId")
  public val styleSheetId: String,
  @field:JsonProperty("frameId")
  public val frameId: String,
  @field:JsonProperty("sourceURL")
  public val sourceURL: String,
  @field:JsonProperty("sourceMapURL")
  @param:Optional
  public val sourceMapURL: String? = null,
  @field:JsonProperty("origin")
  public val origin: StyleSheetOrigin,
  @field:JsonProperty("title")
  public val title: String,
  @field:JsonProperty("ownerNode")
  @param:Optional
  public val ownerNode: Int? = null,
  @field:JsonProperty("disabled")
  public val disabled: Boolean,
  @field:JsonProperty("hasSourceURL")
  @param:Optional
  public val hasSourceURL: Boolean? = null,
  @field:JsonProperty("isInline")
  public val isInline: Boolean,
  @field:JsonProperty("isMutable")
  public val isMutable: Boolean,
  @field:JsonProperty("isConstructed")
  public val isConstructed: Boolean,
  @field:JsonProperty("startLine")
  public val startLine: Double,
  @field:JsonProperty("startColumn")
  public val startColumn: Double,
  @field:JsonProperty("length")
  public val length: Double,
  @field:JsonProperty("endLine")
  public val endLine: Double,
  @field:JsonProperty("endColumn")
  public val endColumn: Double,
)
