@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.commands

import ai.platon.cdt.kt.protocol.events.css.ComputedStyleUpdated
import ai.platon.cdt.kt.protocol.events.css.FontsUpdated
import ai.platon.cdt.kt.protocol.events.css.MediaQueryResultChanged
import ai.platon.cdt.kt.protocol.events.css.StyleSheetAdded
import ai.platon.cdt.kt.protocol.events.css.StyleSheetChanged
import ai.platon.cdt.kt.protocol.events.css.StyleSheetRemoved
import ai.platon.cdt.kt.protocol.support.annotations.EventName
import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.support.annotations.ParamName
import ai.platon.cdt.kt.protocol.support.annotations.ReturnTypeParameter
import ai.platon.cdt.kt.protocol.support.annotations.Returns
import ai.platon.cdt.kt.protocol.support.types.EventHandler
import ai.platon.cdt.kt.protocol.support.types.EventListener
import ai.platon.cdt.kt.protocol.types.css.AnimatedStylesForNode
import ai.platon.cdt.kt.protocol.types.css.BackgroundColors
import ai.platon.cdt.kt.protocol.types.css.CSSComputedStyleProperty
import ai.platon.cdt.kt.protocol.types.css.CSSContainerQuery
import ai.platon.cdt.kt.protocol.types.css.CSSLayerData
import ai.platon.cdt.kt.protocol.types.css.CSSMedia
import ai.platon.cdt.kt.protocol.types.css.CSSNavigation
import ai.platon.cdt.kt.protocol.types.css.CSSProperty
import ai.platon.cdt.kt.protocol.types.css.CSSRule
import ai.platon.cdt.kt.protocol.types.css.CSSScope
import ai.platon.cdt.kt.protocol.types.css.CSSStyle
import ai.platon.cdt.kt.protocol.types.css.CSSSupports
import ai.platon.cdt.kt.protocol.types.css.ComputedStyleForNode
import ai.platon.cdt.kt.protocol.types.css.InlineStylesForNode
import ai.platon.cdt.kt.protocol.types.css.MatchedStylesForNode
import ai.platon.cdt.kt.protocol.types.css.PlatformFontUsage
import ai.platon.cdt.kt.protocol.types.css.RuleUsage
import ai.platon.cdt.kt.protocol.types.css.SelectorList
import ai.platon.cdt.kt.protocol.types.css.SourceRange
import ai.platon.cdt.kt.protocol.types.css.StyleDeclarationEdit
import ai.platon.cdt.kt.protocol.types.css.TakeCoverageDelta
import ai.platon.cdt.kt.protocol.types.css.Value
import ai.platon.cdt.kt.protocol.types.dom.PseudoType
import kotlin.Any
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map

/**
 * This domain exposes CSS read/write operations. All CSS objects (stylesheets, rules, and styles)
 * have an associated `id` used in subsequent operations on the related object. Each object type has
 * a specific `id` structure, and those are not interchangeable between objects of different kinds.
 * CSS objects can be loaded using the `get*ForNode()` calls (which accept a DOM node id). A client
 * can also keep track of stylesheets via the `styleSheetAdded`/`styleSheetRemoved` events and
 * subsequently load the required stylesheet contents using the `getStyleSheet[Text]()` methods.
 */
@Experimental
interface CSS {
  /**
   * Inserts a new rule with the given `ruleText` in a stylesheet with given `styleSheetId`, at the
   * position specified by `location`.
   * @param styleSheetId The css style sheet identifier where a new rule should be inserted.
   * @param ruleText The text of a new rule.
   * @param location Text position of a new rule in the target style sheet.
   * @param nodeForPropertySyntaxValidation NodeId for the DOM node in whose context custom property declarations for registered properties should be
   * validated. If omitted, declarations in the new rule text can only be validated statically, which may produce
   * incorrect results if the declaration contains a var() for example.
   */
  @Returns("rule")
  suspend fun addRule(
    @ParamName("styleSheetId") styleSheetId: String,
    @ParamName("ruleText") ruleText: String,
    @ParamName("location") location: SourceRange,
    @ParamName("nodeForPropertySyntaxValidation") @Optional @Experimental nodeForPropertySyntaxValidation: Int? = null,
  ): CSSRule

