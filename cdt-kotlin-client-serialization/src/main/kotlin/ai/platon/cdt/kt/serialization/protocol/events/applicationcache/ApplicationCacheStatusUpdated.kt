@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.applicationcache

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApplicationCacheStatusUpdated(
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("manifestURL")
  val manifestURL: String,
  @property:SerialName("status")
  val status: Int,
)
