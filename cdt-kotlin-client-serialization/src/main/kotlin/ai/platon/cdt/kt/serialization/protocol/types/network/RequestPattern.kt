@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String

/**
 * Request pattern for interception.
 */
@Experimental
@Serializable
data class RequestPattern(
  @SerialName("urlPattern")
  @param:Optional
  val urlPattern: String? = null,
  @SerialName("resourceType")
  @param:Optional
  val resourceType: ResourceType? = null,
  @SerialName("interceptionStage")
  @param:Optional
  val interceptionStage: InterceptionStage? = null,
)
