@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Enum indicating the reason a response has been blocked. These reasons are
 * refinements of the net error BLOCKED_BY_RESPONSE.
 */
@Serializable
public enum class BlockedByResponseReason {
  @SerialName("CoepFrameResourceNeedsCoepHeader")
  COEP_FRAME_RESOURCE_NEEDS_COEP_HEADER,
  @SerialName("CoopSandboxedIFrameCannotNavigateToCoopPage")
  COOP_SANDBOXED_I_FRAME_CANNOT_NAVIGATE_TO_COOP_PAGE,
  @SerialName("CorpNotSameOrigin")
  CORP_NOT_SAME_ORIGIN,
  @SerialName("CorpNotSameOriginAfterDefaultedToSameOriginByCoep")
  CORP_NOT_SAME_ORIGIN_AFTER_DEFAULTED_TO_SAME_ORIGIN_BY_COEP,
  @SerialName("CorpNotSameOriginAfterDefaultedToSameOriginByDip")
  CORP_NOT_SAME_ORIGIN_AFTER_DEFAULTED_TO_SAME_ORIGIN_BY_DIP,
  @SerialName("CorpNotSameOriginAfterDefaultedToSameOriginByCoepAndDip")
  CORP_NOT_SAME_ORIGIN_AFTER_DEFAULTED_TO_SAME_ORIGIN_BY_COEP_AND_DIP,
  @SerialName("CorpNotSameSite")
  CORP_NOT_SAME_SITE,
  @SerialName("SRIMessageSignatureMismatch")
  SRI_MESSAGE_SIGNATURE_MISMATCH,
  UNKNOWN,
}
