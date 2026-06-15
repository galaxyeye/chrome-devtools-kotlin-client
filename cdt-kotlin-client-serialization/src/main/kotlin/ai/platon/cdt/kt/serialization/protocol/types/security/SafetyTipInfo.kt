@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.security
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String

@Experimental
@Serializable
data class SafetyTipInfo(
  @SerialName("safetyTipStatus")
  val safetyTipStatus: SafetyTipStatus,
  @SerialName("safeUrl")
  @param:Optional
  val safeUrl: String? = null,
)
