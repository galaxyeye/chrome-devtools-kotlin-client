@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Unique identifier for a device bound session.
 */
@Serializable
@Experimental
data class DeviceBoundSessionKey(
  @property:SerialName("site")
  val site: String,
  @property:SerialName("id")
  val id: String,
)
