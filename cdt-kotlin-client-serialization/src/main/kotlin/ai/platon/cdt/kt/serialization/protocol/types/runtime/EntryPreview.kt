@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional

@Experimental
@Serializable
data class EntryPreview(
  @SerialName("key")
  @param:Optional
  val key: ObjectPreview? = null,
  @SerialName("value")
  val `value`: ObjectPreview,
)
