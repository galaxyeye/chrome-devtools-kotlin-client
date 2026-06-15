@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.dom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int
import kotlin.String

@Serializable
data class PerformSearch(
  @SerialName("searchId")
  val searchId: String,
  @SerialName("resultCount")
  val resultCount: Int,
)
