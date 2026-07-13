@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This issue warns when a referenced stylesheet couldn't be loaded.
 */
@Serializable
data class StylesheetLoadingIssueDetails(
  @property:SerialName("sourceCodeLocation")
  val sourceCodeLocation: SourceCodeLocation,
  @property:SerialName("styleSheetLoadingIssueReason")
  val styleSheetLoadingIssueReason: StyleSheetLoadingIssueReason,
  @property:SerialName("failedRequestInfo")
  @param:Optional
  val failedRequestInfo: FailedRequestInfo? = null,
)
