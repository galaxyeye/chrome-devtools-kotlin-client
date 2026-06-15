@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.tethering
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int
import kotlin.String

/**
 * Informs that port was successfully bound and got a specified connection id.
 */
@Serializable
data class Accepted(
  @SerialName("port")
  val port: Int,
  @SerialName("connectionId")
  val connectionId: String,
)
