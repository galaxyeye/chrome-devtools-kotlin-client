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
public data class Cookie(
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("value")
  public val `value`: String,
  @field:JsonProperty("domain")
  public val domain: String,
  @field:JsonProperty("path")
  public val path: String,
  @field:JsonProperty("expires")
  public val expires: Double,
  @field:JsonProperty("size")
  public val size: Int,
  @field:JsonProperty("httpOnly")
  public val httpOnly: Boolean,
  @field:JsonProperty("secure")
  public val secure: Boolean,
  @field:JsonProperty("session")
  public val session: Boolean,
  @field:JsonProperty("sameSite")
  @param:Optional
  public val sameSite: CookieSameSite? = null,
  @field:JsonProperty("priority")
  @param:Experimental
  public val priority: CookiePriority,
  @field:JsonProperty("sameParty")
  @param:Experimental
  public val sameParty: Boolean,
  @field:JsonProperty("sourceScheme")
  @param:Experimental
  public val sourceScheme: CookieSourceScheme,
  @field:JsonProperty("sourcePort")
  @param:Experimental
  public val sourcePort: Int,
)
