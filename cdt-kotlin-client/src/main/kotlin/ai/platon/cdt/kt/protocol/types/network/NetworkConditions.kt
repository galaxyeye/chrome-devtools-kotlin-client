@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String

@Experimental
data class NetworkConditions(
  @param:JsonProperty("urlPattern")
  val urlPattern: String,
  @param:JsonProperty("latency")
  val latency: Double,
  @param:JsonProperty("downloadThroughput")
  val downloadThroughput: Double,
  @param:JsonProperty("uploadThroughput")
  val uploadThroughput: Double,
  @param:JsonProperty("connectionType")
  @param:Optional
  val connectionType: ConnectionType? = null,
  @param:JsonProperty("packetLoss")
  @param:Optional
  val packetLoss: Double? = null,
  @param:JsonProperty("packetQueueLength")
  @param:Optional
  val packetQueueLength: Int? = null,
  @param:JsonProperty("packetReordering")
  @param:Optional
  val packetReordering: Boolean? = null,
  @param:JsonProperty("offline")
  @param:Optional
  val offline: Boolean? = null,
)
