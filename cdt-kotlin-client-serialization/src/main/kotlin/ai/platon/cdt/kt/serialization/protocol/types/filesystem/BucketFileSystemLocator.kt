@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.filesystem

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BucketFileSystemLocator(
  @property:SerialName("storageKey")
  val storageKey: String,
  @property:SerialName("bucketName")
  @param:Optional
  val bucketName: String? = null,
  @property:SerialName("pathComponents")
  val pathComponents: List<String>,
)
