@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.serviceworker

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class ServiceWorkerVersionRunningStatus {
  @SerialName("stopped")
  STOPPED,
  @SerialName("starting")
  STARTING,
  @SerialName("running")
  RUNNING,
  @SerialName("stopping")
  STOPPING,
  UNKNOWN,
}
