# Chrome DevTools Kotlin Client

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](LICENSE.txt)

A Kotlin client library for the [Chrome DevTools Protocol](https://chromedevtools.github.io/devtools-protocol/) (CDP). Use it to instrument, inspect, debug, and profile Chromium, Chrome, and other Blink-based browsers — programmatically, from Kotlin.

All remote methods are Kotlin `suspend` functions, so the API is naturally non-blocking and integrates cleanly with coroutine-based applications.

## Features

- **Full CDP coverage** — auto-generated, type-safe bindings for every domain, command, event, and type in the DevTools Protocol
- **Suspend-first API** — all remote calls are `suspend` functions; no blocking I/O
- **Dual serialization** — choose Jackson or kotlinx.serialization for wire-format encoding
- **Ktor transport** — WebSocket-based communication via Ktor (CIO engine)
- **Browser lifecycle** — launch, manage, and terminate Chrome/Chromium processes
- **Coroutine-friendly events** — subscribe to CDP events with Kotlin lambdas

## Installation

### Gradle

```kotlin
// Jackson variant
implementation("ai.platon.cdt:cdt-kotlin-client:4.8.2-SNAPSHOT")
implementation("ai.platon.cdt:cdt-kotlin-client-ktor:4.8.2-SNAPSHOT")

// or kotlinx.serialization variant
implementation("ai.platon.cdt:cdt-kotlin-client-serialization:4.8.2-SNAPSHOT")
implementation("ai.platon.cdt:cdt-kotlin-client-ktor-serialization:4.8.2-SNAPSHOT")
```

### Maven

```xml
<!-- Jackson variant -->
<dependency>
  <groupId>ai.platon.cdt</groupId>
  <artifactId>cdt-kotlin-client</artifactId>
  <version>4.8.2-SNAPSHOT</version>
</dependency>
<dependency>
  <groupId>ai.platon.cdt</groupId>
  <artifactId>cdt-kotlin-client-ktor</artifactId>
  <version>4.8.2-SNAPSHOT</version>
</dependency>
```

## Quick start

```kotlin
suspend fun main() {
    // Launch Chrome
    val launcher = ChromeLauncher()
    val chromeService = launcher.launch(headless = false)

    // Open a tab and attach DevTools
    val tab = chromeService.createTab()
    val devTools = chromeService.createDevToolsService(tab)

    // Access CDP domains
    val page = devTools.page
    val tracing = devTools.tracing

    val dataCollected = mutableListOf<Any>()

    tracing.onDataCollected { event ->
        dataCollected.addAll(event.value)
    }

    tracing.onTracingComplete {
        val path = Paths.get("/tmp/tracing.json")
        println("Tracing complete! Dumping to $path")
        ObjectMapper().writeValue(path.toFile(), dataCollected)
        devTools.close()
    }

    page.onLoadEventFired { tracing.end() }

    page.enable()
    tracing.start()
    page.navigate("https://github.com")
}
```

More examples are in the test sources:
- [Jackson transport examples](cdt-kotlin-client-ktor/src/test/kotlin/ai/platon/pulsar/browser/driver/examples)
- [kotlinx.serialization transport examples](cdt-kotlin-client-ktor-serialization/src/test/kotlin/ai/platon/pulsar/browser/driver/examples)

## Modules

| Module | Artifact | Description |
|--------|----------|-------------|
| [cdt-protocol-parser](cdt-protocol-parser/) | `cdt-protocol-parser` | Parses CDP JSON definitions into an in-memory object model (Java) |
| [cdt-kotlin-protocol-builder](cdt-kotlin-protocol-builder/) | `cdt-kotlin-protocol-builder` | Code generator — produces Kotlin sources from the parsed protocol |
| [cdt-kotlin-client](cdt-kotlin-client/) | `cdt-kotlin-client` | Generated protocol bindings with **Jackson** annotations |
| [cdt-kotlin-client-serialization](cdt-kotlin-client-serialization/) | `cdt-kotlin-client-serialization` | Generated protocol bindings with **kotlinx.serialization** annotations |
| [cdt-kotlin-client-ktor](cdt-kotlin-client-ktor/) | `cdt-kotlin-client-ktor` | Ktor transport + browser launcher (Jackson) |
| [cdt-kotlin-client-ktor-serialization](cdt-kotlin-client-ktor-serialization/) | `cdt-kotlin-client-ktor-serialization` | Ktor transport + browser launcher (kotlinx.serialization) |

### Choosing a serialization variant

| | Jackson | kotlinx.serialization |
|---|---|---|
| **Protocol module** | `cdt-kotlin-client` | `cdt-kotlin-client-serialization` |
| **Transport module** | `cdt-kotlin-client-ktor` | `cdt-kotlin-client-ktor-serialization` |
| **Zero Jackson/Gson deps** | No | Yes |
| **Best for** | Projects already using Jackson | Kotlin-first / Ktor projects |

## Architecture

```
browser_protocol.json  ──►  cdt-protocol-parser  ──►  cdt-kotlin-protocol-builder
   js_protocol.json          (parse JSON → model)        (model → Kotlin sources)
                                                              │
                                          ┌───────────────────┤
                                          ▼                   ▼
                                  cdt-kotlin-client    cdt-kotlin-client-serialization
                                  (@JsonProperty)      (@Serializable)
                                          │                   │
                                          ▼                   ▼
                                cdt-kotlin-client-ktor  cdt-kotlin-client-ktor-serialization
                                (launcher + transport)  (launcher + transport)
```

1. **Protocol JSON** files are downloaded from [ChromeDevTools/devtools-protocol](https://github.com/ChromeDevTools/devtools-protocol)
2. **`cdt-protocol-parser`** deserializes them into a typed Java object model
3. **`cdt-kotlin-protocol-builder`** uses [KotlinPoet](https://github.com/square/kotlinpoet) to generate Kotlin data classes, command interfaces, and event types
4. **Client modules** contain the generated code — pick Jackson or kotlinx.serialization
5. **Transport modules** provide the runtime: `ChromeLauncher`, WebSocket transport via Ktor, event dispatching, and a reflective invocation layer that bridges generated command interfaces to the CDP wire protocol

## Updating the protocol

The project ships with pre-generated sources, but you can regenerate them when a new version of the DevTools Protocol is released.

### 1. Download the latest protocol definitions

```bash
make download-latest-protocol
```

This fetches `browser_protocol.json` and `js_protocol.json` from the [devtools-protocol](https://github.com/ChromeDevTools/devtools-protocol) repository.

### 2. Regenerate the Kotlin sources

**Jackson variant:**

```bash
make update-protocol
```

**kotlinx.serialization variant:**

```bash
make update-protocol-serialization
```

### PowerShell (Windows)

```powershell
# Jackson
.\bin\generate-kotlin.ps1

# kotlinx.serialization
.\bin\generate-kotlin.ps1 -Serialization

# Skip rebuilding the builder JAR (useful for iteration)
.\bin\generate-kotlin.ps1 -Serialization -SkipBuild

# Custom output directory
.\bin\generate-kotlin.ps1 -Serialization -OutputProject "my-client"
```

## Build & test

```bash
# Run all unit tests
make verify

# Build all modules (skip GPG signing)
./mvnw clean package -Dgpg.skip=true

# Run Sonar analysis
make sonar-analysis
```

## License

Apache License, Version 2.0 — see [LICENSE.txt](LICENSE.txt).

---

[1] Originally derived from [chrome-devtools-java-client](https://github.com/kklisura/chrome-devtools-java-client) by Kenan Klisura.
