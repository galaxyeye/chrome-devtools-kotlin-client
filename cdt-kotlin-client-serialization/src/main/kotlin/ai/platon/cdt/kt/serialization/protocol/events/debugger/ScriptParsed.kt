@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.debugger

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.debugger.DebugSymbols
import ai.platon.cdt.kt.serialization.protocol.types.debugger.ScriptLanguage
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTrace
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

/**
 * Fired when virtual machine parses script. This event is also fired for all known and uncollected
 * scripts upon enabling debugger.
 */
@Serializable
data class ScriptParsed(
  @property:SerialName("scriptId")
  val scriptId: String,
  @property:SerialName("url")
  val url: String,
  @property:SerialName("startLine")
  val startLine: Int,
  @property:SerialName("startColumn")
  val startColumn: Int,
  @property:SerialName("endLine")
  val endLine: Int,
  @property:SerialName("endColumn")
  val endColumn: Int,
  @property:SerialName("executionContextId")
  val executionContextId: Int,
  @property:SerialName("hash")
  val hash: String,
  @property:SerialName("executionContextAuxData")
  @param:Optional
  val executionContextAuxData: JsonObject? = null,
  @property:SerialName("isLiveEdit")
  @param:Optional
  @param:Experimental
  val isLiveEdit: Boolean? = null,
  @property:SerialName("sourceMapURL")
  @param:Optional
  val sourceMapURL: String? = null,
  @property:SerialName("hasSourceURL")
  @param:Optional
  val hasSourceURL: Boolean? = null,
  @property:SerialName("isModule")
  @param:Optional
  val isModule: Boolean? = null,
  @property:SerialName("length")
  @param:Optional
  val length: Int? = null,
  @property:SerialName("stackTrace")
  @param:Optional
  @param:Experimental
  val stackTrace: StackTrace? = null,
  @property:SerialName("codeOffset")
  @param:Optional
  @param:Experimental
  val codeOffset: Int? = null,
  @property:SerialName("scriptLanguage")
  @param:Optional
  @param:Experimental
  val scriptLanguage: ScriptLanguage? = null,
  @property:SerialName("debugSymbols")
  @param:Optional
  @param:Experimental
  val debugSymbols: DebugSymbols? = null,
  @property:SerialName("embedderName")
  @param:Optional
  @param:Experimental
  val embedderName: String? = null,
)
