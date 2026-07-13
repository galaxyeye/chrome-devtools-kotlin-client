@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class GenericIssueErrorType {
  @SerialName("FormLabelForNameError")
  FORM_LABEL_FOR_NAME_ERROR,
  @SerialName("FormDuplicateIdForInputError")
  FORM_DUPLICATE_ID_FOR_INPUT_ERROR,
  @SerialName("FormInputWithNoLabelError")
  FORM_INPUT_WITH_NO_LABEL_ERROR,
  @SerialName("FormAutocompleteAttributeEmptyError")
  FORM_AUTOCOMPLETE_ATTRIBUTE_EMPTY_ERROR,
  @SerialName("FormEmptyIdAndNameAttributesForInputError")
  FORM_EMPTY_ID_AND_NAME_ATTRIBUTES_FOR_INPUT_ERROR,
  @SerialName("FormAriaLabelledByToNonExistingIdError")
  FORM_ARIA_LABELLED_BY_TO_NON_EXISTING_ID_ERROR,
  @SerialName("FormInputAssignedAutocompleteValueToIdOrNameAttributeError")
  FORM_INPUT_ASSIGNED_AUTOCOMPLETE_VALUE_TO_ID_OR_NAME_ATTRIBUTE_ERROR,
  @SerialName("FormLabelHasNeitherForNorNestedInputError")
  FORM_LABEL_HAS_NEITHER_FOR_NOR_NESTED_INPUT_ERROR,
  @SerialName("FormLabelForMatchesNonExistingIdError")
  FORM_LABEL_FOR_MATCHES_NON_EXISTING_ID_ERROR,
  @SerialName("FormInputHasWrongButWellIntendedAutocompleteValueError")
  FORM_INPUT_HAS_WRONG_BUT_WELL_INTENDED_AUTOCOMPLETE_VALUE_ERROR,
  @SerialName("ResponseWasBlockedByORB")
  RESPONSE_WAS_BLOCKED_BY_ORB,
  @SerialName("NavigationEntryMarkedSkippable")
  NAVIGATION_ENTRY_MARKED_SKIPPABLE,
  @SerialName("BackUINavigationWouldSkipAd")
  BACK_UI_NAVIGATION_WOULD_SKIP_AD,
  @SerialName("AutofillAndManualTextPolicyControlledFeaturesInfo")
  AUTOFILL_AND_MANUAL_TEXT_POLICY_CONTROLLED_FEATURES_INFO,
  @SerialName("AutofillPolicyControlledFeatureInfo")
  AUTOFILL_POLICY_CONTROLLED_FEATURE_INFO,
  @SerialName("ManualTextPolicyControlledFeatureInfo")
  MANUAL_TEXT_POLICY_CONTROLLED_FEATURE_INFO,
  @SerialName("FormModelContextParameterMissingTitleAndDescription")
  FORM_MODEL_CONTEXT_PARAMETER_MISSING_TITLE_AND_DESCRIPTION,
  @SerialName("FormModelContextMissingToolName")
  FORM_MODEL_CONTEXT_MISSING_TOOL_NAME,
  @SerialName("FormModelContextMissingToolDescription")
  FORM_MODEL_CONTEXT_MISSING_TOOL_DESCRIPTION,
  @SerialName("FormModelContextRequiredParameterMissingName")
  FORM_MODEL_CONTEXT_REQUIRED_PARAMETER_MISSING_NAME,
  @SerialName("FormModelContextParameterMissingName")
  FORM_MODEL_CONTEXT_PARAMETER_MISSING_NAME,
  UNKNOWN,
}
