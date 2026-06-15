@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlin.collections.List

/**
 * The installability error
 */
@Experimental
@Serializable
data class InstallabilityError(
  @SerialName("errorId")
  val errorId: String,
  @SerialName("errorArguments")
  val errorArguments: List<InstallabilityErrorArgument>,
)
