@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class PermissionsPolicyFeatureState(
  @property:SerialName("feature")
  val feature: PermissionsPolicyFeature,
  @property:SerialName("allowed")
  val allowed: Boolean,
  @property:SerialName("locator")
  @param:Optional
  val locator: PermissionsPolicyBlockLocator? = null,
)
