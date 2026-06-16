@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.domsnapshot

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CaptureSnapshot(
  @property:SerialName("documents")
  val documents: List<DocumentSnapshot>,
  @property:SerialName("strings")
  val strings: List<String>,
)
