@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Type of the call.
 */
@Serializable
public enum class ConsoleAPICalledType {
  @SerialName("log")
  LOG,
  @SerialName("debug")
  DEBUG,
  @SerialName("info")
  INFO,
  @SerialName("error")
  ERROR,
  @SerialName("warning")
  WARNING,
  @SerialName("dir")
  DIR,
  @SerialName("dirxml")
  DIRXML,
  @SerialName("table")
  TABLE,
  @SerialName("trace")
  TRACE,
  @SerialName("clear")
  CLEAR,
  @SerialName("startGroup")
  START_GROUP,
  @SerialName("startGroupCollapsed")
  START_GROUP_COLLAPSED,
  @SerialName("endGroup")
  END_GROUP,
  @SerialName("assert")
  ASSERT,
  @SerialName("profile")
  PROFILE,
  @SerialName("profileEnd")
  PROFILE_END,
  @SerialName("count")
  COUNT,
  @SerialName("timeEnd")
  TIME_END,
}
