@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.profiler
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.profiler.ScriptCoverage
import kotlin.Double
import kotlin.String
import kotlin.collections.List

/**
 * Reports coverage delta since the last poll (either from an event like this, or from
 * `takePreciseCoverage` for the current isolate. May only be sent if precise code
 * coverage has been started. This event can be trigged by the embedder to, for example,
 * trigger collection of coverage data immediatelly at a certain point in time.
 */
@Experimental
@Serializable
data class PreciseCoverageDeltaUpdate(
  @SerialName("timestamp")
  val timestamp: Double,
  @SerialName("occassion")
  val occassion: String,
  @SerialName("result")
  val result: List<ScriptCoverage>,
)
