@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class ClientHintIssueReason {
  @SerialName("MetaTagAllowListInvalidOrigin")
  META_TAG_ALLOW_LIST_INVALID_ORIGIN,
  @SerialName("MetaTagModifiedHTML")
  META_TAG_MODIFIED_HTML,
  UNKNOWN,
}
