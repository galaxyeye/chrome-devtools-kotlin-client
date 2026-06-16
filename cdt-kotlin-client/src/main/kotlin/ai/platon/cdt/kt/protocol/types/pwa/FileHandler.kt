@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.pwa

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

data class FileHandler(
  @param:JsonProperty("action")
  val action: String,
  @param:JsonProperty("accepts")
  val accepts: List<FileHandlerAccept>,
  @param:JsonProperty("displayName")
  val displayName: String,
)
