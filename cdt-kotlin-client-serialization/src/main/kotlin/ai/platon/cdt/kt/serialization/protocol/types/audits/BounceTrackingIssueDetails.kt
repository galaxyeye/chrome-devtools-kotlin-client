@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This issue warns about sites in the redirect chain of a finished navigation
 * that may be flagged as trackers and have their state cleared if they don't
 * receive a user interaction. Note that in this context 'site' means eTLD+1.
 * For example, if the URL `https://example.test:80/bounce` was in the
 * redirect chain, the site reported would be `example.test`.
 */
@Serializable
data class BounceTrackingIssueDetails(
  @property:SerialName("trackingSites")
  val trackingSites: List<String>,
)
