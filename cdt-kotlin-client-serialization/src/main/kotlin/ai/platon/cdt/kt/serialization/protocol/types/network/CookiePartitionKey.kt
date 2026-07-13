@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * cookiePartitionKey object
 * The representation of the components of the key that are created by the cookiePartitionKey class contained in net/cookies/cookie_partition_key.h.
 */
@Serializable
@Experimental
data class CookiePartitionKey(
  @property:SerialName("topLevelSite")
  val topLevelSite: String,
  @property:SerialName("hasCrossSiteAncestor")
  val hasCrossSiteAncestor: Boolean,
)
