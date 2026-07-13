@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Properties(
  @property:SerialName("result")
  val result: List<PropertyDescriptor>,
  @property:SerialName("internalProperties")
  @param:Optional
  val internalProperties: List<InternalPropertyDescriptor>? = null,
  @property:SerialName("privateProperties")
  @param:Optional
  @param:Experimental
  val privateProperties: List<PrivatePropertyDescriptor>? = null,
  @property:SerialName("exceptionDetails")
  @param:Optional
  val exceptionDetails: ExceptionDetails? = null,
)
