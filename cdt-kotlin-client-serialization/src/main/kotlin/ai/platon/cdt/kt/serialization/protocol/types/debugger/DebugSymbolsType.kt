@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Type of the debug symbols.
 */
@Serializable
public enum class DebugSymbolsType {
  @SerialName("None")
  NONE,
  @SerialName("SourceMap")
  SOURCE_MAP,
  @SerialName("EmbeddedDWARF")
  EMBEDDED_DWARF,
  @SerialName("ExternalDWARF")
  EXTERNAL_DWARF,
  UNKNOWN,
}
