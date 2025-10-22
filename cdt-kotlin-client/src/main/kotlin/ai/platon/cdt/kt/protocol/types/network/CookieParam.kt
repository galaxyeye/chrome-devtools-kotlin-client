package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * Cookie parameter object
 */
data class CookieParam(
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("value")
  val `value`: String,
  @field:JsonProperty("url")
  @param:Optional
  val url: String? = null,
  @field:JsonProperty("domain")
  @param:Optional
  val domain: String? = null,
  @field:JsonProperty("path")
  @param:Optional
  val path: String? = null,
  @field:JsonProperty("secure")
  @param:Optional
  val secure: Boolean? = null,
  @field:JsonProperty("httpOnly")
  @param:Optional
  val httpOnly: Boolean? = null,
  @field:JsonProperty("sameSite")
  @param:Optional
  val sameSite: CookieSameSite? = null,
  @field:JsonProperty("expires")
  @param:Optional
  val expires: Double? = null,
  @field:JsonProperty("priority")
  @param:Optional
  @param:Experimental
  val priority: CookiePriority? = null,
  @field:JsonProperty("sameParty")
  @param:Optional
  @param:Experimental
  val sameParty: Boolean? = null,
  @field:JsonProperty("sourceScheme")
  @param:Optional
  @param:Experimental
  val sourceScheme: CookieSourceScheme? = null,
  @field:JsonProperty("sourcePort")
  @param:Optional
  @param:Experimental
  val sourcePort: Int? = null,
)
