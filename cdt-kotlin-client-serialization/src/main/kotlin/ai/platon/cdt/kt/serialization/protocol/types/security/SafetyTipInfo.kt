@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.security

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class SafetyTipInfo(
  @property:SerialName("safetyTipStatus")
  val safetyTipStatus: SafetyTipStatus,
  @property:SerialName("safeUrl")
  @param:Optional
  val safeUrl: String? = null,
)
