@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String

/**
 * Post data entry for HTTP request
 */
@Serializable
data class PostDataEntry(
  @SerialName("bytes")
  @param:Optional
  val bytes: String? = null,
)
