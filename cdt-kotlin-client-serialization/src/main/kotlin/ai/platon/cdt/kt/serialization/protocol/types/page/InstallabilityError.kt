@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The installability error
 */
@Serializable
@Experimental
data class InstallabilityError(
  @property:SerialName("errorId")
  val errorId: String,
  @property:SerialName("errorArguments")
  val errorArguments: List<InstallabilityErrorArgument>,
)
