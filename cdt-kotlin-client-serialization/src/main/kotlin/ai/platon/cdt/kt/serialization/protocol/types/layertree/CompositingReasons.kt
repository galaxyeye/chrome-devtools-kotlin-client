@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.layertree

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CompositingReasons(
  @property:SerialName("compositingReasons")
  val compositingReasons: List<String>,
  @property:SerialName("compositingReasonIds")
  val compositingReasonIds: List<String>,
)
