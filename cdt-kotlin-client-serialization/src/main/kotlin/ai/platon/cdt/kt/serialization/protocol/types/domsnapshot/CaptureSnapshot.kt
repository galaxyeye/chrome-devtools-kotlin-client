@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domsnapshot
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String
import kotlin.collections.List

@Serializable
data class CaptureSnapshot(
  @SerialName("documents")
  val documents: List<DocumentSnapshot>,
  @SerialName("strings")
  val strings: List<String>,
)
