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
 * Cookie parameter object
 */
@Serializable
data class CookieParam(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("value")
  val `value`: String,
  @property:SerialName("url")
  @param:Optional
  val url: String? = null,
  @property:SerialName("domain")
  @param:Optional
  val domain: String? = null,
  @property:SerialName("path")
  @param:Optional
  val path: String? = null,
  @property:SerialName("secure")
  @param:Optional
  val secure: Boolean? = null,
  @property:SerialName("httpOnly")
  @param:Optional
  val httpOnly: Boolean? = null,
  @property:SerialName("sameSite")
  @param:Optional
  val sameSite: CookieSameSite? = null,
  @property:SerialName("expires")
  @param:Optional
  val expires: Double? = null,
  @property:SerialName("priority")
  @param:Optional
  @param:Experimental
  val priority: CookiePriority? = null,
  @property:SerialName("sourceScheme")
  @param:Optional
  @param:Experimental
  val sourceScheme: CookieSourceScheme? = null,
  @property:SerialName("sourcePort")
  @param:Optional
  @param:Experimental
  val sourcePort: Int? = null,
  @property:SerialName("partitionKey")
  @param:Optional
  @param:Experimental
  val partitionKey: CookiePartitionKey? = null,
)
