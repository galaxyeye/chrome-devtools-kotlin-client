@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String

@Experimental
@Serializable
data class CustomPreview(
  @SerialName("header")
  val `header`: String,
  @SerialName("bodyGetterId")
  @param:Optional
  val bodyGetterId: String? = null,
)
