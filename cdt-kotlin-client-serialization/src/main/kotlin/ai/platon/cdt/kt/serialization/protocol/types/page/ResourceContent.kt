@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Boolean
import kotlin.String

@Serializable
data class ResourceContent(
  @SerialName("content")
  val content: String,
  @SerialName("base64Encoded")
  val base64Encoded: Boolean,
)
