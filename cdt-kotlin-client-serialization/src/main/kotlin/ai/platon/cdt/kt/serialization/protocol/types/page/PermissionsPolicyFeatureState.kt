@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean

@Experimental
@Serializable
data class PermissionsPolicyFeatureState(
  @SerialName("feature")
  val feature: PermissionsPolicyFeature,
  @SerialName("allowed")
  val allowed: Boolean,
  @SerialName("locator")
  @param:Optional
  val locator: PermissionsPolicyBlockLocator? = null,
)
