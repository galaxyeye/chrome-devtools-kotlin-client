@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.cachestorage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

@Serializable
data class Header(
  @SerialName("name")
  val name: String,
  @SerialName("value")
  val `value`: String,
)
