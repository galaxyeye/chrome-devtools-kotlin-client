@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.pwa

import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OsAppState(
  @property:SerialName("badgeCount")
  val badgeCount: Int,
  @property:SerialName("fileHandlers")
  val fileHandlers: List<FileHandler>,
)
