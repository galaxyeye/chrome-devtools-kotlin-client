@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String

@Serializable
data class EncodedResponse(
  @SerialName("body")
  @param:Optional
  val body: String? = null,
  @SerialName("originalSize")
  val originalSize: Int,
  @SerialName("encodedSize")
  val encodedSize: Int,
)
