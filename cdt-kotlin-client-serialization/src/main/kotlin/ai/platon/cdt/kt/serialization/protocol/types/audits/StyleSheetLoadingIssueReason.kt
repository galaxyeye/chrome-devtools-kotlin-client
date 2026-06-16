@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class StyleSheetLoadingIssueReason {
  @SerialName("LateImportRule")
  LATE_IMPORT_RULE,
  @SerialName("RequestFailed")
  REQUEST_FAILED,
  UNKNOWN,
}
