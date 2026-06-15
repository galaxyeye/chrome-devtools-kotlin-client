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
 * Cookie object
 */
@Serializable
data class Cookie(
  @SerialName("name")
  val name: String,
  @SerialName("value")
  val `value`: String,
  @SerialName("domain")
  val domain: String,
  @SerialName("path")
  val path: String,
  @SerialName("expires")
  val expires: Double,
  @SerialName("size")
  val size: Int,
  @SerialName("httpOnly")
  val httpOnly: Boolean,
  @SerialName("secure")
  val secure: Boolean,
  @SerialName("session")
  val session: Boolean,
  @SerialName("sameSite")
  @param:Optional
  val sameSite: CookieSameSite? = null,
  @SerialName("priority")
  @param:Experimental
  val priority: CookiePriority,
  @SerialName("sameParty")
  @param:Experimental
  val sameParty: Boolean,
  @SerialName("sourceScheme")
  @param:Experimental
  val sourceScheme: CookieSourceScheme,
  @SerialName("sourcePort")
  @param:Experimental
  val sourcePort: Int,
)
