@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.dom

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PerformSearch(
  @property:SerialName("searchId")
  val searchId: String,
  @property:SerialName("resultCount")
  val resultCount: Int,
)
