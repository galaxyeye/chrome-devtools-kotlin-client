@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class Screenshot(
  @property:SerialName("image")
  val image: ImageResource,
  @property:SerialName("formFactor")
  val formFactor: String,
  @property:SerialName("label")
  @param:Optional
  val label: String? = null,
)
