@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.storage

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

data class StorageBucket(
  @param:JsonProperty("storageKey")
  val storageKey: String,
  @param:JsonProperty("name")
  @param:Optional
  val name: String? = null,
)
