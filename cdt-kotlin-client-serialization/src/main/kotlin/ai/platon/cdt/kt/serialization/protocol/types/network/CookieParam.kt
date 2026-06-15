@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * Cookie parameter object
 */
@Serializable
data class CookieParam(
  @SerialName("name")
  val name: String,
  @SerialName("value")
  val `value`: String,
  @SerialName("url")
  @param:Optional
  val url: String? = null,
  @SerialName("domain")
  @param:Optional
  val domain: String? = null,
  @SerialName("path")
  @param:Optional
  val path: String? = null,
  @SerialName("secure")
  @param:Optional
  val secure: Boolean? = null,
  @SerialName("httpOnly")
  @param:Optional
  val httpOnly: Boolean? = null,
  @SerialName("sameSite")
  @param:Optional
  val sameSite: CookieSameSite? = null,
  @SerialName("expires")
  @param:Optional
  val expires: Double? = null,
  @SerialName("priority")
  @param:Optional
  @param:Experimental
  val priority: CookiePriority? = null,
  @SerialName("sameParty")
  @param:Optional
  @param:Experimental
  val sameParty: Boolean? = null,
  @SerialName("sourceScheme")
  @param:Optional
  @param:Experimental
  val sourceScheme: CookieSourceScheme? = null,
  @SerialName("sourcePort")
  @param:Optional
  @param:Experimental
  val sourcePort: Int? = null,
)
