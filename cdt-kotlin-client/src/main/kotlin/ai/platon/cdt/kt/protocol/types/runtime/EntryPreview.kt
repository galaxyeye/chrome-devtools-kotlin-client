package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty

@Experimental
data class EntryPreview(
  @field:JsonProperty("key")
  @param:Optional
  val key: ObjectPreview? = null,
  @field:JsonProperty("value")
  val `value`: ObjectPreview,
)
