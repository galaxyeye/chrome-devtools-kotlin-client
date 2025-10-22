package ai.platon.cdt.kt.protocol.types.page

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Navigation history entry.
 */
public data class NavigationEntry(
  @field:JsonProperty("id")
  public val id: Int,
  @field:JsonProperty("url")
  public val url: String,
  @field:JsonProperty("userTypedURL")
  public val userTypedURL: String,
  @field:JsonProperty("title")
  public val title: String,
  @field:JsonProperty("transitionType")
  public val transitionType: TransitionType,
)
