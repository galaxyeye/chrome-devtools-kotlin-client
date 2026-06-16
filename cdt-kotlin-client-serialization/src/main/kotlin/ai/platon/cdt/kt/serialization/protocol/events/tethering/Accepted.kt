@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.tethering

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Informs that port was successfully bound and got a specified connection id.
 */
@Serializable
data class Accepted(
  @property:SerialName("port")
  val port: Int,
  @property:SerialName("connectionId")
  val connectionId: String,
)