  @Returns("rule")
  suspend fun addRule(
    @ParamName("styleSheetId") styleSheetId: String,
    @ParamName("ruleText") ruleText: String,
    @ParamName("location") location: SourceRange,
  ): CSSRule {
    return addRule(styleSheetId, ruleText, location, null)
  }

  /**
   * Returns all class names from specified stylesheet.
   * @param styleSheetId
   */
  @Returns("classNames")
  @ReturnTypeParameter(String::class)
  suspend fun collectClassNames(@ParamName("styleSheetId") styleSheetId: String): List<String>

  /**
   * Creates a new special "via-inspector" stylesheet in the frame with given `frameId`.
   * @param frameId Identifier of the frame where "via-inspector" stylesheet should be created.
   * @param force If true, creates a new stylesheet for every call. If false,
   * returns a stylesheet previously created by a call with force=false
   * for the frame's document if it exists or creates a new stylesheet
   * (default: false).
   */
  @Returns("styleSheetId")
  suspend fun createStyleSheet(@ParamName("frameId") frameId: String, @ParamName("force") @Optional force: Boolean? = null): String

  @Returns("styleSheetId")
  suspend fun createStyleSheet(@ParamName("frameId") frameId: String): String {
    return createStyleSheet(frameId, null)
  }

  /**
   * Disables the CSS agent for the given page.
   */
  suspend fun disable()

  /**
   * Enables the CSS agent for the given page. Clients should not assume that the CSS agent has been
   * enabled until the result of this command is received.
   */
  suspend fun enable()

  /**
   * Ensures that the given node will have specified pseudo-classes whenever its style is computed by
   * the browser.
   * @param nodeId The element id for which to force the pseudo state.
   * @param forcedPseudoClasses Element pseudo classes to force when computing the element's style.
   */
  suspend fun forcePseudoState(@ParamName("nodeId") nodeId: Int, @ParamName("forcedPseudoClasses") forcedPseudoClasses: List<String>)

  /**
   * Ensures that the given node is in its starting-style state.
   * @param nodeId The element id for which to force the starting-style state.
   * @param forced Boolean indicating if this is on or off.
   */
  suspend fun forceStartingStyle(@ParamName("nodeId") nodeId: Int, @ParamName("forced") forced: Boolean)

  /**
   * @param nodeId Id of the node to get background colors for.
   */
  suspend fun getBackgroundColors(@ParamName("nodeId") nodeId: Int): BackgroundColors

  /**
   * Returns the computed style for a DOM node identified by `nodeId`.
   * @param nodeId
   */
  suspend fun getComputedStyleForNode(@ParamName("nodeId") nodeId: Int): ComputedStyleForNode

  /**
   * Resolve the specified values in the context of the provided element.
   * For example, a value of '1em' is evaluated according to the computed
   * 'font-size' of the element and a value 'calc(1px + 2px)' will be
   * resolved to '3px'.
   * If the `propertyName` was specified the `values` are resolved as if
   * they were property's declaration. If a value cannot be parsed according
   * to the provided property syntax, the value is parsed using combined
   * syntax as if null `propertyName` was provided. If the value cannot be
   * resolved even then, return the provided value without any changes.
   * Note: this function currently does not resolve CSS random() function,
   * it returns unmodified random() function parts.`
   * @param values Cascade-dependent keywords (revert/revert-layer) do not work.
   * @param nodeId Id of the node in whose context the expression is evaluated
   * @param propertyName Only longhands and custom property names are accepted.
   * @param pseudoType Pseudo element type, only works for pseudo elements that generate
   * elements in the tree, such as ::before and ::after.
   * @param pseudoIdentifier Pseudo element custom ident.
   */
  @Experimental
  @Returns("results")
  @ReturnTypeParameter(String::class)
  suspend fun resolveValues(
    @ParamName("values") values: List<String>,
    @ParamName("nodeId") nodeId: Int,
    @ParamName("propertyName") @Optional propertyName: String? = null,
    @ParamName("pseudoType") @Optional pseudoType: PseudoType? = null,
    @ParamName("pseudoIdentifier") @Optional pseudoIdentifier: String? = null,
  ): List<String>

