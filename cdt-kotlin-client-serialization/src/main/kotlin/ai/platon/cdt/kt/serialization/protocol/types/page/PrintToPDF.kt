@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String

@Serializable
data class PrintToPDF(
  @SerialName("data")
  val `data`: String,
  @SerialName("stream")
  @param:Optional
  @param:Experimental
  val stream: String? = null,
)
