@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Navigation history entry.
 */
@Serializable
data class NavigationEntry(
  @property:SerialName("id")
  val id: Int,
  @property:SerialName("url")
  val url: String,
  @property:SerialName("userTypedURL")
  val userTypedURL: String,
  @property:SerialName("title")
  val title: String,
  @property:SerialName("transitionType")
  val transitionType: TransitionType,
)