  @Experimental
  @Returns("results")
  @ReturnTypeParameter(String::class)
  suspend fun resolveValues(@ParamName("values") values: List<String>, @ParamName("nodeId") nodeId: Int): List<String> {
    return resolveValues(values, nodeId, null, null, null)
  }

  /**
   * @param shorthandName
   * @param value
   */
  @Experimental
  @Returns("longhandProperties")
  @ReturnTypeParameter(CSSProperty::class)
  suspend fun getLonghandProperties(@ParamName("shorthandName") shorthandName: String, @ParamName("value") `value`: String): List<CSSProperty>

  /**
   * Returns the styles defined inline (explicitly in the "style" attribute and implicitly, using DOM
   * attributes) for a DOM node identified by `nodeId`.
   * @param nodeId
   */
  suspend fun getInlineStylesForNode(@ParamName("nodeId") nodeId: Int): InlineStylesForNode

  /**
   * Returns the styles coming from animations & transitions
   * including the animation & transition styles coming from inheritance chain.
   * @param nodeId
   */
  @Experimental
  suspend fun getAnimatedStylesForNode(@ParamName("nodeId") nodeId: Int): AnimatedStylesForNode

  /**
   * Returns requested styles for a DOM node identified by `nodeId`.
   * @param nodeId
   */
  suspend fun getMatchedStylesForNode(@ParamName("nodeId") nodeId: Int): MatchedStylesForNode

  /**
   * Returns the values of the default UA-defined environment variables used in env()
   */
  @Experimental
  @Returns("environmentVariables")
  @ReturnTypeParameter(String::class, Any::class)
  suspend fun getEnvironmentVariables(): Map<String, Any?>

  /**
   * Returns all media queries parsed by the rendering engine.
   */
  @Returns("medias")
  @ReturnTypeParameter(CSSMedia::class)
  suspend fun getMediaQueries(): List<CSSMedia>

  /**
   * Requests information about platform fonts which we used to render child TextNodes in the given
   * node.
   * @param nodeId
   */
  @Returns("fonts")
  @ReturnTypeParameter(PlatformFontUsage::class)
  suspend fun getPlatformFontsForNode(@ParamName("nodeId") nodeId: Int): List<PlatformFontUsage>

  /**
   * Returns the current textual content for a stylesheet.
   * @param styleSheetId
   */
  @Returns("text")
  suspend fun getStyleSheetText(@ParamName("styleSheetId") styleSheetId: String): String

  /**
   * Returns all layers parsed by the rendering engine for the tree scope of a node.
   * Given a DOM element identified by nodeId, getLayersForNode returns the root
   * layer for the nearest ancestor document or shadow root. The layer root contains
   * the full layer tree for the tree scope and their ordering.
   * @param nodeId
   */
  @Experimental
  @Returns("rootLayer")
  suspend fun getLayersForNode(@ParamName("nodeId") nodeId: Int): CSSLayerData

  /**
   * Given a CSS selector text and a style sheet ID, getLocationForSelector
   * returns an array of locations of the CSS selector in the style sheet.
   * @param styleSheetId
   * @param selectorText
   */
  @Experimental
  @Returns("ranges")
  @ReturnTypeParameter(SourceRange::class)
  suspend fun getLocationForSelector(@ParamName("styleSheetId") styleSheetId: String, @ParamName("selectorText") selectorText: String): List<SourceRange>

  /**
   * Starts tracking the given node for the computed style updates
   * and whenever the computed style is updated for node, it queues
   * a `computedStyleUpdated` event with throttling.
   * There can only be 1 node tracked for computed style updates
   * so passing a new node id removes tracking from the previous node.
   * Pass `undefined` to disable tracking.
   * @param nodeId
   */
  @Experimental
  suspend fun trackComputedStyleUpdatesForNode(@ParamName("nodeId") @Optional nodeId: Int? = null)

  @Experimental
  suspend fun trackComputedStyleUpdatesForNode() {
    return trackComputedStyleUpdatesForNode(null)
  }

