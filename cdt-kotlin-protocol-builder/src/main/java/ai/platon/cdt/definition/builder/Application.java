package ai.platon.cdt.definition.builder;

/*-
 * #%L
 * cdt-java-protocol-builder
 * %%
 * Copyright (C) 2025 platon.ai
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

import static com.github.javaparser.utils.CodeGenerationUtils.packageToPath;

import ai.platon.cdt.definition.builder.support.java.builder.Builder;
import ai.platon.cdt.definition.builder.support.java.builder.JavaBuilderFactory;
import ai.platon.cdt.definition.builder.support.java.builder.JavaClassBuilder;
import ai.platon.cdt.definition.builder.support.java.builder.JavaEnumBuilder;
import ai.platon.cdt.definition.builder.support.java.builder.JavaInterfaceBuilder;
import ai.platon.cdt.definition.builder.support.java.builder.SourceProject;
import ai.platon.cdt.definition.builder.support.java.builder.impl.JavaClassBuilderImpl;
import ai.platon.cdt.definition.builder.support.java.builder.impl.JavaEnumBuilderImpl;
import ai.platon.cdt.definition.builder.support.java.builder.impl.JavaInterfaceBuilderImpl;
import ai.platon.cdt.definition.builder.support.java.builder.impl.SourceProjectImpl;
import ai.platon.cdt.definition.builder.support.kotlin.KotlinProtocolGenerator;
import ai.platon.cdt.definition.builder.support.protocol.builder.CommandBuilder;
import ai.platon.cdt.definition.builder.support.protocol.builder.EventBuilder;
import ai.platon.cdt.definition.builder.support.protocol.builder.TypesBuilder;
import ai.platon.cdt.definition.builder.support.utils.DomainUtils;
import ai.platon.cdt.definition.builder.support.utils.StringUtils;
import ai.platon.cdt.protocol.definition.DevToolsProtocol;
import ai.platon.cdt.protocol.definition.types.Domain;
import ai.platon.cdt.protocol.definition.utils.DevToolsProtocolUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.ParserProperties;

/**
 * Application
 *
 * @author Kenan Klisura
 */
public class Application {
  private static final String TYPES_PACKAGE = "types";
  private static final String EVENTS_PACKAGE = "events";
  private static final String COMMANDS_PACKAGE = "commands";
  private static final String SUPPORT_ANNOTATIONS_PACKAGE = "support.annotations";
  private static final String SUPPORT_TYPE_PACKAGE = "support.types";

  private static final String COMMAND_FACTORY_NAME = "ChromeDevTools";

  /**
   * Applications main entry point.
   *
   * @param args Arguments.
   */
  public static void main(String[] args) throws IOException {
    final ParserProperties parserProperties = ParserProperties.defaults().withUsageWidth(120);

    final Configuration configuration = new Configuration();
    final CmdLineParser parser = new CmdLineParser(configuration, parserProperties);

    try {
      parser.parseArgument(args);
    } catch (CmdLineException ex) {
      System.err.println(ex.getMessage());
      parser.printUsage(System.err);
      System.exit(1);
    }

    GenerationLanguage language;
    try {
      language = GenerationLanguage.fromCliToken(configuration.getLanguage());
    } catch (IllegalArgumentException ex) {
      System.err.println(ex.getMessage());
      parser.printUsage(System.err);
      System.exit(1);
      return;
    }

    final String typesPackageName =
        StringUtils.buildPackageName(configuration.getBasePackage(), TYPES_PACKAGE);
    final String eventPackageName =
        StringUtils.buildPackageName(configuration.getBasePackage(), EVENTS_PACKAGE);
    final String commandPackageName =
        StringUtils.buildPackageName(configuration.getBasePackage(), COMMANDS_PACKAGE);

    final String supportTypesPackageName =
        StringUtils.buildPackageName(configuration.getBasePackage(), SUPPORT_TYPE_PACKAGE);
    final String supportAnnotationsPackageName =
        StringUtils.buildPackageName(configuration.getBasePackage(), SUPPORT_ANNOTATIONS_PACKAGE);

    final DevToolsProtocol protocol = readDevToolsProtocolFiles(configuration);
    final Path outputRoot = configuration.getOutputProjectLocation().toPath();
    final Path languageRoot = outputRoot.resolve(language.getSourceFolder());

    cleanGeneratedPackage(languageRoot, configuration.getBasePackage());

    switch (language) {
      case JAVA:
        generateJava(
            protocol,
            configuration.getBasePackage(),
            typesPackageName,
            eventPackageName,
            commandPackageName,
            supportTypesPackageName,
            supportAnnotationsPackageName,
            languageRoot);
        break;
      case KOTLIN:
        generateKotlin(
            protocol,
            configuration.getBasePackage(),
            typesPackageName,
            eventPackageName,
            commandPackageName,
            supportTypesPackageName,
            supportAnnotationsPackageName,
            languageRoot);
        break;
      default:
        throw new IllegalStateException("Unhandled generation language: " + language);
    }
  }

