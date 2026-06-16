@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

@Experimental
data class RelatedApplication(
  @param:JsonProperty("id")
  @param:Optional
  val id: String? = null,
  @param:JsonProperty("url")
  val url: String,
)
