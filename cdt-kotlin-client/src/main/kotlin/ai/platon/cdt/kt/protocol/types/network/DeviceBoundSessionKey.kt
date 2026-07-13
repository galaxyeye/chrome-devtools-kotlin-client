@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Unique identifier for a device bound session.
 */
@Experimental
data class DeviceBoundSessionKey(
  @param:JsonProperty("site")
  val site: String,
  @param:JsonProperty("id")
  val id: String,
)
