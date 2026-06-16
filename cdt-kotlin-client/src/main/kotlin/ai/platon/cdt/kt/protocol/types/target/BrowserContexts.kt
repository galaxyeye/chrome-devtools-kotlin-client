@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.target

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

data class BrowserContexts(
  @param:JsonProperty("browserContextIds")
  val browserContextIds: List<String>,
  @param:JsonProperty("defaultBrowserContextId")
  @param:Optional
  @param:Experimental
  val defaultBrowserContextId: String? = null,
)
