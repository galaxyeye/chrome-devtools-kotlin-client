@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Object subtype hint. Specified for `object` type values only.
 * NOTE: If you change anything here, make sure to also update
 * `subtype` in `ObjectPreview` and `PropertyPreview` below.
 */
@Serializable
public enum class RemoteObjectSubtype {
  @SerialName("array")
  ARRAY,
  @SerialName("null")
  NULL,
  @SerialName("node")
  NODE,
  @SerialName("regexp")
  REGEXP,
  @SerialName("date")
  DATE,
  @SerialName("map")
  MAP,
  @SerialName("set")
  SET,
  @SerialName("weakmap")
  WEAKMAP,
  @SerialName("weakset")
  WEAKSET,
  @SerialName("iterator")
  ITERATOR,
  @SerialName("generator")
  GENERATOR,
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
  @SerialName("dataview")
  DATAVIEW,
  @SerialName("webassemblymemory")
  WEBASSEMBLYMEMORY,
  @SerialName("wasmvalue")
  WASMVALUE,
  @SerialName("trustedtype")
  TRUSTEDTYPE,
  UNKNOWN,
}
