@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.security
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.security.InsecureContentStatus
import ai.platon.cdt.kt.serialization.protocol.types.security.SecurityState
import ai.platon.cdt.kt.serialization.protocol.types.security.SecurityStateExplanation
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.String
import kotlin.collections.List

/**
 * The security state of the page changed.
 */
@Serializable
data class SecurityStateChanged(
  @SerialName("securityState")
  val securityState: SecurityState,
  @SerialName("schemeIsCryptographic")
  @Deprecated("Deprecated by protocol")
  val schemeIsCryptographic: Boolean,
  @SerialName("explanations")
  val explanations: List<SecurityStateExplanation>,
  @SerialName("insecureContentStatus")
  @Deprecated("Deprecated by protocol")
  val insecureContentStatus: InsecureContentStatus,
  @SerialName("summary")
  @param:Optional
  val summary: String? = null,
)
