@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class NetworkConditions(
  @property:SerialName("urlPattern")
  val urlPattern: String,
  @property:SerialName("latency")
  val latency: Double,
  @property:SerialName("downloadThroughput")
  val downloadThroughput: Double,
  @property:SerialName("uploadThroughput")
  val uploadThroughput: Double,
  @property:SerialName("connectionType")
  @param:Optional
  val connectionType: ConnectionType? = null,
  @property:SerialName("packetLoss")
  @param:Optional
  val packetLoss: Double? = null,
  @property:SerialName("packetQueueLength")
  @param:Optional
  val packetQueueLength: Int? = null,
  @property:SerialName("packetReordering")
  @param:Optional
  val packetReordering: Boolean? = null,
  @property:SerialName("offline")
  @param:Optional
  val offline: Boolean? = null,
)
