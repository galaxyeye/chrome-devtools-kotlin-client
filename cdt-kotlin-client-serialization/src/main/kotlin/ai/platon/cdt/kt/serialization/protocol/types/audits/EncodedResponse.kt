@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EncodedResponse(
  @property:SerialName("body")
  @param:Optional
  val body: String? = null,
  @property:SerialName("originalSize")
  val originalSize: Int,
  @property:SerialName("encodedSize")
  val encodedSize: Int,
)
