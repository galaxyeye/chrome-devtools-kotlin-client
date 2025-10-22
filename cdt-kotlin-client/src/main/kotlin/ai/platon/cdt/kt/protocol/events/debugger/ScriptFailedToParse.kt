package ai.platon.cdt.kt.protocol.events.debugger

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.debugger.ScriptLanguage
import ai.platon.cdt.kt.protocol.types.runtime.StackTrace
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

/**
 * Fired when virtual machine fails to parse the script.
 */
public data class ScriptFailedToParse(
  @field:JsonProperty("scriptId")
  public val scriptId: String,
  @field:JsonProperty("url")
  public val url: String,
  @field:JsonProperty("startLine")
  public val startLine: Int,
  @field:JsonProperty("startColumn")
  public val startColumn: Int,
  @field:JsonProperty("endLine")
  public val endLine: Int,
  @field:JsonProperty("endColumn")
  public val endColumn: Int,
  @field:JsonProperty("executionContextId")
  public val executionContextId: Int,
  @field:JsonProperty("hash")
  public val hash: String,
  @field:JsonProperty("executionContextAuxData")
  @param:Optional
  public val executionContextAuxData: Map<String, Any?>? = null,
  @field:JsonProperty("sourceMapURL")
  @param:Optional
  public val sourceMapURL: String? = null,
  @field:JsonProperty("hasSourceURL")
  @param:Optional
  public val hasSourceURL: Boolean? = null,
  @field:JsonProperty("isModule")
  @param:Optional
  public val isModule: Boolean? = null,
  @field:JsonProperty("length")
  @param:Optional
  public val length: Int? = null,
  @field:JsonProperty("stackTrace")
  @param:Optional
  @param:Experimental
  public val stackTrace: StackTrace? = null,
  @field:JsonProperty("codeOffset")
  @param:Optional
  @param:Experimental
  public val codeOffset: Int? = null,
  @field:JsonProperty("scriptLanguage")
  @param:Optional
  @param:Experimental
  public val scriptLanguage: ScriptLanguage? = null,
  @field:JsonProperty("embedderName")
  @param:Optional
  @param:Experimental
  public val embedderName: String? = null,
)
