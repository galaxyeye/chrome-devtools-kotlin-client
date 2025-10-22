package ai.platon.cdt.kt.protocol.types.browser

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * Definition of PermissionDescriptor defined in the Permissions API:
 * https://w3c.github.io/permissions/#dictdef-permissiondescriptor.
 */
@Experimental
public data class PermissionDescriptor(
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("sysex")
  @param:Optional
  public val sysex: Boolean? = null,
  @field:JsonProperty("userVisibleOnly")
  @param:Optional
  public val userVisibleOnly: Boolean? = null,
  @field:JsonProperty("allowWithoutSanitization")
  @param:Optional
  public val allowWithoutSanitization: Boolean? = null,
  @field:JsonProperty("panTiltZoom")
  @param:Optional
  public val panTiltZoom: Boolean? = null,
)
