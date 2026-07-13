@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * cookiePartitionKey object
 * The representation of the components of the key that are created by the cookiePartitionKey class contained in net/cookies/cookie_partition_key.h.
 */
@Experimental
data class CookiePartitionKey(
  @param:JsonProperty("topLevelSite")
  val topLevelSite: String,
  @param:JsonProperty("hasCrossSiteAncestor")
  val hasCrossSiteAncestor: Boolean,
)
