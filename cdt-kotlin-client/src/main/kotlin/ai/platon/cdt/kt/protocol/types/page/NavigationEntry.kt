package ai.platon.cdt.kt.protocol.types.page

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Navigation history entry.
 */
data class NavigationEntry(
  @field:JsonProperty("id")
  val id: Int,
  @field:JsonProperty("url")
  val url: String,
  @field:JsonProperty("userTypedURL")
  val userTypedURL: String,
  @field:JsonProperty("title")
  val title: String,
  @field:JsonProperty("transitionType")
  val transitionType: TransitionType,
)
