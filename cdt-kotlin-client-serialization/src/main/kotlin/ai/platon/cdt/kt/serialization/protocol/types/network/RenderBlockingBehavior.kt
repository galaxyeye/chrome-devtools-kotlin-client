@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The render-blocking behavior of a resource request.
 */
@Serializable
public enum class RenderBlockingBehavior {
  @SerialName("Blocking")
  BLOCKING,
  @SerialName("InBodyParserBlocking")
  IN_BODY_PARSER_BLOCKING,
  @SerialName("NonBlocking")
  NON_BLOCKING,
  @SerialName("NonBlockingDynamic")
  NON_BLOCKING_DYNAMIC,
  @SerialName("PotentiallyBlocking")
  POTENTIALLY_BLOCKING,
  UNKNOWN,
}
