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
data class FileFilter(
  @property:SerialName("name")
  @param:Optional
  val name: String? = null,
  @property:SerialName("accepts")
  @param:Optional
  val accepts: List<String>? = null,
)
