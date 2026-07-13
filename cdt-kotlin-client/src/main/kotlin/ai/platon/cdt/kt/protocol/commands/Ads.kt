@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.commands

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Returns
import ai.platon.cdt.kt.protocol.types.ads.AdMetrics

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
