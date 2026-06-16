@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.io

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Read(
  @property:SerialName("base64Encoded")
  @param:Optional
  val base64Encoded: Boolean? = null,
  @property:SerialName("data")
  val `data`: String,
  @property:SerialName("eof")
  val eof: Boolean,
)
