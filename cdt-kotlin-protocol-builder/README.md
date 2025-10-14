# Chrome DevTools Kotlin Protocol Builder

## Description

Chrome DevTools Kotlin Protocol Builder parses DevTools `protocol.json` - a protocol definition file and outputs the Kotlin classes and interfaces.
 
## Building

To build jar file either run:

`make build` or `mvn clean package`

## Running

```
java -jar target/cdt-kotlin-protocol-builder.jar --base-package="ai.platon.cdt.protocol" \
  --output=../cdt-kotlin-client \
  --protocol=../protocol.json
```

This would parse `./protocol.json` file and it would create classes, interfaces, enums in `../cdt-kotlin-client` with a package name of `ai.platon.cdt.protocol`.

## Running unit tests

`make verify`

## Sonar analysis

`make sonar-analysis`

## License

Chrome DevTools Kotlin Protocol Builder is licensed under the Apache License, Version 2.0. See [LICENSE](LICENSE.txt) for the full license text.
