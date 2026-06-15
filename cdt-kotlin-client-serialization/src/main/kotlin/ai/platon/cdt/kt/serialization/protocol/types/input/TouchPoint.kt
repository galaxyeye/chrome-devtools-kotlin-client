@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.input
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.Int

@Serializable
data class TouchPoint(
  @SerialName("x")
  val x: Double,
  @SerialName("y")
  val y: Double,
  @SerialName("radiusX")
  @param:Optional
  val radiusX: Double? = null,
  @SerialName("radiusY")
  @param:Optional
  val radiusY: Double? = null,
  @SerialName("rotationAngle")
  @param:Optional
  val rotationAngle: Double? = null,
  @SerialName("force")
  @param:Optional
  val force: Double? = null,
  @SerialName("tangentialPressure")
  @param:Optional
  @param:Experimental
  val tangentialPressure: Double? = null,
  @SerialName("tiltX")
  @param:Optional
  @param:Experimental
  val tiltX: Int? = null,
  @SerialName("tiltY")
  @param:Optional
  @param:Experimental
  val tiltY: Int? = null,
  @SerialName("twist")
  @param:Optional
  @param:Experimental
  val twist: Int? = null,
  @SerialName("id")
  @param:Optional
  val id: Double? = null,
)
