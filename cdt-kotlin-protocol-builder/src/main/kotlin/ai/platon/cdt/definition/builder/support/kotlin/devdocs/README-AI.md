# Kotlin Client Generation Guide

## Main Goal

Chrome DevTools Kotlin Protocol Builder parses DevTools `protocol.json` - a protocol definition file and outputs the kotlin classes and interfaces.

修改Kotlin代码生成相关代码，解决本文中提到的问题。主要代码位于以下目录：
`cdt-kotlin-protocol-builder/src/main/kotlin/ai/platon/cdt/definition/builder/support/kotlin/`

## Known Issues

### Generate property instead of getter

For example:

```kotlin
interface ChromeDevTools {
    val debugger: Debugger
    val page: Page
    // ...
}
```

### Event EventListener Specification

`EventListener` always is the following:

```kotlin
interface EventListener {
    /** Alias to unsubscribe.  */
    fun off()

    /** Unsubscribe this event listener.  */
    fun unsubscribe()
}
```

### Event Handler Enhancement

For each event handler registration, also add a new register method version,
the method takes a function as the parameter: `suspend () -> Y`.

For example:

Original generated method:

```kotlin
  @EventName("loadEventFired")
  public fun onLoadEventFired(eventListener: EventHandler<LoadEventFired>): EventListener
```

Newly added method:

```kotlin
@EventName("loadEventFired")
public fun onLoadEventFired(eventListener: suspend (LoadEventFired) -> Unit): EventListener
```
