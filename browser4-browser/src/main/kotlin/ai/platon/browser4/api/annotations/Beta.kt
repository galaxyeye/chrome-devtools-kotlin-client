package ai.platon.browser4.api.annotations

/**
 * Marks a public API as experimental and subject to change.
 *
 * Mirrors com.google.common.annotations.Beta semantics.
 */
@RequiresOptIn(level = RequiresOptIn.Level.WARNING)
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY)
annotation class Beta
