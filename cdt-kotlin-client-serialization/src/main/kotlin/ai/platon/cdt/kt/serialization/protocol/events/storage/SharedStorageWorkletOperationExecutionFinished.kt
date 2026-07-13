@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.storage

import ai.platon.cdt.kt.serialization.protocol.types.storage.SharedStorageAccessMethod
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A shared storage run or selectURL operation finished its execution.
 * The following parameters are included in all events.
 */
@Serializable
data class SharedStorageWorkletOperationExecutionFinished(
  @property:SerialName("finishedTime")
  val finishedTime: Double,
  @property:SerialName("executionTime")
  val executionTime: Int,
  @property:SerialName("method")
  val method: SharedStorageAccessMethod,
  @property:SerialName("operationId")
  val operationId: String,
  @property:SerialName("workletTargetId")
  val workletTargetId: String,
  @property:SerialName("mainFrameId")
  val mainFrameId: String,
  @property:SerialName("ownerOrigin")
  val ownerOrigin: String,
)
