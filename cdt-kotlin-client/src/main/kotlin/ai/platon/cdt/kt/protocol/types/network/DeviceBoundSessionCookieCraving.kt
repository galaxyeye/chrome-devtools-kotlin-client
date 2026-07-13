@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * A device bound session's cookie craving.
 */
@Experimental
data class DeviceBoundSessionCookieCraving(
  @param:JsonProperty("name")
  val name: String,
  @param:JsonProperty("domain")
  val domain: String,
  @param:JsonProperty("path")
  val path: String,
  @param:JsonProperty("secure")
  val secure: Boolean,
  @param:JsonProperty("httpOnly")
  val httpOnly: Boolean,
  @param:JsonProperty("sameSite")
  @param:Optional
  val sameSite: CookieSameSite? = null,
)
