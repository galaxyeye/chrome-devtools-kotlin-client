@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class StyleSheetLoadingIssueReason {
  @JsonProperty("LateImportRule")
  LATE_IMPORT_RULE,
  @JsonProperty("RequestFailed")
  REQUEST_FAILED,
  @JsonEnumDefaultValue
  UNKNOWN,
}
