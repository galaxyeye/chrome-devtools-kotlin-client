@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.preload

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A key that identifies a preloading attempt.
 *
 * The url used is the url specified by the trigger (i.e. the initial URL), and
 * not the final url that is navigated to. For example, prerendering allows
 * same-origin main frame navigations during the attempt, but the attempt is
 * still keyed with the initial URL.
 */
@Serializable
data class PreloadingAttemptKey(
  @property:SerialName("loaderId")
  val loaderId: String,
  @property:SerialName("action")
  val action: SpeculationAction,
  @property:SerialName("url")
  val url: String,
  @property:SerialName("formSubmission")
  @param:Optional
  val formSubmission: Boolean? = null,
  @property:SerialName("targetHint")
  @param:Optional
  val targetHint: SpeculationTargetHint? = null,
)
