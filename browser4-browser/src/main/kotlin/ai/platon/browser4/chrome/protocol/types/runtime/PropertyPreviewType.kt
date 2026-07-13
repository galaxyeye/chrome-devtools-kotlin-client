@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.runtime

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Object type. Accessor means that the property itself is an accessor property.
 */
@Serializable
public enum class PropertyPreviewType {
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
  @SerialName("accessor")
  ACCESSOR,
  @SerialName("bigint")
  BIGINT,
  UNKNOWN,
}
