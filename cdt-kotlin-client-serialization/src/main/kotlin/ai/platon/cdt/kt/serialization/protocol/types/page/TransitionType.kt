@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Transition type.
 */
@Serializable
public enum class TransitionType {
  @SerialName("link")
  LINK,
  @SerialName("typed")
  TYPED,
  @SerialName("address_bar")
  ADDRESS_BAR,
  @SerialName("auto_bookmark")
  AUTO_BOOKMARK,
  @SerialName("auto_subframe")
  AUTO_SUBFRAME,
  @SerialName("manual_subframe")
  MANUAL_SUBFRAME,
  @SerialName("generated")
  GENERATED,
  @SerialName("auto_toplevel")
  AUTO_TOPLEVEL,
  @SerialName("form_submit")
  FORM_SUBMIT,
  @SerialName("reload")
  RELOAD,
  @SerialName("keyword")
  KEYWORD,
  @SerialName("keyword_generated")
  KEYWORD_GENERATED,
  @SerialName("other")
  OTHER,
}
