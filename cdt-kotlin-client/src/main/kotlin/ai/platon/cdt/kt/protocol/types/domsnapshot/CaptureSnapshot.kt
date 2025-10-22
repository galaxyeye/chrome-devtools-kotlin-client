package ai.platon.cdt.kt.protocol.types.domsnapshot

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

data class CaptureSnapshot(
  @field:JsonProperty("documents")
  val documents: List<DocumentSnapshot>,
  @field:JsonProperty("strings")
  val strings: List<String>,
)
