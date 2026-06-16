@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class ClientNavigationReason {
  @SerialName("anchorClick")
  ANCHOR_CLICK,
  @SerialName("formSubmissionGet")
  FORM_SUBMISSION_GET,
  @SerialName("formSubmissionPost")
  FORM_SUBMISSION_POST,
  @SerialName("httpHeaderRefresh")
  HTTP_HEADER_REFRESH,
  @SerialName("initialFrameNavigation")
  INITIAL_FRAME_NAVIGATION,
  @SerialName("metaTagRefresh")
  META_TAG_REFRESH,
  @SerialName("other")
  OTHER,
  @SerialName("pageBlockInterstitial")
  PAGE_BLOCK_INTERSTITIAL,
  @SerialName("reload")
  RELOAD,
  @SerialName("scriptInitiated")
  SCRIPT_INITIATED,
  UNKNOWN,
}
