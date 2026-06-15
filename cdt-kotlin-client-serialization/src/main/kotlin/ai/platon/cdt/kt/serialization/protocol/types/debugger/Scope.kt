@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.RemoteObject
import kotlin.String

/**
 * Scope description.
 */
@Serializable
data class Scope(
  @SerialName("type")
  val type: ScopeType,
  @SerialName("object")
  val `object`: RemoteObject,
  @SerialName("name")
  @param:Optional
  val name: String? = null,
  @SerialName("startLocation")
  @param:Optional
  val startLocation: Location? = null,
  @SerialName("endLocation")
  @param:Optional
  val endLocation: Location? = null,
)
