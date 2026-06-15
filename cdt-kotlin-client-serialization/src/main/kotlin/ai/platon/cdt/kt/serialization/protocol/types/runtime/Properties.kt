@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.collections.List

@Serializable
data class Properties(
  @SerialName("result")
  val result: List<PropertyDescriptor>,
  @SerialName("internalProperties")
  @param:Optional
  val internalProperties: List<InternalPropertyDescriptor>? = null,
  @SerialName("privateProperties")
  @param:Optional
  @param:Experimental
  val privateProperties: List<PrivatePropertyDescriptor>? = null,
  @SerialName("exceptionDetails")
  @param:Optional
  val exceptionDetails: ExceptionDetails? = null,
)
