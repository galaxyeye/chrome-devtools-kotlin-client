# Kotlin Client Generation Guide

## Main Goal

Chrome DevTools Kotlin Protocol Builder parses DevTools `protocol.json` - a protocol definition file and outputs the kotlin classes and interfaces.

## Known Issues

### annotation not applicable (RESOLVED)

`@Experimental`
- Original error: `This annotation is not applicable to target 'value parameter'. Applicable targets: function, class`
- Root cause: The generated model types and command interfaces annotate constructor property parameters and interface methods with `@Experimental`, but the annotation declaration only targeted `FUNCTION` and `CLASS`. Kotlin differentiates between value parameters (`AnnotationTarget.VALUE_PARAMETER`) and the resulting properties (`AnnotationTarget.PROPERTY`).
- Fix applied: Updated `SupportAnnotations.kt` so `@Experimental` now has
  ```kotlin
  @Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.CLASS,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
  )
  annotation class Experimental
  ```
  (Also corrected older square-bracket array style `@Target([...])` to proper vararg usage.)
- Result: All previous applicability compilation errors disappear after rebuild.
- Future improvement: The generator can emit explicit use-site targets (`@param:Experimental` or `@property:Experimental`) for clarity and to avoid over-broad targets. Consider introducing a separate `@ExperimentalApi` annotation limited to `CLASS`, `FUNCTION`, and `PROPERTY` if parameter-level marking is not semantically needed.

### Argument type mismatch

Error message:

```text
Argument type mismatch: actual type is 'Array<AnnotationTarget>', but 'AnnotationTarget' was expected.
```

Source file: 

`cdt-kotlin-client/src/main/kotlin/ai/platon/cdt/kt/protocol/support/annotations/SupportAnnotations.kt`

Cause & Status:
- Same root cause as above: usage of array literal with `@Target([...])`. Fixed by switching to vararg form.

### [暂缓处理] jackson usage

There are many `@JsonProperty` annotations, tell me why they are needed, for example, 
all classes in package `ai.platon.cdt.kt.protocol.events`

Possible reason:

In ai.platon.cdt.kt.protocol.events (and similar packages), @JsonProperty is there to lock the exact CDP field names and 
make deserialization/serialization deterministic across varied consumer setups. It’s a deliberate, generator-applied 
safeguard for wire-compatibility, refactor safety, and resilience against configuration and tooling differences.

If you control the entire stack and want to reduce boilerplate, you can rely on jackson-module-kotlin and matching names, 
but for a reusable CDP client, the explicit annotations are the safer choice.

改进方案：

- An explicit annotation use-site target is recommended.
