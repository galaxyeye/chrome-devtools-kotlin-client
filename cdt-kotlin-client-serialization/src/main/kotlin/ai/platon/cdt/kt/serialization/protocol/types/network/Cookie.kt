@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Cookie object
 */
@Serializable
data class Cookie(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("value")
  val `value`: String,
  @property:SerialName("domain")
  val domain: String,
  @property:SerialName("path")
  val path: String,
  @property:SerialName("expires")
  val expires: Double,
  @property:SerialName("size")
  val size: Int,
  @property:SerialName("httpOnly")
  val httpOnly: Boolean,
  @property:SerialName("secure")
  val secure: Boolean,
  @property:SerialName("session")
  val session: Boolean,
  @property:SerialName("sameSite")
  @param:Optional
  val sameSite: CookieSameSite? = null,
  @property:SerialName("priority")
  @param:Experimental
  val priority: CookiePriority,
  @property:SerialName("sameParty")
  @param:Experimental
  val sameParty: Boolean,
  @property:SerialName("sourceScheme")
  @param:Experimental
  val sourceScheme: CookieSourceScheme,
  @property:SerialName("sourcePort")
  @param:Experimental
  val sourcePort: Int,
)
