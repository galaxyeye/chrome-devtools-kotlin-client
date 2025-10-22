package ai.platon.cdt.kt.protocol.types.input

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int

public data class TouchPoint(
  @field:JsonProperty("x")
  public val x: Double,
  @field:JsonProperty("y")
  public val y: Double,
  @field:JsonProperty("radiusX")
  @param:Optional
  public val radiusX: Double? = null,
  @field:JsonProperty("radiusY")
  @param:Optional
  public val radiusY: Double? = null,
  @field:JsonProperty("rotationAngle")
  @param:Optional
  public val rotationAngle: Double? = null,
  @field:JsonProperty("force")
  @param:Optional
  public val force: Double? = null,
  @field:JsonProperty("tangentialPressure")
  @param:Optional
  @param:Experimental
  public val tangentialPressure: Double? = null,
  @field:JsonProperty("tiltX")
  @param:Optional
  @param:Experimental
  public val tiltX: Int? = null,
  @field:JsonProperty("tiltY")
  @param:Optional
  @param:Experimental
  public val tiltY: Int? = null,
  @field:JsonProperty("twist")
  @param:Optional
  @param:Experimental
  public val twist: Int? = null,
  @field:JsonProperty("id")
  @param:Optional
  public val id: Double? = null,
)
