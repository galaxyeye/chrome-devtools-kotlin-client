@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestPostData(
  @property:SerialName("postData")
  val postData: String,
  @property:SerialName("base64Encoded")
  val base64Encoded: Boolean,
)
