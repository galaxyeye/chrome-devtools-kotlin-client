@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int
import kotlin.String

/**
 * Navigation history entry.
 */
@Serializable
data class NavigationEntry(
  @SerialName("id")
  val id: Int,
  @SerialName("url")
  val url: String,
  @SerialName("userTypedURL")
  val userTypedURL: String,
  @SerialName("title")
  val title: String,
  @SerialName("transitionType")
  val transitionType: TransitionType,
)
