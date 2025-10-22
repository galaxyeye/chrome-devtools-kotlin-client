package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty

@Experimental
public data class EntryPreview(
  @field:JsonProperty("key")
  @param:Optional
  public val key: ObjectPreview? = null,
  @field:JsonProperty("value")
  public val `value`: ObjectPreview,
)
