@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class AttributionReportingIssueType {
  @SerialName("PermissionPolicyDisabled")
  PERMISSION_POLICY_DISABLED,
  @SerialName("UntrustworthyReportingOrigin")
  UNTRUSTWORTHY_REPORTING_ORIGIN,
  @SerialName("InsecureContext")
  INSECURE_CONTEXT,
  @SerialName("InvalidHeader")
  INVALID_HEADER,
  @SerialName("InvalidRegisterTriggerHeader")
  INVALID_REGISTER_TRIGGER_HEADER,
  @SerialName("SourceAndTriggerHeaders")
  SOURCE_AND_TRIGGER_HEADERS,
  @SerialName("SourceIgnored")
  SOURCE_IGNORED,
  @SerialName("TriggerIgnored")
  TRIGGER_IGNORED,
  @SerialName("OsSourceIgnored")
  OS_SOURCE_IGNORED,
  @SerialName("OsTriggerIgnored")
  OS_TRIGGER_IGNORED,
  @SerialName("InvalidRegisterOsSourceHeader")
  INVALID_REGISTER_OS_SOURCE_HEADER,
  @SerialName("InvalidRegisterOsTriggerHeader")
  INVALID_REGISTER_OS_TRIGGER_HEADER,
  @SerialName("WebAndOsHeaders")
  WEB_AND_OS_HEADERS,
  @SerialName("NoWebOrOsSupport")
  NO_WEB_OR_OS_SUPPORT,
  @SerialName("NavigationRegistrationWithoutTransientUserActivation")
  NAVIGATION_REGISTRATION_WITHOUT_TRANSIENT_USER_ACTIVATION,
  @SerialName("InvalidInfoHeader")
  INVALID_INFO_HEADER,
  @SerialName("NoRegisterSourceHeader")
  NO_REGISTER_SOURCE_HEADER,
  @SerialName("NoRegisterTriggerHeader")
  NO_REGISTER_TRIGGER_HEADER,
  @SerialName("NoRegisterOsSourceHeader")
  NO_REGISTER_OS_SOURCE_HEADER,
  @SerialName("NoRegisterOsTriggerHeader")
  NO_REGISTER_OS_TRIGGER_HEADER,
  @SerialName("NavigationRegistrationUniqueScopeAlreadySet")
  NAVIGATION_REGISTRATION_UNIQUE_SCOPE_ALREADY_SET,
  UNKNOWN,
}
