@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.filesystem

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

data class BucketFileSystemLocator(
  @param:JsonProperty("storageKey")
  val storageKey: String,
  @param:JsonProperty("bucketName")
  @param:Optional
  val bucketName: String? = null,
  @param:JsonProperty("pathComponents")
  val pathComponents: List<String>,
)
