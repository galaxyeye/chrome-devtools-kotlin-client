package ai.platon.cdt.kt.protocol.events.heapprofiler

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Int

data class ReportHeapSnapshotProgress(
  @field:JsonProperty("done")
  val done: Int,
  @field:JsonProperty("total")
  val total: Int,
  @field:JsonProperty("finished")
  @param:Optional
  val finished: Boolean? = null,
)
