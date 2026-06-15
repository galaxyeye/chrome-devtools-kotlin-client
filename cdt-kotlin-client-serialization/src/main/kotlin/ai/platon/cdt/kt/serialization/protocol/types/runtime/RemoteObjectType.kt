@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Object type.
 */
@Serializable
public enum class RemoteObjectType {
  @SerialName("object")
  OBJECT,
  @SerialName("function")
  FUNCTION,
  @SerialName("undefined")
  UNDEFINED,
  @SerialName("string")
  STRING,
  @SerialName("number")
  NUMBER,
  @SerialName("boolean")
  BOOLEAN,
  @SerialName("symbol")
  SYMBOL,
  @SerialName("bigint")
  BIGINT,
}
