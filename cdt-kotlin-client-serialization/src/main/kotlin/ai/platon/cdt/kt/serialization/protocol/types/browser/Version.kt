@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.browser
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

@Serializable
data class Version(
  @SerialName("protocolVersion")
  val protocolVersion: String,
  @SerialName("product")
  val product: String,
  @SerialName("revision")
  val revision: String,
  @SerialName("userAgent")
  val userAgent: String,
  @SerialName("jsVersion")
  val jsVersion: String,
)
