@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class SameSiteCookieOperation {
  @SerialName("SetCookie")
  SET_COOKIE,
  @SerialName("ReadCookie")
  READ_COOKIE,
  UNKNOWN,
}
