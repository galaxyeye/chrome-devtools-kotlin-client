@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.collections.List

/**
 * This issue warns about third-party sites that are accessing cookies on the
 * current page, and have been permitted due to having a global metadata grant.
 * Note that in this context 'site' means eTLD+1. For example, if the URL
 * `https://example.test:80/web_page` was accessing cookies, the site reported
 * would be `example.test`.
 */
data class CookieDeprecationMetadataIssueDetails(
  @param:JsonProperty("allowedSites")
  val allowedSites: List<String>,
  @param:JsonProperty("optOutPercentage")
  val optOutPercentage: Double,
  @param:JsonProperty("isOptOutTopLevel")
  val isOptOutTopLevel: Boolean,
  @param:JsonProperty("operation")
  val operation: CookieOperation,
)
