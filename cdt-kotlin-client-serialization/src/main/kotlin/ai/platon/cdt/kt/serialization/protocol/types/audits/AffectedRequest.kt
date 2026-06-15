@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String

/**
 * Information about a request that is affected by an inspector issue.
 */
@Serializable
data class AffectedRequest(
  @SerialName("requestId")
  val requestId: String,
  @SerialName("url")
  @param:Optional
  val url: String? = null,
)
