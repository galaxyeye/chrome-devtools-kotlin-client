@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * This issue warns about sites in the redirect chain of a finished navigation
 * that may be flagged as trackers and have their state cleared if they don't
 * receive a user interaction. Note that in this context 'site' means eTLD+1.
 * For example, if the URL `https://example.test:80/bounce` was in the
 * redirect chain, the site reported would be `example.test`.
 */
data class BounceTrackingIssueDetails(
  @param:JsonProperty("trackingSites")
  val trackingSites: List<String>,
)
