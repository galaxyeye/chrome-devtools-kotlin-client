@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.storage

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A single Related Website Set object.
 */
@Serializable
@Experimental
data class RelatedWebsiteSet(
  @property:SerialName("primarySites")
  val primarySites: List<String>,
  @property:SerialName("associatedSites")
  val associatedSites: List<String>,
  @property:SerialName("serviceSites")
  val serviceSites: List<String>,
)
