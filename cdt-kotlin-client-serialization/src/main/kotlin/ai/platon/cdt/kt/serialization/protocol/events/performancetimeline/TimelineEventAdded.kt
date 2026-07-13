@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.performancetimeline

import ai.platon.cdt.kt.serialization.protocol.types.performancetimeline.TimelineEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Sent when a performance timeline event is added. See reportPerformanceTimeline method.
 */
@Serializable
data class TimelineEventAdded(
  @property:SerialName("event")
  val event: TimelineEvent,
)
