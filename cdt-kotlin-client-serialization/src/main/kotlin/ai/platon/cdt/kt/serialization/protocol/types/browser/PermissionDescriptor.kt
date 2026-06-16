@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.browser

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Definition of PermissionDescriptor defined in the Permissions API:
 * https://w3c.github.io/permissions/#dom-permissiondescriptor.
 */
@Serializable
@Experimental
data class PermissionDescriptor(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("sysex")
  @param:Optional
  val sysex: Boolean? = null,
  @property:SerialName("userVisibleOnly")
  @param:Optional
  val userVisibleOnly: Boolean? = null,
  @property:SerialName("allowWithoutSanitization")
  @param:Optional
  val allowWithoutSanitization: Boolean? = null,
  @property:SerialName("allowWithoutGesture")
  @param:Optional
  val allowWithoutGesture: Boolean? = null,
  @property:SerialName("panTiltZoom")
  @param:Optional
  val panTiltZoom: Boolean? = null,
)
