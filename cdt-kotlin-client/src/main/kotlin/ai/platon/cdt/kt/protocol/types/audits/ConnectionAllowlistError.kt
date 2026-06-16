@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class ConnectionAllowlistError {
  @JsonProperty("InvalidHeader")
  INVALID_HEADER,
  @JsonProperty("MoreThanOneList")
  MORE_THAN_ONE_LIST,
  @JsonProperty("ItemNotInnerList")
  ITEM_NOT_INNER_LIST,
  @JsonProperty("InvalidAllowlistItemType")
  INVALID_ALLOWLIST_ITEM_TYPE,
  @JsonProperty("ReportingEndpointNotToken")
  REPORTING_ENDPOINT_NOT_TOKEN,
  @JsonProperty("InvalidUrlPattern")
  INVALID_URL_PATTERN,
  @JsonEnumDefaultValue
  UNKNOWN,
}
