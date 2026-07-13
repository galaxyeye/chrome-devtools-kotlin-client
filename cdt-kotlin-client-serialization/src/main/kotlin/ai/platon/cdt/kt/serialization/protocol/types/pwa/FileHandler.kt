@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.pwa

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FileHandler(
  @property:SerialName("action")
  val action: String,
  @property:SerialName("accepts")
  val accepts: List<FileHandlerAccept>,
  @property:SerialName("displayName")
  val displayName: String,
)
