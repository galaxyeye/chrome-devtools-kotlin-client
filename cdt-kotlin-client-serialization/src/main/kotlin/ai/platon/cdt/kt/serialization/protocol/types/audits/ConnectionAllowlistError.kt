@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class ConnectionAllowlistError {
  @SerialName("InvalidHeader")
  INVALID_HEADER,
  @SerialName("MoreThanOneList")
  MORE_THAN_ONE_LIST,
  @SerialName("ItemNotInnerList")
  ITEM_NOT_INNER_LIST,
  @SerialName("InvalidAllowlistItemType")
  INVALID_ALLOWLIST_ITEM_TYPE,
  @SerialName("ReportingEndpointNotToken")
  REPORTING_ENDPOINT_NOT_TOKEN,
  @SerialName("InvalidUrlPattern")
  INVALID_URL_PATTERN,
  UNKNOWN,
}
