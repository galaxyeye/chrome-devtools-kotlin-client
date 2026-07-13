@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.serviceworker

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class ServiceWorkerVersionStatus {
  @SerialName("new")
  NEW,
  @SerialName("installing")
  INSTALLING,
  @SerialName("installed")
  INSTALLED,
  @SerialName("activating")
  ACTIVATING,
  @SerialName("activated")
  ACTIVATED,
  @SerialName("redundant")
  REDUNDANT,
  UNKNOWN,
}
