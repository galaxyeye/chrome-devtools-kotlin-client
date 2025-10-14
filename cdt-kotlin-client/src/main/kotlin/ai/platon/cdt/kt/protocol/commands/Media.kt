package ai.platon.cdt.kt.protocol.commands

import ai.platon.cdt.kt.protocol.events.media.PlayerErrorsRaised
import ai.platon.cdt.kt.protocol.events.media.PlayerEventsAdded
import ai.platon.cdt.kt.protocol.events.media.PlayerMessagesLogged
import ai.platon.cdt.kt.protocol.events.media.PlayerPropertiesChanged
import ai.platon.cdt.kt.protocol.events.media.PlayersCreated
import ai.platon.cdt.kt.protocol.support.annotations.EventName
import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.types.EventHandler
import ai.platon.cdt.kt.protocol.support.types.EventListener

/**
 * This domain allows detailed inspection of media elements
 */
@Experimental
public interface Media {
  /**
   * Enables the Media domain
   */
  public suspend fun enable()

  /**
   * Disables the Media domain.
   */
  public suspend fun disable()

  @EventName("playerPropertiesChanged")
  public fun onPlayerPropertiesChanged(eventListener: EventHandler<PlayerPropertiesChanged>):
      EventListener

  @EventName("playerEventsAdded")
  public fun onPlayerEventsAdded(eventListener: EventHandler<PlayerEventsAdded>): EventListener

  @EventName("playerMessagesLogged")
  public fun onPlayerMessagesLogged(eventListener: EventHandler<PlayerMessagesLogged>):
      EventListener

  @EventName("playerErrorsRaised")
  public fun onPlayerErrorsRaised(eventListener: EventHandler<PlayerErrorsRaised>): EventListener

  @EventName("playersCreated")
  public fun onPlayersCreated(eventListener: EventHandler<PlayersCreated>): EventListener
}
