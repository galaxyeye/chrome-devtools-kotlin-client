@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.preload

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Information of headers to be displayed when the header mismatch occurred.
 */
@Serializable
data class PrerenderMismatchedHeaders(
  @property:SerialName("headerName")
  val headerName: String,
  @property:SerialName("initialValue")
  @param:Optional
  val initialValue: String? = null,
  @property:SerialName("activationValue")
  @param:Optional
  val activationValue: String? = null,
)
