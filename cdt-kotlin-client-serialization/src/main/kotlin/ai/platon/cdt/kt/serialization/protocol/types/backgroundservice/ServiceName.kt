@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.backgroundservice
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The Background Service that will be associated with the commands/events.
 * Every Background Service operates independently, but they share the same
 * API.
 */
@Serializable
public enum class ServiceName {
  @SerialName("backgroundFetch")
  BACKGROUND_FETCH,
  @SerialName("backgroundSync")
  BACKGROUND_SYNC,
  @SerialName("pushMessaging")
  PUSH_MESSAGING,
  @SerialName("notifications")
  NOTIFICATIONS,
  @SerialName("paymentHandler")
  PAYMENT_HANDLER,
  @SerialName("periodicBackgroundSync")
  PERIODIC_BACKGROUND_SYNC,
}
