@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.applicationcache
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int
import kotlin.String

/**
 * Frame identifier - manifest URL pair.
 */
@Serializable
data class FrameWithManifest(
  @SerialName("frameId")
  val frameId: String,
  @SerialName("manifestURL")
  val manifestURL: String,
  @SerialName("status")
  val status: Int,
)
