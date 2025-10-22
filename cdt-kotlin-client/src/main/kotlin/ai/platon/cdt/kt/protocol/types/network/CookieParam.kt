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
public data class CookieParam(
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("value")
  public val `value`: String,
  @field:JsonProperty("url")
  @param:Optional
  public val url: String? = null,
  @field:JsonProperty("domain")
  @param:Optional
  public val domain: String? = null,
  @field:JsonProperty("path")
  @param:Optional
  public val path: String? = null,
  @field:JsonProperty("secure")
  @param:Optional
  public val secure: Boolean? = null,
  @field:JsonProperty("httpOnly")
  @param:Optional
  public val httpOnly: Boolean? = null,
  @field:JsonProperty("sameSite")
  @param:Optional
  public val sameSite: CookieSameSite? = null,
  @field:JsonProperty("expires")
  @param:Optional
  public val expires: Double? = null,
  @field:JsonProperty("priority")
  @param:Optional
  @param:Experimental
  public val priority: CookiePriority? = null,
  @field:JsonProperty("sameParty")
  @param:Optional
  @param:Experimental
  public val sameParty: Boolean? = null,
  @field:JsonProperty("sourceScheme")
  @param:Optional
  @param:Experimental
  public val sourceScheme: CookieSourceScheme? = null,
  @field:JsonProperty("sourcePort")
  @param:Optional
  @param:Experimental
  public val sourcePort: Int? = null,
)
