@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The reason why request was blocked.
 */
@Serializable
public enum class BlockedReason {
  @SerialName("other")
  OTHER,
  @SerialName("csp")
  CSP,
  @SerialName("mixed-content")
  MIXED_CONTENT,
  @SerialName("origin")
  ORIGIN,
  @SerialName("inspector")
  INSPECTOR,
  @SerialName("subresource-filter")
  SUBRESOURCE_FILTER,
  @SerialName("content-type")
  CONTENT_TYPE,
  @SerialName("coep-frame-resource-needs-coep-header")
  COEP_FRAME_RESOURCE_NEEDS_COEP_HEADER,
  @SerialName("coop-sandboxed-iframe-cannot-navigate-to-coop-page")
  COOP_SANDBOXED_IFRAME_CANNOT_NAVIGATE_TO_COOP_PAGE,
  @SerialName("corp-not-same-origin")
  CORP_NOT_SAME_ORIGIN,
  @SerialName("corp-not-same-origin-after-defaulted-to-same-origin-by-coep")
  CORP_NOT_SAME_ORIGIN_AFTER_DEFAULTED_TO_SAME_ORIGIN_BY_COEP,
  @SerialName("corp-not-same-site")
  CORP_NOT_SAME_SITE,
}
