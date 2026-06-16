@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class CustomPreview(
  @property:SerialName("header")
  val `header`: String,
  @property:SerialName("bodyGetterId")
  @param:Optional
  val bodyGetterId: String? = null,
)
