@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.headlessexperimental
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String

@Serializable
data class BeginFrame(
  @SerialName("hasDamage")
  val hasDamage: Boolean,
  @SerialName("screenshotData")
  @param:Optional
  val screenshotData: String? = null,
)
