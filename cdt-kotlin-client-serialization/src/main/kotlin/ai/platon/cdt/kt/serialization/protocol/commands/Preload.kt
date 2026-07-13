@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.commands

import ai.platon.cdt.kt.serialization.protocol.events.preload.PrefetchStatusUpdated
import ai.platon.cdt.kt.serialization.protocol.events.preload.PreloadEnabledStateUpdated
import ai.platon.cdt.kt.serialization.protocol.events.preload.PreloadingAttemptSourcesUpdated
import ai.platon.cdt.kt.serialization.protocol.events.preload.PrerenderStatusUpdated
import ai.platon.cdt.kt.serialization.protocol.events.preload.RuleSetRemoved
import ai.platon.cdt.kt.serialization.protocol.events.preload.RuleSetUpdated
import ai.platon.cdt.kt.serialization.protocol.support.annotations.EventName
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.types.EventHandler
import ai.platon.cdt.kt.serialization.protocol.support.types.EventListener
import kotlin.Unit

@Experimental
interface Preload {
  suspend fun enable()

  suspend fun disable()

  @EventName("ruleSetUpdated")
  fun onRuleSetUpdated(eventListener: EventHandler<RuleSetUpdated>): EventListener

  @EventName("ruleSetUpdated")
  fun onRuleSetUpdated(eventListener: suspend (RuleSetUpdated) -> Unit): EventListener

  @EventName("ruleSetRemoved")
  fun onRuleSetRemoved(eventListener: EventHandler<RuleSetRemoved>): EventListener

  @EventName("ruleSetRemoved")
  fun onRuleSetRemoved(eventListener: suspend (RuleSetRemoved) -> Unit): EventListener

  @EventName("preloadEnabledStateUpdated")
  fun onPreloadEnabledStateUpdated(eventListener: EventHandler<PreloadEnabledStateUpdated>): EventListener

  @EventName("preloadEnabledStateUpdated")
  fun onPreloadEnabledStateUpdated(eventListener: suspend (PreloadEnabledStateUpdated) -> Unit): EventListener

  @EventName("prefetchStatusUpdated")
  fun onPrefetchStatusUpdated(eventListener: EventHandler<PrefetchStatusUpdated>): EventListener

  @EventName("prefetchStatusUpdated")
  fun onPrefetchStatusUpdated(eventListener: suspend (PrefetchStatusUpdated) -> Unit): EventListener

  @EventName("prerenderStatusUpdated")
  fun onPrerenderStatusUpdated(eventListener: EventHandler<PrerenderStatusUpdated>): EventListener

  @EventName("prerenderStatusUpdated")
  fun onPrerenderStatusUpdated(eventListener: suspend (PrerenderStatusUpdated) -> Unit): EventListener

  @EventName("preloadingAttemptSourcesUpdated")
  fun onPreloadingAttemptSourcesUpdated(eventListener: EventHandler<PreloadingAttemptSourcesUpdated>): EventListener

  @EventName("preloadingAttemptSourcesUpdated")
  fun onPreloadingAttemptSourcesUpdated(eventListener: suspend (PreloadingAttemptSourcesUpdated) -> Unit): EventListener
}
