@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.fetch

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.ResourceType
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestPattern(
  @property:SerialName("urlPattern")
  @param:Optional
  val urlPattern: String? = null,
  @property:SerialName("resourceType")
  @param:Optional
  val resourceType: ResourceType? = null,
  @property:SerialName("requestStage")
  @param:Optional
  val requestStage: RequestStage? = null,
)
