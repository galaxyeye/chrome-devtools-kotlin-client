@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.indexeddb
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Key path type.
 */
@Serializable
public enum class KeyPathType {
  @SerialName("null")
  NULL,
  @SerialName("string")
  STRING,
  @SerialName("array")
  ARRAY,
}
