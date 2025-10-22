package ai.platon.cdt.kt.protocol.types.layertree

import com.fasterxml.jackson.`annotation`.JsonProperty
import java.lang.Deprecated
import kotlin.String
import kotlin.collections.List

data class CompositingReasons(
  @field:JsonProperty("compositingReasons")
  @param:Deprecated
  val compositingReasons: List<String>,
  @field:JsonProperty("compositingReasonIds")
  val compositingReasonIds: List<String>,
)
