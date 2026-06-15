@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domsnapshot
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int
import kotlin.collections.List

@Serializable
data class RareBooleanData(
  @SerialName("index")
  val index: List<Int>,
)
