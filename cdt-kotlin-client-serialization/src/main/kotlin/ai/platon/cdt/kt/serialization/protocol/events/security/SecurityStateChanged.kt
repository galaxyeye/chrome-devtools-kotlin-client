@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.security

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.security.InsecureContentStatus
import ai.platon.cdt.kt.serialization.protocol.types.security.SecurityState
import ai.platon.cdt.kt.serialization.protocol.types.security.SecurityStateExplanation
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The security state of the page changed.
 */
@Serializable
data class SecurityStateChanged(
  @property:SerialName("securityState")
  val securityState: SecurityState,
  @property:SerialName("schemeIsCryptographic")
  @Deprecated("Deprecated by protocol")
  val schemeIsCryptographic: Boolean,
  @property:SerialName("explanations")
  val explanations: List<SecurityStateExplanation>,
  @property:SerialName("insecureContentStatus")
  @Deprecated("Deprecated by protocol")
  val insecureContentStatus: InsecureContentStatus,
  @property:SerialName("summary")
  @param:Optional
  val summary: String? = null,
)
