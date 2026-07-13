@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.target

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class RemoteLocation(
  @property:SerialName("host")
  val host: String,
  @property:SerialName("port")
  val port: Int,
)
