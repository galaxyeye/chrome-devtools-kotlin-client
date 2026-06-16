@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A device bound session's cookie craving.
 */
@Serializable
@Experimental
data class DeviceBoundSessionCookieCraving(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("domain")
  val domain: String,
  @property:SerialName("path")
  val path: String,
  @property:SerialName("secure")
  val secure: Boolean,
  @property:SerialName("httpOnly")
  val httpOnly: Boolean,
  @property:SerialName("sameSite")
  @param:Optional
  val sameSite: CookieSameSite? = null,
)
