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

import ai.platon.cdt.launch.ChromeLauncher;
import ai.platon.cdt.protocol.commands.Network;
import ai.platon.cdt.protocol.commands.Page;
import ai.platon.cdt.protocol.types.network.ErrorReason;
import ai.platon.cdt.protocol.types.network.RequestPattern;
import ai.platon.cdt.services.ChromeDevToolsService;
import ai.platon.cdt.services.ChromeService;
import ai.platon.cdt.services.types.ChromeTab;
import java.util.Collections;

/**
 * Intercept and block per URL. Since requestIntercepted event is still Experimental it might not
 * work on your browser.
 *
 * @author Kenan Klisura
 */
public class InterceptAndBlockUrlsExample {
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

    network.onRequestIntercepted(
        event -> {
          String interceptionId = event.getInterceptionId();
          boolean blocked = isBlocked(event.getRequest().getUrl());

          System.out.printf(
              "%s - %s%s",
              (blocked ? "BLOCKED" : "ALLOWED"),
              event.getRequest().getUrl(),
              System.lineSeparator());

          ErrorReason errorReason = blocked ? ErrorReason.ABORTED : null;

          network.continueInterceptedRequest(
              interceptionId, errorReason, null, null, null, null, null, null);
        });

    page.onLoadEventFired(event -> devToolsService.close());

    RequestPattern interceptionRequestPattern = new RequestPattern();
    network.setRequestInterception(Collections.singletonList(interceptionRequestPattern));
    network.enable();

    // Enable page events.
    page.enable();

    // Navigate to github.com.
    page.navigate("http://github.com");

    devToolsService.waitUntilClosed();
  }

  public static boolean isBlocked(String url) {
    return url.endsWith(".png") || url.endsWith(".css");
  }
}
