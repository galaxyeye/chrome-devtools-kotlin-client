package ai.platon.cdt.kt.protocol

import ai.platon.cdt.kt.protocol.commands.Accessibility
import ai.platon.cdt.kt.protocol.commands.Animation
import ai.platon.cdt.kt.protocol.commands.ApplicationCache
import ai.platon.cdt.kt.protocol.commands.Audits
import ai.platon.cdt.kt.protocol.commands.BackgroundService
import ai.platon.cdt.kt.protocol.commands.Browser
import ai.platon.cdt.kt.protocol.commands.CSS
import ai.platon.cdt.kt.protocol.commands.CacheStorage
import ai.platon.cdt.kt.protocol.commands.Cast
import ai.platon.cdt.kt.protocol.commands.Console
import ai.platon.cdt.kt.protocol.commands.DOM
import ai.platon.cdt.kt.protocol.commands.DOMDebugger
import ai.platon.cdt.kt.protocol.commands.DOMSnapshot
import ai.platon.cdt.kt.protocol.commands.DOMStorage
import ai.platon.cdt.kt.protocol.commands.Database
import ai.platon.cdt.kt.protocol.commands.Debugger
import ai.platon.cdt.kt.protocol.commands.DeviceOrientation
import ai.platon.cdt.kt.protocol.commands.Emulation
import ai.platon.cdt.kt.protocol.commands.Fetch
import ai.platon.cdt.kt.protocol.commands.HeadlessExperimental
import ai.platon.cdt.kt.protocol.commands.HeapProfiler
import ai.platon.cdt.kt.protocol.commands.IO
import ai.platon.cdt.kt.protocol.commands.IndexedDB
import ai.platon.cdt.kt.protocol.commands.Input
import ai.platon.cdt.kt.protocol.commands.Inspector
import ai.platon.cdt.kt.protocol.commands.LayerTree
import ai.platon.cdt.kt.protocol.commands.Log
import ai.platon.cdt.kt.protocol.commands.Media
import ai.platon.cdt.kt.protocol.commands.Memory
import ai.platon.cdt.kt.protocol.commands.Network
import ai.platon.cdt.kt.protocol.commands.Overlay
import ai.platon.cdt.kt.protocol.commands.Page
import ai.platon.cdt.kt.protocol.commands.Performance
import ai.platon.cdt.kt.protocol.commands.PerformanceTimeline
import ai.platon.cdt.kt.protocol.commands.Profiler
import ai.platon.cdt.kt.protocol.commands.Runtime
import ai.platon.cdt.kt.protocol.commands.Schema
import ai.platon.cdt.kt.protocol.commands.Security
import ai.platon.cdt.kt.protocol.commands.ServiceWorker
import ai.platon.cdt.kt.protocol.commands.Storage
import ai.platon.cdt.kt.protocol.commands.SystemInfo
import ai.platon.cdt.kt.protocol.commands.Target
import ai.platon.cdt.kt.protocol.commands.Tethering
import ai.platon.cdt.kt.protocol.commands.Tracing
import ai.platon.cdt.kt.protocol.commands.WebAudio
import ai.platon.cdt.kt.protocol.commands.WebAuthn

interface ChromeDevTools {
  val console: Console

  val debugger: Debugger

  val heapProfiler: HeapProfiler

  val profiler: Profiler

  val runtime: Runtime

  val schema: Schema

  val accessibility: Accessibility

  val animation: Animation

  val applicationCache: ApplicationCache

  val audits: Audits

  val backgroundService: BackgroundService

  val browser: Browser

  val css: CSS

  val cacheStorage: CacheStorage

  val cast: Cast

  val dom: DOM

  val domDebugger: DOMDebugger

  val domSnapshot: DOMSnapshot

  val domStorage: DOMStorage

  val database: Database

  val deviceOrientation: DeviceOrientation

  val emulation: Emulation

  val headlessExperimental: HeadlessExperimental

  val io: IO

  val indexedDB: IndexedDB

  val input: Input

  val inspector: Inspector

  val layerTree: LayerTree

  val log: Log

  val memory: Memory

  val network: Network

  val overlay: Overlay

  val page: Page

  val performance: Performance

  val performanceTimeline: PerformanceTimeline

  val security: Security

  val serviceWorker: ServiceWorker

  val storage: Storage

  val systemInfo: SystemInfo

  val target: Target

  val tethering: Tethering

  val tracing: Tracing

  val fetch: Fetch

  val webAudio: WebAudio

  val webAuthn: WebAuthn

  val media: Media
}
