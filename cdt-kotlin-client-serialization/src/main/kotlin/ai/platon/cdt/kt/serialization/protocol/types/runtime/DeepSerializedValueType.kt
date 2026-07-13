@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class DeepSerializedValueType {
  @SerialName("undefined")
  UNDEFINED,
  @SerialName("null")
  NULL,
  @SerialName("string")
  STRING,
  @SerialName("number")
  NUMBER,
  @SerialName("boolean")
  BOOLEAN,
  @SerialName("bigint")
  BIGINT,
  @SerialName("regexp")
  REGEXP,
  @SerialName("date")
  DATE,
  @SerialName("symbol")
  SYMBOL,
  @SerialName("array")
  ARRAY,
  @SerialName("object")
  OBJECT,
  @SerialName("function")
  FUNCTION,
  @SerialName("map")
  MAP,
  @SerialName("set")
  SET,
  @SerialName("weakmap")
  WEAKMAP,
  @SerialName("weakset")
  WEAKSET,
  @SerialName("error")
  ERROR,
  @SerialName("proxy")
  PROXY,
  @SerialName("promise")
  PROMISE,
  @SerialName("typedarray")
  TYPEDARRAY,
  @SerialName("arraybuffer")
  ARRAYBUFFER,
  @SerialName("node")
  NODE,
  @SerialName("window")
  WINDOW,
  @SerialName("generator")
  GENERATOR,
  UNKNOWN,
}
