@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class OriginTrialTokenWithStatus(
  @property:SerialName("rawTokenText")
  val rawTokenText: String,
  @property:SerialName("parsedToken")
  @param:Optional
  val parsedToken: OriginTrialToken? = null,
  @property:SerialName("status")
  val status: OriginTrialTokenStatus,
)
