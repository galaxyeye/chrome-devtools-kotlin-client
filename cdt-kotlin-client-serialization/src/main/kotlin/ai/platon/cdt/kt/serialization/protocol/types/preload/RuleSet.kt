@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.preload

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Deprecated
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Corresponds to SpeculationRuleSet
 */
@Serializable
data class RuleSet(
  @property:SerialName("id")
  val id: String,
  @property:SerialName("loaderId")
  val loaderId: String,
  @property:SerialName("sourceText")
  val sourceText: String,
  @property:SerialName("backendNodeId")
  @param:Optional
  val backendNodeId: Int? = null,
  @property:SerialName("url")
  @param:Optional
  val url: String? = null,
  @property:SerialName("requestId")
  @param:Optional
  val requestId: String? = null,
  @property:SerialName("errorType")
  @param:Optional
  val errorType: RuleSetErrorType? = null,
  @property:SerialName("errorMessage")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val errorMessage: String? = null,
  @property:SerialName("tag")
  @param:Optional
  val tag: String? = null,
)
