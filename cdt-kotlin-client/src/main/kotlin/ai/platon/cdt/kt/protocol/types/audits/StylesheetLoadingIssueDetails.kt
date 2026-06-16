@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * This issue warns when a referenced stylesheet couldn't be loaded.
 */
data class StylesheetLoadingIssueDetails(
  @param:JsonProperty("sourceCodeLocation")
  val sourceCodeLocation: SourceCodeLocation,
  @param:JsonProperty("styleSheetLoadingIssueReason")
  val styleSheetLoadingIssueReason: StyleSheetLoadingIssueReason,
  @param:JsonProperty("failedRequestInfo")
  @param:Optional
  val failedRequestInfo: FailedRequestInfo? = null,
)
