@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class EntryPreview(
  @property:SerialName("key")
  @param:Optional
  val key: ObjectPreview? = null,
  @property:SerialName("value")
  val `value`: ObjectPreview,
)
