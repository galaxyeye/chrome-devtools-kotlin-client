@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Whether to allow all or deny all download requests, or use default Chrome behavior if
 * available (otherwise deny).
 */
@Serializable
public enum class SetDownloadBehaviorBehavior {
  @SerialName("deny")
  DENY,
  @SerialName("allow")
  ALLOW,
  @SerialName("default")
  DEFAULT,
}