  private static Builder buildCommandFactory(List<Domain> domains, String basePackage) {
    String commandsPackage = basePackage + "." + COMMANDS_PACKAGE;

    JavaInterfaceBuilder factoryInterfaceBuilder =
        new JavaInterfaceBuilderImpl(basePackage, COMMAND_FACTORY_NAME, null);

    for (Domain domain : domains) {
      String description = String.format("Returns the %s command.", domain.getDomain());

      factoryInterfaceBuilder.addImport(commandsPackage, domain.getDomain());
      factoryInterfaceBuilder.addMethod(
          "get" + domain.getDomain(), description, null, domain.getDomain());
    }

    return factoryInterfaceBuilder;
  }

  private static DevToolsProtocol readDevToolsProtocolFiles(Configuration configuration)
      throws IOException {
    DevToolsProtocol jsProtocol = readDevToolsProtocolFile(configuration.getJsProtocolFile());
    DevToolsProtocol browserProtocol =
        readDevToolsProtocolFile(configuration.getBrowserProtocolFile());

    return mergeProtocols(jsProtocol, browserProtocol);
  }

  private static DevToolsProtocol mergeProtocols(
      DevToolsProtocol jsProtocol, DevToolsProtocol browserProtocol) {
    DevToolsProtocol mergedProtocol = new DevToolsProtocol();
    mergedProtocol.setVersion(jsProtocol.getVersion());
    mergedProtocol.setDomains(new ArrayList<>(jsProtocol.getDomains()));
    mergedProtocol.getDomains().addAll(browserProtocol.getDomains());

    return mergedProtocol;
  }

  private static DevToolsProtocol readDevToolsProtocolFile(File file) throws IOException {
    InputStream inputStream = null;
    try {
      inputStream = new FileInputStream(file);
      return DevToolsProtocolUtils.readJson(inputStream);
    } finally {
      if (inputStream != null) {
        inputStream.close();
      }
    }
  }

  private static void generateJava(
      DevToolsProtocol protocol,
      String basePackage,
      String typesPackageName,
      String eventPackageName,
      String commandPackageName,
      String supportTypesPackageName,
      String supportAnnotationsPackageName,
      Path languageRoot)
      throws IOException {
    SourceProject sourceProject = new SourceProjectImpl(languageRoot);

    JavaBuilderFactory javaBuilderFactory =
        new JavaBuilderFactory() {
          @Override
          public JavaClassBuilder createClassBuilder(String packageName, String className) {
            return new JavaClassBuilderImpl(packageName, className, supportAnnotationsPackageName);
          }

          @Override
          public JavaEnumBuilder createEnumBuilder(String packageName, String enumName) {
            return new JavaEnumBuilderImpl(packageName, enumName);
          }

          @Override
          public JavaInterfaceBuilder createInterfaceBuilder(
              String packageName, String interfaceName) {
            return new JavaInterfaceBuilderImpl(
                packageName, interfaceName, supportAnnotationsPackageName);
          }
        };

    final TypesBuilder typesBuilder = new TypesBuilder(typesPackageName, javaBuilderFactory);
    final EventBuilder eventBuilder =
        new EventBuilder(eventPackageName, javaBuilderFactory, typesPackageName);
    final CommandBuilder commandBuilder =
        new CommandBuilder(
            commandPackageName,
            javaBuilderFactory,
            typesPackageName,
            eventPackageName,
            supportTypesPackageName);

    List<Builder> builderList = new ArrayList<>();

    for (Domain domain : protocol.getDomains()) {
      builderList.addAll(
          typesBuilder.build(domain, DomainUtils.devToolsProtocolResolver(protocol)));
      builderList.addAll(
          eventBuilder.build(domain, DomainUtils.devToolsProtocolResolver(protocol)));
      builderList.add(commandBuilder.build(domain, DomainUtils.devToolsProtocolResolver(protocol)));
    }

    builderList.add(buildCommandFactory(protocol.getDomains(), basePackage));

    for (Builder builder : builderList) {
      builder.build(sourceProject);
    }

    sourceProject.saveAll();
  }

  private static void generateKotlin(
      DevToolsProtocol protocol,
      String basePackage,
      String typesPackageName,
      String eventPackageName,
      String commandPackageName,
      String supportTypesPackageName,
      String supportAnnotationsPackageName,
      Path languageRoot)
      throws IOException {
    KotlinProtocolGenerator generator =
        new KotlinProtocolGenerator(
            basePackage,
            typesPackageName,
            eventPackageName,
            commandPackageName,
            supportTypesPackageName,
            supportAnnotationsPackageName,
            languageRoot);
    generator.generate(protocol, DomainUtils.devToolsProtocolResolver(protocol));
  }

  private static void cleanGeneratedPackage(Path languageRoot, String basePackage)
      throws IOException {
    if (basePackage == null) {
      return;
    }
    Path packageRoot = languageRoot.resolve(packageToPath(basePackage));
    if (Files.notExists(packageRoot)) {
      return;
    }

    Files.walk(packageRoot)
        .sorted((a, b) -> b.compareTo(a))
        .forEach(
            path -> {
              try {
                Files.deleteIfExists(path);
              } catch (IOException e) {
                throw new RuntimeException("Failed cleaning generated sources at " + path, e);
              }
            });
  }
}
