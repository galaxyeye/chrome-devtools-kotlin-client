package ai.platon.cdt.kt.protocol.commands

import ai.platon.cdt.kt.protocol.events.inspector.Detached
import ai.platon.cdt.kt.protocol.events.inspector.TargetCrashed
import ai.platon.cdt.kt.protocol.events.inspector.TargetReloadedAfterCrash
import ai.platon.cdt.kt.protocol.support.annotations.EventName
import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.types.EventHandler
import ai.platon.cdt.kt.protocol.support.types.EventListener

@Experimental
public interface Inspector {
  /**
   * Disables inspector domain notifications.
   */
  public suspend fun disable()

  /**
   * Enables inspector domain notifications.
   */
  public suspend fun enable()

  @EventName("detached")
  public fun onDetached(eventListener: EventHandler<Detached>): EventListener

  @EventName("targetCrashed")
  public fun onTargetCrashed(eventListener: EventHandler<TargetCrashed>): EventListener

  @EventName("targetReloadedAfterCrash")
  public fun onTargetReloadedAfterCrash(eventListener: EventHandler<TargetReloadedAfterCrash>):
      EventListener
}
