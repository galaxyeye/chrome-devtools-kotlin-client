@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Information about a request that is affected by an inspector issue.
 */
@Serializable
data class AffectedRequest(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("url")
  @param:Optional
  val url: String? = null,
)
