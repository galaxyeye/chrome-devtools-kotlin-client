@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.RemoteObject
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Scope description.
 */
@Serializable
data class Scope(
  @property:SerialName("type")
  val type: ScopeType,
  @property:SerialName("object")
  val `object`: RemoteObject,
  @property:SerialName("name")
  @param:Optional
  val name: String? = null,
  @property:SerialName("startLocation")
  @param:Optional
  val startLocation: Location? = null,
  @property:SerialName("endLocation")
  @param:Optional
  val endLocation: Location? = null,
)
