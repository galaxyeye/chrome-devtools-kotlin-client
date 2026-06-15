@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.performancetimeline
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.performancetimeline.TimelineEvent

/**
 * Sent when a performance timeline event is added. See reportPerformanceTimeline method.
 */
@Serializable
data class TimelineEventAdded(
  @SerialName("event")
  val event: TimelineEvent,
)
