package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

@Experimental
data class PermissionsPolicyFeatureState(
  @field:JsonProperty("feature")
  val feature: PermissionsPolicyFeature,
  @field:JsonProperty("allowed")
  val allowed: Boolean,
  @field:JsonProperty("locator")
  @param:Optional
  val locator: PermissionsPolicyBlockLocator? = null,
)
