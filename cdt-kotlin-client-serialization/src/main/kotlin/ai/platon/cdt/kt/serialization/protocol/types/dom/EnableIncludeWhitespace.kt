@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.dom

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Whether to include whitespaces in the children array of returned Nodes.
 */
@Serializable
public enum class EnableIncludeWhitespace {
  @SerialName("none")
  NONE,
  @SerialName("all")
  ALL,
  UNKNOWN,
}
