package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.String

/**
 * Represents function call argument. Either remote object id `objectId`, primitive `value`,
 * unserializable primitive value or neither of (for undefined) them should be specified.
 */
public data class CallArgument(
  @field:JsonProperty("value")
  @param:Optional
  public val `value`: Any? = null,
  @field:JsonProperty("unserializableValue")
  @param:Optional
  public val unserializableValue: String? = null,
  @field:JsonProperty("objectId")
  @param:Optional
  public val objectId: String? = null,
)
