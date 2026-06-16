@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Enum of possible script languages.
 */
@Serializable
public enum class ScriptLanguage {
  @SerialName("JavaScript")
  JAVA_SCRIPT,
  @SerialName("WebAssembly")
  WEB_ASSEMBLY,
  UNKNOWN,
}
