@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.applicationcache

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Frame identifier - manifest URL pair.
 */
@Serializable
data class FrameWithManifest(
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("manifestURL")
  val manifestURL: String,
  @property:SerialName("status")
  val status: Int,
)
