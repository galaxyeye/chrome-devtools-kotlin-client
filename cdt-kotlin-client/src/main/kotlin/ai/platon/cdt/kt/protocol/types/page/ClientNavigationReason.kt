@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class ClientNavigationReason {
  @JsonProperty("anchorClick")
  ANCHOR_CLICK,
  @JsonProperty("formSubmissionGet")
  FORM_SUBMISSION_GET,
  @JsonProperty("formSubmissionPost")
  FORM_SUBMISSION_POST,
  @JsonProperty("httpHeaderRefresh")
  HTTP_HEADER_REFRESH,
  @JsonProperty("initialFrameNavigation")
  INITIAL_FRAME_NAVIGATION,
  @JsonProperty("metaTagRefresh")
  META_TAG_REFRESH,
  @JsonProperty("other")
  OTHER,
  @JsonProperty("pageBlockInterstitial")
  PAGE_BLOCK_INTERSTITIAL,
  @JsonProperty("reload")
  RELOAD,
  @JsonProperty("scriptInitiated")
  SCRIPT_INITIATED,
  @JsonEnumDefaultValue
  UNKNOWN,
}
