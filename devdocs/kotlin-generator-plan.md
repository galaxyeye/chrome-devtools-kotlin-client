# Kotlin CDP Generator Plan

Goal
- Read Chrome DevTools Protocol JSON and generate Kotlin sources mirroring the existing Java output: types, events, commands, plus a unified command factory. Command methods are suspend to support coroutines.

Scope
- Non-breaking: default remains Java generation. Kotlin generation is opt-in via `--language kotlin`.
- Output for Kotlin goes to `src/main/kotlin` under the target project; package layout mirrors the Java generator.

Design
- CLI: add `--language` flag (`java` | `kotlin`, default `java`).
- Application routing: if `kotlin`, use a Kotlin generator path; else keep current Java flow.
- Kotlin generator:
  - Builders implemented in a separate namespace; use KotlinPoet for code emission and imports.
  - Map protocol model to:
    - `types.<domain>`: Kotlin data classes/enums with nullability for optional props.
    - `events.<domain>`: Kotlin data classes for event payloads.
    - `commands.<domain>`: Kotlin interfaces; all command methods are `suspend fun` with the same names and parameter lists as Java.
    - `ChromeDevTools`: Kotlin interface in base package; getters per domain `fun get<Domain>(): commands.<Domain>` (non-suspend).
  - Annotations: reuse existing `support.annotations` and `support.types` (Kotlin can reference Java annotations and types). Where Java expects `Class<?>` parameters, Kotlin emits `Foo::class.java`.

Type mapping and nullability
- StringType/StringProperty -> `String`
- IntegerType/IntegerProperty -> `Int`
- NumberType/NumberProperty -> `Double`
- BooleanProperty -> `Boolean`
- AnyProperty/AnyArrayItem -> `Any?`
- Object map -> `Map<String, Any?>`
- Arrays -> `List<T>` (propagate element nullability)
- Optional -> Kotlin nullable (`T?`) and keep `@Optional` annotation.

Return types
- Single return: mapped type as above; if typed generic, add `@ReturnTypeParameter({A::class.java, B::class.java, ...})`.
- Multiple returns: generate a dedicated return data class in `types.<domain>` and return that type.

Events
- `on<Event>(listener: EventHandler<EventPayload>): EventListener` in `commands.<domain>`; these are typically non-suspend; retain annotations.

File layout
- `src/main/kotlin/<basePackagePath>/types/...`
- `src/main/kotlin/<basePackagePath>/events/...`
- `src/main/kotlin/<basePackagePath>/commands/...`
- `src/main/kotlin/<basePackagePath>/ChromeDevTools.kt`

Implementation steps
1) Add `--language` to Configuration and branch in Application.
2) Introduce Kotlin generator module pieces (in the same artifact):
   - Kotlin builder interfaces/factory (Poet-backed) and a `KotlinSourceProject` writer.
   - `TypesBuilderK`, `EventBuilderK`, `CommandBuilderK` translating logic from Java builders to KotlinPoet API.
   - `ChromeDevToolsK` factory generator.
3) Add dependency: `com.squareup:kotlinpoet` to `cdt-kotlin-protocol-builder`.
4) Generate code:
   - Iterate domains, generate types/events first, then commands, then factory.
   - Create overloads: mandatory-only and full params for command methods.
5) Tests:
   - Unit: verify generated code snippets (package, suspend, annotations, nullability).
   - Golden: compare small fixtures.
   - Smoke: compile generated Kotlin in a temp module.

Edge cases
- No types/events/commands domains (emit stubs where useful, or skip cleanly).
- Name collisions and reserved keywords (use KotlinPoet escaping/backticks).
- Redirected commands are skipped.

Acceptance criteria
- `--language kotlin` produces compilable `.kt` sources under `src/main/kotlin` with suspend commands and matching API surface.
- Java path unchanged and continues to work.

Next
- Implement builders incrementally starting from commands (interface skeletons with suspend) and types (common primitives + refs), then events, then return-class generation.

