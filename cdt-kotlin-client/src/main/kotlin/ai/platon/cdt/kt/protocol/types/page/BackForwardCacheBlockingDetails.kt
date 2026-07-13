@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

@Experimental
data class BackForwardCacheBlockingDetails(
  @param:JsonProperty("url")
  @param:Optional
  val url: String? = null,
  @param:JsonProperty("function")
  @param:Optional
  val function: String? = null,
  @param:JsonProperty("lineNumber")
  val lineNumber: Int,
  @param:JsonProperty("columnNumber")
  val columnNumber: Int,
)
