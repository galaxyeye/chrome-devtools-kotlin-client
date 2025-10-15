package ai.platon.cdt.examples;

/*-
 * #%L
 * cdt-examples
 * %%
 * Copyright (C) 2018 - 2025 platon.ai
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

import ai.platon.cdt.kt.protocol.commands.Network;
import ai.platon.cdt.kt.protocol.commands.Page;
import ai.platon.cdt.kt.protocol.events.page.LoadEventFired;
import ai.platon.cdt.kt.protocol.support.types.EventHandler;
import ai.platon.pulsar.browser.driver.chrome.ChromeDevToolsService;
import ai.platon.pulsar.browser.driver.chrome.ChromeLauncher;
import ai.platon.pulsar.browser.driver.chrome.ChromeService;
import ai.platon.pulsar.browser.driver.chrome.ChromeTab;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Blocks an URLs given a patterns.
 *
 * @author Kenan Klisura
 */
public class BlockUrlGivenPatternExample {
  public static void main(String[] args) {
    // Create chrome launcher.
    final ChromeLauncher launcher = new ChromeLauncher();

    // Launch chrome either as headless (true) or regular (false).
    final ChromeService chromeService = launcher.launch(false);

    // Create empty tab ie about:blank.
    final ChromeTab tab = chromeService.createTab();

    // Get DevTools service to this tab
    final ChromeDevToolsService devToolsService = chromeService.createDevToolsService(tab);

    // Get individual commands
    final Page page = devToolsService.getPage();
    final Network network = devToolsService.getNetwork();

    final Continuation<Object> continuation = new Continuation<>() {
        @NotNull
        @Override
        public CoroutineContext getContext() {
            return null;
        }

        @Override
        public void resumeWith(@NotNull Object o) {

        }
    };

    // Block some urls.
    network.setBlockedURLs(Arrays.asList("**/*.css", "**/*.png", "**/*.svg"), continuation);

    // Enable network events
    network.enable(continuation);

    // Wait for on load event
      page.onLoadEventFired((EventHandler<LoadEventFired>) (event, $completion) -> {
          // Close devtools.
          try { devToolsService.close(); } catch (Exception ignored) {}
          return null;
      });

    // Enable page events.
    page.enable(continuation);

    // Navigate to github.com.
    page.navigate("http://github.com", continuation);

    // Wait until devtools is closed.
    devToolsService.waitUntilClosed();

    // Close tab.
    chromeService.closeTab(tab);
  }
}
