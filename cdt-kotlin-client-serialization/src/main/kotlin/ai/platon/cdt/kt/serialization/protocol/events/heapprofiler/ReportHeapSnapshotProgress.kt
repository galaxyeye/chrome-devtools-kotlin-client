@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.heapprofiler
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Int

@Serializable
data class ReportHeapSnapshotProgress(
  @SerialName("done")
  val done: Int,
  @SerialName("total")
  val total: Int,
  @SerialName("finished")
  @param:Optional
  val finished: Boolean? = null,
)
