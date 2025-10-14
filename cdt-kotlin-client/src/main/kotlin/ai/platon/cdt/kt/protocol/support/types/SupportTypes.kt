package ai.platon.cdt.kt.protocol.support.types

public fun interface EventHandler<T> {
  public fun handle(event: T)
}

public interface EventListener
