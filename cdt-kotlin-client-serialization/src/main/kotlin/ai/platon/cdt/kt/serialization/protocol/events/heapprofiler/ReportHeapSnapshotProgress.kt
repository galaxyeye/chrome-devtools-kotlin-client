@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.heapprofiler

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReportHeapSnapshotProgress(
  @property:SerialName("done")
  val done: Int,
  @property:SerialName("total")
  val total: Int,
  @property:SerialName("finished")
  @param:Optional
  val finished: Boolean? = null,
)
