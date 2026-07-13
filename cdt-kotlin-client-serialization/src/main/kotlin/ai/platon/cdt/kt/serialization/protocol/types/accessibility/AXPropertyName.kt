@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.accessibility

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Values of AXProperty name:
 * - from 'busy' to 'roledescription': states which apply to every AX node
 * - from 'live' to 'root': attributes which apply to nodes in live regions
 * - from 'autocomplete' to 'valuetext': attributes which apply to widgets
 * - from 'checked' to 'selected': states which apply to widgets
 * - from 'activedescendant' to 'owns': relationships between elements other than parent/child/sibling
 * - from 'activeFullscreenElement' to 'uninteresting': reasons why this noode is hidden
 */
@Serializable
public enum class AXPropertyName {
  @SerialName("actions")
  ACTIONS,
  @SerialName("busy")
  BUSY,
  @SerialName("disabled")
  DISABLED,
  @SerialName("editable")
  EDITABLE,
  @SerialName("focusable")
  FOCUSABLE,
  @SerialName("focused")
  FOCUSED,
  @SerialName("hidden")
  HIDDEN,
  @SerialName("hiddenRoot")
  HIDDEN_ROOT,
  @SerialName("invalid")
  INVALID,
  @SerialName("keyshortcuts")
  KEYSHORTCUTS,
  @SerialName("settable")
  SETTABLE,
  @SerialName("roledescription")
  ROLEDESCRIPTION,
  @SerialName("live")
  LIVE,
  @SerialName("atomic")
  ATOMIC,
  @SerialName("relevant")
  RELEVANT,
  @SerialName("root")
  ROOT,
  @SerialName("autocomplete")
  AUTOCOMPLETE,
  @SerialName("hasPopup")
  HAS_POPUP,
  @SerialName("level")
  LEVEL,
  @SerialName("multiselectable")
  MULTISELECTABLE,
  @SerialName("orientation")
  ORIENTATION,
  @SerialName("multiline")
  MULTILINE,
  @SerialName("readonly")
  READONLY,
  @SerialName("required")
  REQUIRED,
  @SerialName("valuemin")
  VALUEMIN,
  @SerialName("valuemax")
  VALUEMAX,
  @SerialName("valuetext")
  VALUETEXT,
  @SerialName("checked")
  CHECKED,
  @SerialName("expanded")
  EXPANDED,
  @SerialName("modal")
  MODAL,
  @SerialName("pressed")
  PRESSED,
  @SerialName("selected")
  SELECTED,
  @SerialName("activedescendant")
  ACTIVEDESCENDANT,
  @SerialName("controls")
  CONTROLS,
  @SerialName("describedby")
  DESCRIBEDBY,
  @SerialName("details")
  DETAILS,
  @SerialName("errormessage")
  ERRORMESSAGE,
  @SerialName("flowto")
  FLOWTO,
  @SerialName("labelledby")
  LABELLEDBY,
  @SerialName("owns")
  OWNS,
  @SerialName("url")
  URL,
  @SerialName("activeFullscreenElement")
  ACTIVE_FULLSCREEN_ELEMENT,
  @SerialName("activeModalDialog")
  ACTIVE_MODAL_DIALOG,
  @SerialName("activeAriaModalDialog")
  ACTIVE_ARIA_MODAL_DIALOG,
  @SerialName("ariaHiddenElement")
  ARIA_HIDDEN_ELEMENT,
  @SerialName("ariaHiddenSubtree")
  ARIA_HIDDEN_SUBTREE,
  @SerialName("emptyAlt")
  EMPTY_ALT,
  @SerialName("emptyText")
  EMPTY_TEXT,
  @SerialName("inertElement")
  INERT_ELEMENT,
  @SerialName("inertSubtree")
  INERT_SUBTREE,
  @SerialName("labelContainer")
  LABEL_CONTAINER,
  @SerialName("labelFor")
  LABEL_FOR,
  @SerialName("notRendered")
  NOT_RENDERED,
  @SerialName("notVisible")
  NOT_VISIBLE,
  @SerialName("presentationalRole")
  PRESENTATIONAL_ROLE,
  @SerialName("probablyPresentational")
  PROBABLY_PRESENTATIONAL,
  @SerialName("inactiveCarouselTabContent")
  INACTIVE_CAROUSEL_TAB_CONTENT,
  @SerialName("uninteresting")
  UNINTERESTING,
  UNKNOWN,
}
