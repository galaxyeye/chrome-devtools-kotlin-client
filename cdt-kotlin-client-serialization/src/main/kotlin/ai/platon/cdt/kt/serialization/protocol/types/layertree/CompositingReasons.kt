@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.layertree
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Deprecated
import kotlin.String
import kotlin.collections.List

@Serializable
data class CompositingReasons(
  @SerialName("compositingReasons")
  @Deprecated("Deprecated by protocol")
  val compositingReasons: List<String>,
  @SerialName("compositingReasonIds")
  val compositingReasonIds: List<String>,
)
