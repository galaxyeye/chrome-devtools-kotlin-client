@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class SharedArrayBufferIssueType {
  @SerialName("TransferIssue")
  TRANSFER_ISSUE,
  @SerialName("CreationIssue")
  CREATION_ISSUE,
  UNKNOWN,
}
