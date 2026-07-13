@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * Representation of a custom property registration through CSS.registerProperty
 */
data class CSSPropertyRegistration(
  @param:JsonProperty("propertyName")
  val propertyName: String,
  @param:JsonProperty("initialValue")
  @param:Optional
  val initialValue: Value? = null,
  @param:JsonProperty("inherits")
  val inherits: Boolean,
  @param:JsonProperty("syntax")
  val syntax: String,
)
