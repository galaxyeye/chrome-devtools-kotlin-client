@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.extensions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Storage areas.
 */
@Serializable
public enum class StorageArea {
  @SerialName("session")
  SESSION,
  @SerialName("local")
  LOCAL,
  @SerialName("sync")
  SYNC,
  @SerialName("managed")
  MANAGED,
  UNKNOWN,
}
