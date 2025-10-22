package ai.platon.cdt.kt.protocol.events.page

import ai.platon.cdt.kt.protocol.types.page.ClientNavigationReason
import com.fasterxml.jackson.`annotation`.JsonProperty
import java.lang.Deprecated
import kotlin.Double
import kotlin.String

/**
 * Fired when frame schedules a potential navigation.
 */
@Deprecated
data class FrameScheduledNavigation(
  @field:JsonProperty("frameId")
  val frameId: String,
  @field:JsonProperty("delay")
  val delay: Double,
  @field:JsonProperty("reason")
  val reason: ClientNavigationReason,
  @field:JsonProperty("url")
  val url: String,
)
