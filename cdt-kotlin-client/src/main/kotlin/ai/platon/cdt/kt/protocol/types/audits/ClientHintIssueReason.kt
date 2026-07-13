@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class ClientHintIssueReason {
  @JsonProperty("MetaTagAllowListInvalidOrigin")
  META_TAG_ALLOW_LIST_INVALID_ORIGIN,
  @JsonProperty("MetaTagModifiedHTML")
  META_TAG_MODIFIED_HTML,
  @JsonEnumDefaultValue
  UNKNOWN,
}
