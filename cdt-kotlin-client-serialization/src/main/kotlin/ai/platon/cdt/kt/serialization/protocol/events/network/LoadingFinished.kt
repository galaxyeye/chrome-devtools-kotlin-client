@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Double
import kotlin.String

/**
 * Fired when HTTP request has finished loading.
 */
@Serializable
data class LoadingFinished(
  @SerialName("requestId")
  val requestId: String,
  @SerialName("timestamp")
  val timestamp: Double,
  @SerialName("encodedDataLength")
  val encodedDataLength: Double,
  @SerialName("shouldReportCorbBlocking")
  @param:Optional
  val shouldReportCorbBlocking: Boolean? = null,
)
