@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class PerformanceIssueType {
  @JsonProperty("DocumentCookie")
  DOCUMENT_COOKIE,
  @JsonEnumDefaultValue
  UNKNOWN,
}
