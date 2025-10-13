package ai.platon.cdt.protocol;

/*-
 * #%L
 * cdt-java-client
 * %%
 * Copyright (C) 2018 - 2021 Kenan Klisura
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import ai.platon.cdt.protocol.commands.Accessibility;
import ai.platon.cdt.protocol.commands.Animation;
import ai.platon.cdt.protocol.commands.ApplicationCache;
import ai.platon.cdt.protocol.commands.Audits;
import ai.platon.cdt.protocol.commands.BackgroundService;
import ai.platon.cdt.protocol.commands.Browser;
import ai.platon.cdt.protocol.commands.CSS;
import ai.platon.cdt.protocol.commands.CacheStorage;
import ai.platon.cdt.protocol.commands.Cast;
import ai.platon.cdt.protocol.commands.Console;
import ai.platon.cdt.protocol.commands.DOM;
import ai.platon.cdt.protocol.commands.DOMDebugger;
import ai.platon.cdt.protocol.commands.DOMSnapshot;
import ai.platon.cdt.protocol.commands.DOMStorage;
import ai.platon.cdt.protocol.commands.Database;
import ai.platon.cdt.protocol.commands.Debugger;
import ai.platon.cdt.protocol.commands.DeviceOrientation;
import ai.platon.cdt.protocol.commands.Emulation;
import ai.platon.cdt.protocol.commands.Fetch;
import ai.platon.cdt.protocol.commands.HeadlessExperimental;
import ai.platon.cdt.protocol.commands.HeapProfiler;
import ai.platon.cdt.protocol.commands.IO;
import ai.platon.cdt.protocol.commands.IndexedDB;
import ai.platon.cdt.protocol.commands.Input;
import ai.platon.cdt.protocol.commands.Inspector;
import ai.platon.cdt.protocol.commands.LayerTree;
import ai.platon.cdt.protocol.commands.Log;
import ai.platon.cdt.protocol.commands.Media;
import ai.platon.cdt.protocol.commands.Memory;
import ai.platon.cdt.protocol.commands.Network;
import ai.platon.cdt.protocol.commands.Overlay;
import ai.platon.cdt.protocol.commands.Page;
import ai.platon.cdt.protocol.commands.Performance;
import ai.platon.cdt.protocol.commands.PerformanceTimeline;
import ai.platon.cdt.protocol.commands.Profiler;
import ai.platon.cdt.protocol.commands.Runtime;
import ai.platon.cdt.protocol.commands.Schema;
import ai.platon.cdt.protocol.commands.Security;
import ai.platon.cdt.protocol.commands.ServiceWorker;
import ai.platon.cdt.protocol.commands.Storage;
import ai.platon.cdt.protocol.commands.SystemInfo;
import ai.platon.cdt.protocol.commands.Target;
import ai.platon.cdt.protocol.commands.Tethering;
import ai.platon.cdt.protocol.commands.Tracing;
import ai.platon.cdt.protocol.commands.WebAudio;
import ai.platon.cdt.protocol.commands.WebAuthn;

public interface ChromeDevTools {

  /** Returns the Console command. */
  Console getConsole();

  /** Returns the Debugger command. */
  Debugger getDebugger();

  /** Returns the HeapProfiler command. */
  HeapProfiler getHeapProfiler();

  /** Returns the Profiler command. */
  Profiler getProfiler();

  /** Returns the Runtime command. */
  Runtime getRuntime();

  /** Returns the Schema command. */
  Schema getSchema();

  /** Returns the Accessibility command. */
  Accessibility getAccessibility();

  /** Returns the Animation command. */
  Animation getAnimation();

  /** Returns the ApplicationCache command. */
  ApplicationCache getApplicationCache();

  /** Returns the Audits command. */
  Audits getAudits();

  /** Returns the BackgroundService command. */
  BackgroundService getBackgroundService();

  /** Returns the Browser command. */
  Browser getBrowser();

  /** Returns the CSS command. */
  CSS getCSS();

  /** Returns the CacheStorage command. */
  CacheStorage getCacheStorage();

  /** Returns the Cast command. */
  Cast getCast();

  /** Returns the DOM command. */
  DOM getDOM();

  /** Returns the DOMDebugger command. */
  DOMDebugger getDOMDebugger();

  /** Returns the DOMSnapshot command. */
  DOMSnapshot getDOMSnapshot();

  /** Returns the DOMStorage command. */
  DOMStorage getDOMStorage();

  /** Returns the Database command. */
  Database getDatabase();

  /** Returns the DeviceOrientation command. */
  DeviceOrientation getDeviceOrientation();

  /** Returns the Emulation command. */
  Emulation getEmulation();

  /** Returns the HeadlessExperimental command. */
  HeadlessExperimental getHeadlessExperimental();

  /** Returns the IO command. */
  IO getIO();

  /** Returns the IndexedDB command. */
  IndexedDB getIndexedDB();

  /** Returns the Input command. */
  Input getInput();

  /** Returns the Inspector command. */
  Inspector getInspector();

  /** Returns the LayerTree command. */
  LayerTree getLayerTree();

  /** Returns the Log command. */
  Log getLog();

  /** Returns the Memory command. */
  Memory getMemory();

  /** Returns the Network command. */
  Network getNetwork();

  /** Returns the Overlay command. */
  Overlay getOverlay();

  /** Returns the Page command. */
  Page getPage();

  /** Returns the Performance command. */
  Performance getPerformance();

  /** Returns the PerformanceTimeline command. */
  PerformanceTimeline getPerformanceTimeline();

  /** Returns the Security command. */
  Security getSecurity();

  /** Returns the ServiceWorker command. */
  ServiceWorker getServiceWorker();

  /** Returns the Storage command. */
  Storage getStorage();

  /** Returns the SystemInfo command. */
  SystemInfo getSystemInfo();

  /** Returns the Target command. */
  Target getTarget();

  /** Returns the Tethering command. */
  Tethering getTethering();

  /** Returns the Tracing command. */
  Tracing getTracing();

  /** Returns the Fetch command. */
  Fetch getFetch();

  /** Returns the WebAudio command. */
  WebAudio getWebAudio();

  /** Returns the WebAuthn command. */
  WebAuthn getWebAuthn();

  /** Returns the Media command. */
  Media getMedia();
}
