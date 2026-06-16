@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Representation of a custom property registration through CSS.registerProperty
 */
@Serializable
data class CSSPropertyRegistration(
  @property:SerialName("propertyName")
  val propertyName: String,
  @property:SerialName("initialValue")
  @param:Optional
  val initialValue: Value? = null,
  @property:SerialName("inherits")
  val inherits: Boolean,
  @property:SerialName("syntax")
  val syntax: String,
)
