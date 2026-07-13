@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

@Experimental
data class Shortcut(
  @param:JsonProperty("name")
  val name: String,
  @param:JsonProperty("url")
  val url: String,
)
