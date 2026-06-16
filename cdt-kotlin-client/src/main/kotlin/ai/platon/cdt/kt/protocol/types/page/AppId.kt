@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

data class AppId(
  @param:JsonProperty("appId")
  @param:Optional
  val appId: String? = null,
  @param:JsonProperty("recommendedId")
  @param:Optional
  val recommendedId: String? = null,
)
