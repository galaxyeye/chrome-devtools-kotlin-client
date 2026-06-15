@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Scope type.
 */
@Serializable
public enum class ScopeType {
  @SerialName("global")
  GLOBAL,
  @SerialName("local")
  LOCAL,
  @SerialName("with")
  WITH,
  @SerialName("closure")
  CLOSURE,
  @SerialName("catch")
  CATCH,
  @SerialName("block")
  BLOCK,
  @SerialName("script")
  SCRIPT,
  @SerialName("eval")
  EVAL,
  @SerialName("module")
  MODULE,
  @SerialName("wasm-expression-stack")
  WASM_EXPRESSION_STACK,
}
