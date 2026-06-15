@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.fetch
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.ResourceType
import kotlin.String

@Serializable
data class RequestPattern(
  @SerialName("urlPattern")
  @param:Optional
  val urlPattern: String? = null,
  @SerialName("resourceType")
  @param:Optional
  val resourceType: ResourceType? = null,
  @SerialName("requestStage")
  @param:Optional
  val requestStage: RequestStage? = null,
)