  /**
   * Starts tracking the given computed styles for updates. The specified array of properties
   * replaces the one previously specified. Pass empty array to disable tracking.
   * Use takeComputedStyleUpdates to retrieve the list of nodes that had properties modified.
   * The changes to computed style properties are only tracked for nodes pushed to the front-end
   * by the DOM agent. If no changes to the tracked properties occur after the node has been pushed
   * to the front-end, no updates will be issued for the node.
   * @param propertiesToTrack
   */
  @Experimental
  suspend fun trackComputedStyleUpdates(@ParamName("propertiesToTrack") propertiesToTrack: List<CSSComputedStyleProperty>)

  /**
   * Polls the next batch of computed style updates.
   */
  @Experimental
  @Returns("nodeIds")
  @ReturnTypeParameter(Int::class)
  suspend fun takeComputedStyleUpdates(): List<Int>

  /**
   * Find a rule with the given active property for the given node and set the new value for this
   * property
   * @param nodeId The element id for which to set property.
   * @param propertyName
   * @param value
   */
  suspend fun setEffectivePropertyValueForNode(
    @ParamName("nodeId") nodeId: Int,
    @ParamName("propertyName") propertyName: String,
    @ParamName("value") `value`: String,
  )

  /**
   * Modifies the property rule property name.
   * @param styleSheetId
   * @param range
   * @param propertyName
   */
  @Returns("propertyName")
  suspend fun setPropertyRulePropertyName(
    @ParamName("styleSheetId") styleSheetId: String,
    @ParamName("range") range: SourceRange,
    @ParamName("propertyName") propertyName: String,
  ): Value

  /**
   * Modifies the keyframe rule key text.
   * @param styleSheetId
   * @param range
   * @param keyText
   */
  @Returns("keyText")
  suspend fun setKeyframeKey(
    @ParamName("styleSheetId") styleSheetId: String,
    @ParamName("range") range: SourceRange,
    @ParamName("keyText") keyText: String,
  ): Value

  /**
   * Modifies the rule selector.
   * @param styleSheetId
   * @param range
   * @param text
   */
  @Returns("media")
  suspend fun setMediaText(
    @ParamName("styleSheetId") styleSheetId: String,
    @ParamName("range") range: SourceRange,
    @ParamName("text") text: String,
  ): CSSMedia

  /**
   * Modifies the expression of a container query.
   * Deprecated. Use setContainerQueryConditionText instead.
   * @param styleSheetId
   * @param range
   * @param text
   */
  @Deprecated("Deprecated by protocol")
  @Experimental
  @Returns("containerQuery")
  suspend fun setContainerQueryText(
    @ParamName("styleSheetId") styleSheetId: String,
    @ParamName("range") range: SourceRange,
    @ParamName("text") text: String,
  ): CSSContainerQuery

  /**
   * @param styleSheetId
   * @param range
   * @param text
   */
  @Experimental
  @Returns("containerQuery")
  suspend fun setContainerQueryConditionText(
    @ParamName("styleSheetId") styleSheetId: String,
    @ParamName("range") range: SourceRange,
    @ParamName("text") text: String,
  ): CSSContainerQuery

  /**
   * Modifies the expression of a supports at-rule.
   * @param styleSheetId
   * @param range
   * @param text
   */
  @Experimental
  @Returns("supports")
  suspend fun setSupportsText(
    @ParamName("styleSheetId") styleSheetId: String,
    @ParamName("range") range: SourceRange,
    @ParamName("text") text: String,
  ): CSSSupports

  /**
   * Modifies the expression of a navigation at-rule.
   * @param styleSheetId
   * @param range
   * @param text
   */
  @Experimental
  @Returns("navigation")
  suspend fun setNavigationText(
    @ParamName("styleSheetId") styleSheetId: String,
    @ParamName("range") range: SourceRange,
    @ParamName("text") text: String,
  ): CSSNavigation

  /**
   * Modifies the expression of a scope at-rule.
   * @param styleSheetId
   * @param range
   * @param text
   */
  @Experimental
  @Returns("scope")
  suspend fun setScopeText(
    @ParamName("styleSheetId") styleSheetId: String,
    @ParamName("range") range: SourceRange,
    @ParamName("text") text: String,
  ): CSSScope

