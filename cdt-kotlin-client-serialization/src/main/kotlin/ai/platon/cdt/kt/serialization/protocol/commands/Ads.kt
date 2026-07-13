@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.commands

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Returns
import ai.platon.cdt.kt.serialization.protocol.types.ads.AdMetrics

/**
 * A domain for ad-related metrics and data.
 */
@Experimental
interface Ads {
  /**
   * Retrieves ad metrics for the current page.
   */
  @Returns("metrics")
  suspend fun getAdMetrics(): AdMetrics
}
