@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PrintToPDF(
  @property:SerialName("data")
  val `data`: String,
  @property:SerialName("stream")
  @param:Optional
  @param:Experimental
  val stream: String? = null,
)
