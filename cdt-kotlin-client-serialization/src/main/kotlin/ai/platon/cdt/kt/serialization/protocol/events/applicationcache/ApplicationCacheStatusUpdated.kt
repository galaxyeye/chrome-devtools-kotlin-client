@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.applicationcache
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int
import kotlin.String

@Serializable
data class ApplicationCacheStatusUpdated(
  @SerialName("frameId")
  val frameId: String,
  @SerialName("manifestURL")
  val manifestURL: String,
  @SerialName("status")
  val status: Int,
)
