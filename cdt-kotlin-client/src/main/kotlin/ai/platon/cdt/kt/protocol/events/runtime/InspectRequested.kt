@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.runtime.RemoteObject
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

/**
 * Issued when object should be inspected (for example, as a result of inspect() command line API
 * call).
 */
data class InspectRequested(
  @param:JsonProperty("object")
  val `object`: RemoteObject,
  @param:JsonProperty("hints")
  val hints: Map<String, Any?>,
  @param:JsonProperty("executionContextId")
  @param:Optional
  @param:Experimental
  val executionContextId: Int? = null,
)
