@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.browser

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Version(
  @property:SerialName("protocolVersion")
  val protocolVersion: String,
  @property:SerialName("product")
  val product: String,
  @property:SerialName("revision")
  val revision: String,
  @property:SerialName("userAgent")
  val userAgent: String,
  @property:SerialName("jsVersion")
  val jsVersion: String,
)
