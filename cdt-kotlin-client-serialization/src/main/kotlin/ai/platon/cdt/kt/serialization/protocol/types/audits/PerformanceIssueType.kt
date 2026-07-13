@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class PerformanceIssueType {
  @SerialName("DocumentCookie")
  DOCUMENT_COOKIE,
  UNKNOWN,
}
