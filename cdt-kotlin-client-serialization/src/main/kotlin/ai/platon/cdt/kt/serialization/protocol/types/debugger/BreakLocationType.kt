@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
public enum class BreakLocationType {
  @SerialName("debuggerStatement")
  DEBUGGER_STATEMENT,
  @SerialName("call")
  CALL,
  @SerialName("return")
  RETURN,
}
