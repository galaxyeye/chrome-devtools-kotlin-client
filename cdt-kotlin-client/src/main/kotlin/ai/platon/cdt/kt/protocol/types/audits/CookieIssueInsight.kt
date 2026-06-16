@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Information about the suggested solution to a cookie issue.
 */
data class CookieIssueInsight(
  @param:JsonProperty("type")
  val type: InsightType,
  @param:JsonProperty("tableEntryUrl")
  @param:Optional
  val tableEntryUrl: String? = null,
)
