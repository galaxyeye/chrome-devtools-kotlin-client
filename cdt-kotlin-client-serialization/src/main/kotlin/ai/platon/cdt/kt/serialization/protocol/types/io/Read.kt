@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.io
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String

@Serializable
data class Read(
  @SerialName("base64Encoded")
  @param:Optional
  val base64Encoded: Boolean? = null,
  @SerialName("data")
  val `data`: String,
  @SerialName("eof")
  val eof: Boolean,
)
