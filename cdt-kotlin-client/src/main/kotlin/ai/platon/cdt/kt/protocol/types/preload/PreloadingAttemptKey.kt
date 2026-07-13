@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.preload

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * A key that identifies a preloading attempt.
 *
 * The url used is the url specified by the trigger (i.e. the initial URL), and
 * not the final url that is navigated to. For example, prerendering allows
 * same-origin main frame navigations during the attempt, but the attempt is
 * still keyed with the initial URL.
 */
data class PreloadingAttemptKey(
  @param:JsonProperty("loaderId")
  val loaderId: String,
  @param:JsonProperty("action")
  val action: SpeculationAction,
  @param:JsonProperty("url")
  val url: String,
  @param:JsonProperty("formSubmission")
  @param:Optional
  val formSubmission: Boolean? = null,
  @param:JsonProperty("targetHint")
  @param:Optional
  val targetHint: SpeculationTargetHint? = null,
)
