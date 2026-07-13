@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.browser

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Whether to allow all or deny all download requests, or use default Chrome behavior if
 * available (otherwise deny). |allowAndName| allows download and names files according to
 * their download guids.
 */
@Serializable
public enum class SetDownloadBehaviorBehavior {
  @SerialName("deny")
  DENY,
  @SerialName("allow")
  ALLOW,
  @SerialName("allowAndName")
  ALLOW_AND_NAME,
  @SerialName("default")
  DEFAULT,
  UNKNOWN,
}
