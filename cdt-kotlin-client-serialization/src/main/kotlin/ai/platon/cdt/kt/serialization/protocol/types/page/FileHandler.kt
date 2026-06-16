@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class FileHandler(
  @property:SerialName("action")
  val action: String,
  @property:SerialName("name")
  val name: String,
  @property:SerialName("icons")
  @param:Optional
  val icons: List<ImageResource>? = null,
  @property:SerialName("accepts")
  @param:Optional
  val accepts: List<FileFilter>? = null,
  @property:SerialName("launchType")
  val launchType: String,
)
