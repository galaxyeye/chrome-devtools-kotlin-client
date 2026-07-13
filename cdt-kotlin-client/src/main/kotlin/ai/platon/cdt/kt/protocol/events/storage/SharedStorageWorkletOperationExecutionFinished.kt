@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.storage

import ai.platon.cdt.kt.protocol.types.storage.SharedStorageAccessMethod
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * A shared storage run or selectURL operation finished its execution.
 * The following parameters are included in all events.
 */
data class SharedStorageWorkletOperationExecutionFinished(
  @param:JsonProperty("finishedTime")
  val finishedTime: Double,
  @param:JsonProperty("executionTime")
  val executionTime: Int,
  @param:JsonProperty("method")
  val method: SharedStorageAccessMethod,
  @param:JsonProperty("operationId")
  val operationId: String,
  @param:JsonProperty("workletTargetId")
  val workletTargetId: String,
  @param:JsonProperty("mainFrameId")
  val mainFrameId: String,
  @param:JsonProperty("ownerOrigin")
  val ownerOrigin: String,
)
