@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Request pattern for interception.
 */
@Serializable
@Experimental
data class RequestPattern(
  @property:SerialName("urlPattern")
  @param:Optional
  val urlPattern: String? = null,
  @property:SerialName("resourceType")
  @param:Optional
  val resourceType: ResourceType? = null,
  @property:SerialName("interceptionStage")
  @param:Optional
  val interceptionStage: InterceptionStage? = null,
)
