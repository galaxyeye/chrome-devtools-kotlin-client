@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.indexeddb
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Key type.
 */
@Serializable
public enum class KeyType {
  @SerialName("number")
  NUMBER,
  @SerialName("string")
  STRING,
  @SerialName("date")
  DATE,
  @SerialName("array")
  ARRAY,
}
