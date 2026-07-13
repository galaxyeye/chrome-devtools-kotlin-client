@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class BlockPattern(
  @property:SerialName("urlPattern")
  val urlPattern: String,
  @property:SerialName("block")
  val block: Boolean,
)
