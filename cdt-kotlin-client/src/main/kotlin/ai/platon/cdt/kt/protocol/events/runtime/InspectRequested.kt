package ai.platon.cdt.kt.protocol.events.runtime

import ai.platon.cdt.kt.protocol.types.runtime.RemoteObject
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.String
import kotlin.collections.Map

/**
 * Issued when object should be inspected (for example, as a result of inspect() command line API
 * call).
 */
data class InspectRequested(
  @field:JsonProperty("object")
  val `object`: RemoteObject,
  @field:JsonProperty("hints")
  val hints: Map<String, Any?>,
)
