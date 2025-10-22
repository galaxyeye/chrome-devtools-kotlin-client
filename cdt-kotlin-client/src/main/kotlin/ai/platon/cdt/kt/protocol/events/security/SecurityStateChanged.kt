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
public data class SecurityStateChanged(
  @field:JsonProperty("securityState")
  public val securityState: SecurityState,
  @field:JsonProperty("schemeIsCryptographic")
  @param:Deprecated
  public val schemeIsCryptographic: Boolean,
  @field:JsonProperty("explanations")
  public val explanations: List<SecurityStateExplanation>,
  @field:JsonProperty("insecureContentStatus")
  @param:Deprecated
  public val insecureContentStatus: InsecureContentStatus,
  @field:JsonProperty("summary")
  @param:Optional
  public val summary: String? = null,
)
