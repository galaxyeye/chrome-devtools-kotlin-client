# Kotlin CDP Generator Review (Refined)

Purpose
- Generate Kotlin sources from Chrome DevTools Protocol JSON, mirroring the existing Java output: types, events, commands, plus a unified command factory. All command methods must be suspend to support coroutines.

Scope and key points
- Input: browser_protocol.json, js_protocol.json
- Output: Kotlin sources for domains, types, events, and commands, plus a unified factory in `ai.platon.cdt.kt.protocol.ChromeDevTools`
- Generator entry: `cdt-kotlin-protocol-builder/src/main/kotlin/ai/platon/cdt/definition/builder/support/kotlin/KotlinProtocolGenerator.kt`

Requirements

1) Optional parameter defaults
- Rule: For every generated Kotlin function parameter annotated with `@Optional`, add a default value `= null`.
- Type: Such parameters must already be nullable (e.g., `Int?`, `Boolean?`, `String?`, custom type `T?`). If not, make them nullable and default to null.
- Do not add defaults to non-optional parameters.

Before
```kotlin
@Returns("node")
public suspend fun describeNode(
  @ParamName("nodeId") @Optional nodeId: Int?,
  @ParamName("backendNodeId") @Optional backendNodeId: Int?,
  @ParamName("objectId") @Optional objectId: String?,
  @ParamName("depth") @Optional depth: Int?,
  @ParamName("pierce") @Optional pierce: Boolean?,
): Node
```

After
```kotlin
@Returns("node")
public suspend fun describeNode(
  @ParamName("nodeId") @Optional nodeId: Int? = null,
  @ParamName("backendNodeId") @Optional backendNodeId: Int? = null,
  @ParamName("objectId") @Optional objectId: String? = null,
  @ParamName("depth") @Optional depth: Int? = null,
  @ParamName("pierce") @Optional pierce: Boolean? = null,
): Node
```

Edge cases
- Collections: `List<T>? = null`, `Map<K, V>? = null` are valid for optional collections.
- Enums: `MyEnum? = null` when optional.
- Varargs: Don’t generate varargs for protocol parameters; if ever present and optional, prefer `Array<T>? = null`.
- Serialization: Ensure downstream request builders ignore nulls or include them according to the existing Java parity.

Acceptance for (1)
- Every parameter with `@Optional` ends with `= null` and has a nullable type.
- No non-optional parameter receives a default value.
- Generated sources compile and existing tests pass.

2) Naming conventions for acronyms in ChromeDevTools properties
- Context: In `ai.platon.cdt.kt.protocol.ChromeDevTools`, properties expose domain clients (e.g., DOM, Page, Network).
- Rule: Use camelCase for property names with the acronym lowercased as the initial segment. Examples:
  - `val dom: DOM`
  - `val domDebugger: DOMDebugger`
  - `val htmlParser: HTMLParser`
  - `val urlParser: URLParser`
- Don’t: `val dOM: DOM`, `val dOMDebugger: DOMDebugger` (these violate camelCase rules).

Rationale
- Camel case means capitalize the first letter of each subsequent word and keep the first letter lowercase.
- “dOM” is not camelCase because the second letter isn’t supposed to be uppercase.

中文说明（命名）
- 使用驼峰命名：首个单词首字母小写，其后每个单词首字母大写。
- DOM/HTML/URL 等缩写作为属性名的首段时，全部小写：`dom`、`html`、`url`。
- 例如：`domDebugger`、`htmlParser`、`urlParser`。
- 反例：`dOM`、`dOMDebugger`。

Implementation guidance

Generator hotspots
- File: `KotlinProtocolGenerator.kt`
- Tasks:
  1. Parameter defaults: When emitting parameters, if a parameter carries `@Optional`, ensure the type is nullable and append `" = null"` after the type.
  2. Property names: When generating the unified `ChromeDevTools` factory or domain accessors, compute property names via lowercasing the first character of the domain or acronym-based prefix, then camel-case the remainder (e.g., `DOMDebugger` -> `domDebugger`).

Pseudocode hints
- Optional defaults
  - If `param.isOptional` then `param.type = makeNullable(param.type)` and `param.default = "null"`.
- Property name conversion
  - `propName = domainName.replaceFirstChar { it.lowercase() }` is typically sufficient for all-uppercase acronyms.
  - For concatenated names like `DOMDebugger`, split into words or rely on existing domain-name tokenization to yield `domDebugger`.

Quality gates
- Build: Project compiles with no new warnings.
- Tests: Existing tests pass; add or update tests for optional defaults if present.
- Style: Generated names meet camelCase rules; no `dOM*` properties.

Quick checks and suggested verifications
- Grep generated code for any `@Optional` parameter lacking `= null`.
- Grep for `val dOM` or other non-camel-case patterns in generated `ChromeDevTools`.
- Spot-check domains with acronyms: DOM, HTML, URL, CSS, IO, and ensure `dom`, `html`, `url`, `css`, `io` property names.

Try it locally (Windows / Maven Wrapper)
- From repo root in cmd.exe:
```
.\mvnw.cmd -q -DskipTests -pl cdt-kotlin-protocol-builder -am package
.\mvnw.cmd -q -DskipTests -pl cdt-kotlin-protocol-builder exec:java
```
- Or use the provided script to generate Kotlin (PowerShell):
```
powershell -ExecutionPolicy Bypass -File .\bin\generate-kotlin.ps1
```

Acceptance checklist (summary)
- [ ] All `@Optional` parameters are nullable and have `= null` defaults.
- [ ] No defaults for non-optional parameters.
- [ ] `ChromeDevTools` properties follow camelCase, acronyms lowercased at start (e.g., `dom`, `domDebugger`).
- [ ] Code compiles and tests pass.
- [ ] Spot-checks for acronym-heavy domains look correct.
