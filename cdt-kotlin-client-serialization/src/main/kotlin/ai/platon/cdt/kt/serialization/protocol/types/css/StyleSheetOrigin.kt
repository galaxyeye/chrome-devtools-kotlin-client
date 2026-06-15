@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Stylesheet type: "injected" for stylesheets injected via extension, "user-agent" for user-agent
 * stylesheets, "inspector" for stylesheets created by the inspector (i.e. those holding the "via
 * inspector" rules), "regular" for regular stylesheets.
 */
@Serializable
public enum class StyleSheetOrigin {
  @SerialName("injected")
  INJECTED,
  @SerialName("user-agent")
  USER_AGENT,
  @SerialName("inspector")
  INSPECTOR,
  @SerialName("regular")
  REGULAR,
}
