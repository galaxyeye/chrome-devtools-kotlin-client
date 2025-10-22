package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * Cookie object
 */
data class Cookie(
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("value")
  val `value`: String,
  @field:JsonProperty("domain")
  val domain: String,
  @field:JsonProperty("path")
  val path: String,
  @field:JsonProperty("expires")
  val expires: Double,
  @field:JsonProperty("size")
  val size: Int,
  @field:JsonProperty("httpOnly")
  val httpOnly: Boolean,
  @field:JsonProperty("secure")
  val secure: Boolean,
  @field:JsonProperty("session")
  val session: Boolean,
  @field:JsonProperty("sameSite")
  @param:Optional
  val sameSite: CookieSameSite? = null,
  @field:JsonProperty("priority")
  @param:Experimental
  val priority: CookiePriority,
  @field:JsonProperty("sameParty")
  @param:Experimental
  val sameParty: Boolean,
  @field:JsonProperty("sourceScheme")
  @param:Experimental
  val sourceScheme: CookieSourceScheme,
  @field:JsonProperty("sourcePort")
  @param:Experimental
  val sourcePort: Int,
)
