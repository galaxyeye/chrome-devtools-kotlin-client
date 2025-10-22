package ai.platon.cdt.kt.protocol.events.heapprofiler

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Int

public data class ReportHeapSnapshotProgress(
  @field:JsonProperty("done")
  public val done: Int,
  @field:JsonProperty("total")
  public val total: Int,
  @field:JsonProperty("finished")
  @param:Optional
  public val finished: Boolean? = null,
)
