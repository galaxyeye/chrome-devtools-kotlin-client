@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResourceContent(
  @property:SerialName("content")
  val content: String,
  @property:SerialName("base64Encoded")
  val base64Encoded: Boolean,
)
