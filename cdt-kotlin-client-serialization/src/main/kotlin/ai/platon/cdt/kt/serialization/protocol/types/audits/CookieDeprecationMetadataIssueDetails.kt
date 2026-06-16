@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This issue warns about third-party sites that are accessing cookies on the
 * current page, and have been permitted due to having a global metadata grant.
 * Note that in this context 'site' means eTLD+1. For example, if the URL
 * `https://example.test:80/web_page` was accessing cookies, the site reported
 * would be `example.test`.
 */
@Serializable
data class CookieDeprecationMetadataIssueDetails(
  @property:SerialName("allowedSites")
  val allowedSites: List<String>,
  @property:SerialName("optOutPercentage")
  val optOutPercentage: Double,
  @property:SerialName("isOptOutTopLevel")
  val isOptOutTopLevel: Boolean,
  @property:SerialName("operation")
  val operation: CookieOperation,
)
