@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.storage

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * A single Related Website Set object.
 */
@Experimental
data class RelatedWebsiteSet(
  @param:JsonProperty("primarySites")
  val primarySites: List<String>,
  @param:JsonProperty("associatedSites")
  val associatedSites: List<String>,
  @param:JsonProperty("serviceSites")
  val serviceSites: List<String>,
)
