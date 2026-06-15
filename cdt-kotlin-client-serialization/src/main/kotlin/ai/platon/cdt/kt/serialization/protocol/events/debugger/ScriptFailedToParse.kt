@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.debugger
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.debugger.ScriptLanguage
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTrace
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

/**
 * Fired when virtual machine fails to parse the script.
 */
@Serializable
data class ScriptFailedToParse(
  @SerialName("scriptId")
  val scriptId: String,
  @SerialName("url")
  val url: String,
  @SerialName("startLine")
  val startLine: Int,
  @SerialName("startColumn")
  val startColumn: Int,
  @SerialName("endLine")
  val endLine: Int,
  @SerialName("endColumn")
  val endColumn: Int,
  @SerialName("executionContextId")
  val executionContextId: Int,
  @SerialName("hash")
  val hash: String,
  @SerialName("executionContextAuxData")
  @param:Optional
  val executionContextAuxData: Map<String, Any?>? = null,
  @SerialName("sourceMapURL")
  @param:Optional
  val sourceMapURL: String? = null,
  @SerialName("hasSourceURL")
  @param:Optional
  val hasSourceURL: Boolean? = null,
  @SerialName("isModule")
  @param:Optional
  val isModule: Boolean? = null,
  @SerialName("length")
  @param:Optional
  val length: Int? = null,
  @SerialName("stackTrace")
  @param:Optional
  @param:Experimental
  val stackTrace: StackTrace? = null,
  @SerialName("codeOffset")
  @param:Optional
  @param:Experimental
  val codeOffset: Int? = null,
  @SerialName("scriptLanguage")
  @param:Optional
  @param:Experimental
  val scriptLanguage: ScriptLanguage? = null,
  @SerialName("embedderName")
  @param:Optional
  @param:Experimental
  val embedderName: String? = null,
)
