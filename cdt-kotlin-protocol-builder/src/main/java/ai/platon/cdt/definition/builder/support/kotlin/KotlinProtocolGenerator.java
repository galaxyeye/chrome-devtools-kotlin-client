package ai.platon.cdt.definition.builder.support.kotlin;

/*-
 * #%L
 * cdt-java-protocol-builder
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

import ai.platon.cdt.definition.builder.support.protocol.builder.support.DomainTypeResolver;
import ai.platon.cdt.definition.builder.support.utils.StringUtils;
import ai.platon.cdt.protocol.definition.DevToolsProtocol;
import ai.platon.cdt.protocol.definition.types.Command;
import ai.platon.cdt.protocol.definition.types.Domain;
import java.io.IOException;
import java.nio.file.Path;

/** Emits minimal Kotlin stubs for commands and the ChromeDevTools entry point. */
public class KotlinProtocolGenerator {
  private final String basePackage;
  private final String commandPackage;
  private final Path outputRoot;

  public KotlinProtocolGenerator(
      String basePackage,
      String typesPackageName,
      String eventPackageName,
      String commandPackageName,
      String supportTypesPackageName,
      String supportAnnotationsPackageName,
      Path outputRoot) {
    this.basePackage = basePackage;
    this.commandPackage = commandPackageName;
    this.outputRoot = outputRoot;
  }

  public void generate(DevToolsProtocol protocol, DomainTypeResolver domainTypeResolver)
      throws IOException {
    KotlinSourceProject project = new KotlinSourceProjectImpl(outputRoot);

    for (Domain domain : protocol.getDomains()) {
      project.addFile(buildCommandInterface(domain));
    }

    project.addFile(buildChromeDevToolsFactory(protocol));

    project.writeAll();
  }

  private KotlinSourceFile buildCommandInterface(Domain domain) {
    String domainClassName = StringUtils.toEnumClass(domain.getDomain());
    String packageName = commandPackage + "." + domain.getDomain().toLowerCase();

    StringBuilder content = new StringBuilder();
    content.append("package ").append(packageName).append("\n\n");
    content
        .append("// Generated Kotlin stub for ")
        .append(domain.getDomain())
        .append(" domain. TODO: wire full type mapping.\n");

    if (domain.getDescription() != null && !domain.getDescription().isEmpty()) {
      content.append("/** ").append(domain.getDescription().replace("*/", "*\\/")).append(" */\n");
    }

    content.append("interface ").append(domainClassName).append(" {").append("\n");

    if (domain.getCommands() != null) {
      for (Command command : domain.getCommands()) {
        if (command.getRedirect() != null && !command.getRedirect().isEmpty()) {
          continue;
        }

        if (command.getDescription() != null && !command.getDescription().isEmpty()) {
          content
              .append("    /** ")
              .append(command.getDescription().replace("*/", "*\\/"))
              .append(" */\n");
        }

        content.append("    suspend fun ").append(command.getName()).append("(): Unit\n");
      }
    }

    content.append("}\n");

    return new KotlinSourceFile(packageName, domainClassName, content.toString());
  }

  private KotlinSourceFile buildChromeDevToolsFactory(DevToolsProtocol protocol) {
    StringBuilder content = new StringBuilder();
    content.append("package ").append(basePackage).append("\n\n");
    content.append("// Generated Kotlin stub for ChromeDevTools factory.\n");
    content.append("interface ChromeDevTools {\n");

    for (Domain domain : protocol.getDomains()) {
      String domainClassName = StringUtils.toEnumClass(domain.getDomain());
      String packageName = commandPackage + "." + domain.getDomain().toLowerCase();
      content
          .append("    fun get")
          .append(domainClassName)
          .append("(): ")
          .append(packageName)
          .append(".")
          .append(domainClassName)
          .append("\n");
    }

    content.append("}\n");

    return new KotlinSourceFile(basePackage, "ChromeDevTools", content.toString());
  }
}
