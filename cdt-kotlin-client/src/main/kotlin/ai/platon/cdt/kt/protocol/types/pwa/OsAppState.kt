@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.pwa

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.collections.List

data class OsAppState(
  @param:JsonProperty("badgeCount")
  val badgeCount: Int,
  @param:JsonProperty("fileHandlers")
  val fileHandlers: List<FileHandler>,
)
