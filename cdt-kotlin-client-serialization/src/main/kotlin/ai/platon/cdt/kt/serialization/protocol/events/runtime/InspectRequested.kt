@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.runtime

import ai.platon.cdt.kt.serialization.protocol.types.runtime.RemoteObject
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

/**
 * Issued when object should be inspected (for example, as a result of inspect() command line API
 * call).
 */
@Serializable
data class InspectRequested(
  @property:SerialName("object")
  val `object`: RemoteObject,
  @property:SerialName("hints")
  val hints: JsonObject?,
)
