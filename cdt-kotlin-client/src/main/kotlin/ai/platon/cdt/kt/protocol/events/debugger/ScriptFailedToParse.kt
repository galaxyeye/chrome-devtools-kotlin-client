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
data class ScriptFailedToParse(
  @field:JsonProperty("scriptId")
  val scriptId: String,
  @field:JsonProperty("url")
  val url: String,
  @field:JsonProperty("startLine")
  val startLine: Int,
  @field:JsonProperty("startColumn")
  val startColumn: Int,
  @field:JsonProperty("endLine")
  val endLine: Int,
  @field:JsonProperty("endColumn")
  val endColumn: Int,
  @field:JsonProperty("executionContextId")
  val executionContextId: Int,
  @field:JsonProperty("hash")
  val hash: String,
  @field:JsonProperty("executionContextAuxData")
  @param:Optional
  val executionContextAuxData: Map<String, Any?>? = null,
  @field:JsonProperty("sourceMapURL")
  @param:Optional
  val sourceMapURL: String? = null,
  @field:JsonProperty("hasSourceURL")
  @param:Optional
  val hasSourceURL: Boolean? = null,
  @field:JsonProperty("isModule")
  @param:Optional
  val isModule: Boolean? = null,
  @field:JsonProperty("length")
  @param:Optional
  val length: Int? = null,
  @field:JsonProperty("stackTrace")
  @param:Optional
  @param:Experimental
  val stackTrace: StackTrace? = null,
  @field:JsonProperty("codeOffset")
  @param:Optional
  @param:Experimental
  val codeOffset: Int? = null,
  @field:JsonProperty("scriptLanguage")
  @param:Optional
  @param:Experimental
  val scriptLanguage: ScriptLanguage? = null,
  @field:JsonProperty("embedderName")
  @param:Optional
  @param:Experimental
  val embedderName: String? = null,
)
