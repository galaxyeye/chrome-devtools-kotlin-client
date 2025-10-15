# Chrome DevTools Kotlin Client

## Description

Chrome DevTools Kotlin Client is a DevTools client - in Kotlin. It can be used for instrumenting, inspecting, debuging and profiling Chromium, Chrome and other Blink-based browsers. [1]

For more information on DevTools, see https://chromedevtools.github.io/devtools-protocol/.

## Usage

> **Note**: This API retains full compatibility with the original chrome-devtools-java-client, but all methods are defined as suspend functions, making them non-blocking.

```kotlin

suspend fun main() {
    // Create chrome launcher.
    val launcher = ChromeLauncher()

    // Launch chrome either as headless (true) or regular (false).
    val chromeService = launcher.launch(false)

    // Create empty tab ie about:blank.
    val tab = chromeService.createTab()

    // Get DevTools service to this tab
    val devToolsService = chromeService.createDevToolsService(tab)

    // Get individual commands
    val page = devToolsService.page
    val tracing = devToolsService.tracing

    val dataCollectedList = mutableListOf<Any>()

    // Add tracing data to dataCollectedList
    tracing.onDataCollected { event: DataCollected ->
        dataCollectedList.addAll(event.value)
    }

    // When tracing is complete, dump dataCollectedList to JSON file.
    tracing.onTracingComplete {
        // Dump tracing to file.
        val path = Paths.get("/tmp/tracing.json")
        println("Tracing completed! Dumping to $path")

        val om = ObjectMapper()
        om.writeValue(path.toFile(), dataCollectedList)

        devToolsService.close()
    }

    page.onLoadEventFired { tracing.end() }

    page.enable()
    tracing.start()
    page.navigate("https://github.com")
}

```

- [Examples](cdt-kotlin-client/src/test/kotlin/ai/platon/pulsar/browser/driver/examples)

## Running unit tests

`make verify`

## Sonar analysis

`make sonar-analysis`

## Download latest protocol

Run following:
```
make download-latest-protocol
```

This will download `browser_protocol.json` and `js_protocol.json` (protocol definitions) from https://github.com/ChromeDevTools/devtools-protocol repo.

## Update protocol (generate Kotlin files from protocol definitions)

Make sure you have correct or latest protocol definitions. See [Download latest protocol](#download-latest-protocol) on how to update protocol definitions to latest version.

Run following:
```
make update-protocol
```

This will build the tools for parsing and generating Kotlin files, [cdt-kotlin-protocol-builder](cdt-kotlin-protocol-builder/) project. The input for this tool are protocol definitions files: `browser_protocol.json` and `js_protocol.json`. The generated Kotlin files will be present in [cdt-kotlin-client](cdt-kotlin-client/) project. After building Kotlin files, the [cdt-kotlin-client](cdt-kotlin-client/) will be compiled. If everything goes successfully, consider the protocol updated. :)

## Updating copyright license header

To go over each module and each source java file to update copyright license header, run:

```
make update-copyright-license-header
```

## License

Chrome DevTools Kotlin Client is licensed under the Apache License, Version 2.0. See [LICENSE](LICENSE.txt) for the full license text.
