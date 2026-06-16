@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.commands

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.ReturnTypeParameter
import ai.platon.cdt.kt.protocol.support.annotations.Returns
import ai.platon.cdt.kt.protocol.types.crashreportcontext.CrashReportContextEntry
import kotlin.collections.List

/**
 * This domain exposes the current state of the CrashReportContext API.
 */
@Experimental
interface CrashReportContext {
  /**
   * Returns all entries in the CrashReportContext across all frames in the page.
   */
  @Returns("entries")
  @ReturnTypeParameter(CrashReportContextEntry::class)
  suspend fun getEntries(): List<CrashReportContextEntry>
}
