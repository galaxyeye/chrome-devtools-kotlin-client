@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.browser
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String

/**
 * Definition of PermissionDescriptor defined in the Permissions API:
 * https://w3c.github.io/permissions/#dictdef-permissiondescriptor.
 */
@Experimental
@Serializable
data class PermissionDescriptor(
  @SerialName("name")
  val name: String,
  @SerialName("sysex")
  @param:Optional
  val sysex: Boolean? = null,
  @SerialName("userVisibleOnly")
  @param:Optional
  val userVisibleOnly: Boolean? = null,
  @SerialName("allowWithoutSanitization")
  @param:Optional
  val allowWithoutSanitization: Boolean? = null,
  @SerialName("panTiltZoom")
  @param:Optional
  val panTiltZoom: Boolean? = null,
)
