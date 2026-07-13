@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.headlessexperimental

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BeginFrame(
  @property:SerialName("hasDamage")
  val hasDamage: Boolean,
  @property:SerialName("screenshotData")
  @param:Optional
  val screenshotData: String? = null,
)
