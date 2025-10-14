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

public interface ChromeDevTools {
  public fun getConsole(): Console

  public fun getDebugger(): Debugger

  public fun getHeapProfiler(): HeapProfiler

  public fun getProfiler(): Profiler

  public fun getRuntime(): Runtime

  public fun getSchema(): Schema

  public fun getAccessibility(): Accessibility

  public fun getAnimation(): Animation

  public fun getApplicationCache(): ApplicationCache

  public fun getAudits(): Audits

  public fun getBackgroundService(): BackgroundService

  public fun getBrowser(): Browser

  public fun getCSS(): CSS

  public fun getCacheStorage(): CacheStorage

  public fun getCast(): Cast

  public fun getDOM(): DOM

  public fun getDOMDebugger(): DOMDebugger

  public fun getDOMSnapshot(): DOMSnapshot

  public fun getDOMStorage(): DOMStorage

  public fun getDatabase(): Database

  public fun getDeviceOrientation(): DeviceOrientation

  public fun getEmulation(): Emulation

  public fun getHeadlessExperimental(): HeadlessExperimental

  public fun getIO(): IO

  public fun getIndexedDB(): IndexedDB

  public fun getInput(): Input

  public fun getInspector(): Inspector

  public fun getLayerTree(): LayerTree

  public fun getLog(): Log

  public fun getMemory(): Memory

  public fun getNetwork(): Network

  public fun getOverlay(): Overlay

  public fun getPage(): Page

  public fun getPerformance(): Performance

  public fun getPerformanceTimeline(): PerformanceTimeline

  public fun getSecurity(): Security

  public fun getServiceWorker(): ServiceWorker

  public fun getStorage(): Storage

  public fun getSystemInfo(): SystemInfo

  public fun getTarget(): Target

  public fun getTethering(): Tethering

  public fun getTracing(): Tracing

  public fun getFetch(): Fetch

  public fun getWebAudio(): WebAudio

  public fun getWebAuthn(): WebAuthn

  public fun getMedia(): Media
}
