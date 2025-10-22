package ai.platon.cdt.kt.protocol.events.security

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.security.InsecureContentStatus
import ai.platon.cdt.kt.protocol.types.security.SecurityState
import ai.platon.cdt.kt.protocol.types.security.SecurityStateExplanation
import com.fasterxml.jackson.`annotation`.JsonProperty
import java.lang.Deprecated
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

/**
 * The security state of the page changed.
 */
data class SecurityStateChanged(
  @field:JsonProperty("securityState")
  val securityState: SecurityState,
  @field:JsonProperty("schemeIsCryptographic")
  @param:Deprecated
  val schemeIsCryptographic: Boolean,
  @field:JsonProperty("explanations")
  val explanations: List<SecurityStateExplanation>,
  @field:JsonProperty("insecureContentStatus")
  @param:Deprecated
  val insecureContentStatus: InsecureContentStatus,
  @field:JsonProperty("summary")
  @param:Optional
  val summary: String? = null,
)
