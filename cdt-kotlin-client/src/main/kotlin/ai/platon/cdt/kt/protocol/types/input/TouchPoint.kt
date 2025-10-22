package ai.platon.cdt.kt.protocol.types.input

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int

data class TouchPoint(
  @field:JsonProperty("x")
  val x: Double,
  @field:JsonProperty("y")
  val y: Double,
  @field:JsonProperty("radiusX")
  @param:Optional
  val radiusX: Double? = null,
  @field:JsonProperty("radiusY")
  @param:Optional
  val radiusY: Double? = null,
  @field:JsonProperty("rotationAngle")
  @param:Optional
  val rotationAngle: Double? = null,
  @field:JsonProperty("force")
  @param:Optional
  val force: Double? = null,
  @field:JsonProperty("tangentialPressure")
  @param:Optional
  @param:Experimental
  val tangentialPressure: Double? = null,
  @field:JsonProperty("tiltX")
  @param:Optional
  @param:Experimental
  val tiltX: Int? = null,
  @field:JsonProperty("tiltY")
  @param:Optional
  @param:Experimental
  val tiltY: Int? = null,
  @field:JsonProperty("twist")
  @param:Optional
  @param:Experimental
  val twist: Int? = null,
  @field:JsonProperty("id")
  @param:Optional
  val id: Double? = null,
)