  /**
   * Modifies the rule selector.
   * @param styleSheetId
   * @param range
   * @param selector
   */
  @Returns("selectorList")
  suspend fun setRuleSelector(
    @ParamName("styleSheetId") styleSheetId: String,
    @ParamName("range") range: SourceRange,
    @ParamName("selector") selector: String,
  ): SelectorList

  /**
   * Sets the new stylesheet text.
   * @param styleSheetId
   * @param text
   */
  @Returns("sourceMapURL")
  suspend fun setStyleSheetText(@ParamName("styleSheetId") styleSheetId: String, @ParamName("text") text: String): String?

  /**
   * Applies specified style edits one after another in the given order.
   * @param edits
   * @param nodeForPropertySyntaxValidation NodeId for the DOM node in whose context custom property declarations for registered properties should be
   * validated. If omitted, declarations in the new rule text can only be validated statically, which may produce
   * incorrect results if the declaration contains a var() for example.
   */
  @Returns("styles")
  @ReturnTypeParameter(CSSStyle::class)
  suspend fun setStyleTexts(@ParamName("edits") edits: List<StyleDeclarationEdit>, @ParamName("nodeForPropertySyntaxValidation") @Optional @Experimental nodeForPropertySyntaxValidation: Int? = null): List<CSSStyle>

  @Returns("styles")
  @ReturnTypeParameter(CSSStyle::class)
  suspend fun setStyleTexts(@ParamName("edits") edits: List<StyleDeclarationEdit>): List<CSSStyle> {
    return setStyleTexts(edits, null)
  }

  /**
   * Enables the selector recording.
   */
  suspend fun startRuleUsageTracking()

  /**
   * Stop tracking rule usage and return the list of rules that were used since last call to
   * `takeCoverageDelta` (or since start of coverage instrumentation).
   */
  @Returns("ruleUsage")
  @ReturnTypeParameter(RuleUsage::class)
  suspend fun stopRuleUsageTracking(): List<RuleUsage>

  /**
   * Obtain list of rules that became used since last call to this method (or since start of coverage
   * instrumentation).
   */
  suspend fun takeCoverageDelta(): TakeCoverageDelta

  /**
   * Enables/disables rendering of local CSS fonts (enabled by default).
   * @param enabled Whether rendering of local fonts is enabled.
   */
  @Experimental
  suspend fun setLocalFontsEnabled(@ParamName("enabled") enabled: Boolean)

  @EventName("fontsUpdated")
  fun onFontsUpdated(eventListener: EventHandler<FontsUpdated>): EventListener

  @EventName("fontsUpdated")
  fun onFontsUpdated(eventListener: suspend (FontsUpdated) -> Unit): EventListener

  @EventName("mediaQueryResultChanged")
  fun onMediaQueryResultChanged(eventListener: EventHandler<MediaQueryResultChanged>): EventListener

  @EventName("mediaQueryResultChanged")
  fun onMediaQueryResultChanged(eventListener: suspend (MediaQueryResultChanged) -> Unit): EventListener

  @EventName("styleSheetAdded")
  fun onStyleSheetAdded(eventListener: EventHandler<StyleSheetAdded>): EventListener

  @EventName("styleSheetAdded")
  fun onStyleSheetAdded(eventListener: suspend (StyleSheetAdded) -> Unit): EventListener

  @EventName("styleSheetChanged")
  fun onStyleSheetChanged(eventListener: EventHandler<StyleSheetChanged>): EventListener

  @EventName("styleSheetChanged")
  fun onStyleSheetChanged(eventListener: suspend (StyleSheetChanged) -> Unit): EventListener

  @EventName("styleSheetRemoved")
  fun onStyleSheetRemoved(eventListener: EventHandler<StyleSheetRemoved>): EventListener

  @EventName("styleSheetRemoved")
  fun onStyleSheetRemoved(eventListener: suspend (StyleSheetRemoved) -> Unit): EventListener

  @EventName("computedStyleUpdated")
  @Experimental
  fun onComputedStyleUpdated(eventListener: EventHandler<ComputedStyleUpdated>): EventListener

  @EventName("computedStyleUpdated")
  @Experimental
  fun onComputedStyleUpdated(eventListener: suspend (ComputedStyleUpdated) -> Unit): EventListener
}
