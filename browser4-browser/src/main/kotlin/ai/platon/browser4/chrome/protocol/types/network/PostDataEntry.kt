@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.network

import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Post data entry for HTTP request
 */
@Serializable
data class PostDataEntry(
  @property:SerialName("bytes")
  @param:Optional
  val bytes: String? = null,
)
