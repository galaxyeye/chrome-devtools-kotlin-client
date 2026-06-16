@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
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
