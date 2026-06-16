@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.input

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TouchPoint(
  @property:SerialName("x")
  val x: Double,
  @property:SerialName("y")
  val y: Double,
  @property:SerialName("radiusX")
  @param:Optional
  val radiusX: Double? = null,
  @property:SerialName("radiusY")
  @param:Optional
  val radiusY: Double? = null,
  @property:SerialName("rotationAngle")
  @param:Optional
  val rotationAngle: Double? = null,
  @property:SerialName("force")
  @param:Optional
  val force: Double? = null,
  @property:SerialName("tangentialPressure")
  @param:Optional
  @param:Experimental
  val tangentialPressure: Double? = null,
  @property:SerialName("tiltX")
  @param:Optional
  @param:Experimental
  val tiltX: Int? = null,
  @property:SerialName("tiltY")
  @param:Optional
  @param:Experimental
  val tiltY: Int? = null,
  @property:SerialName("twist")
  @param:Optional
  @param:Experimental
  val twist: Int? = null,
  @property:SerialName("id")
  @param:Optional
  val id: Double? = null,
)
