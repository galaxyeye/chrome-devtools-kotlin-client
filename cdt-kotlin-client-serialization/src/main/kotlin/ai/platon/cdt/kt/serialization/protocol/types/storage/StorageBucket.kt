@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.storage

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StorageBucket(
  @property:SerialName("storageKey")
  val storageKey: String,
  @property:SerialName("name")
  @param:Optional
  val name: String? = null,
)
