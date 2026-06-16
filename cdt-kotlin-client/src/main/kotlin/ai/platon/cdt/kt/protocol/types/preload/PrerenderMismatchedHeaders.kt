@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.preload

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Information of headers to be displayed when the header mismatch occurred.
 */
data class PrerenderMismatchedHeaders(
  @param:JsonProperty("headerName")
  val headerName: String,
  @param:JsonProperty("initialValue")
  @param:Optional
  val initialValue: String? = null,
  @param:JsonProperty("activationValue")
  @param:Optional
  val activationValue: String? = null,
)
