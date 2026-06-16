@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Information about the suggested solution to a cookie issue.
 */
@Serializable
data class CookieIssueInsight(
  @property:SerialName("type")
  val type: InsightType,
  @property:SerialName("tableEntryUrl")
  @param:Optional
  val tableEntryUrl: String? = null,
)
