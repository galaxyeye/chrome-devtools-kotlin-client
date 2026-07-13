@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.target

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class TargetInfo(
  @property:SerialName("targetId")
  val targetId: String,
  @property:SerialName("type")
  val type: String,
  @property:SerialName("title")
  val title: String,
  @property:SerialName("url")
  val url: String,
  @property:SerialName("attached")
  val attached: Boolean,
  @property:SerialName("parentId")
  @param:Optional
  val parentId: String? = null,
  @property:SerialName("openerId")
  @param:Optional
  val openerId: String? = null,
  @property:SerialName("canAccessOpener")
  @param:Experimental
  val canAccessOpener: Boolean,
  @property:SerialName("openerFrameId")
  @param:Optional
  @param:Experimental
  val openerFrameId: String? = null,
  @property:SerialName("parentFrameId")
  @param:Optional
  @param:Experimental
  val parentFrameId: String? = null,
  @property:SerialName("browserContextId")
  @param:Optional
  @param:Experimental
  val browserContextId: String? = null,
  @property:SerialName("subtype")
  @param:Optional
  @param:Experimental
  val subtype: String? = null,
  @property:SerialName("embedderData")
  @param:Optional
  @param:Experimental
  val embedderData: JsonObject? = null,
)
