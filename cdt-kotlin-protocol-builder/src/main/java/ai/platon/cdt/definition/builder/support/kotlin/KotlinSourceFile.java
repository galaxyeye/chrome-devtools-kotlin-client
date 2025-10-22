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

import com.squareup.kotlinpoet.FileSpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import lombok.Getter;

/** Simple in-memory representation of a Kotlin source file backed by KotlinPoet. */
@Getter
public class KotlinSourceFile {
  private final FileSpec fileSpec;
  private final String packageName;
  private final String fileName;
  private final String rawContent;

  public KotlinSourceFile(FileSpec fileSpec) {
    this.fileSpec = Objects.requireNonNull(fileSpec, "fileSpec");
    this.packageName = fileSpec.getPackageName();
    this.fileName = fileSpec.getName();
    this.rawContent = null;
  }

  public KotlinSourceFile(String packageName, String fileName, String content) {
    this.fileSpec = null;
    this.packageName = Objects.requireNonNull(packageName, "packageName");
    this.fileName = Objects.requireNonNull(fileName, "fileName");
    this.rawContent = Objects.requireNonNull(content, "content");
  }

  public void writeTo(Path outputRoot) throws IOException {
    if (fileSpec != null) {
      // Generate the code from FileSpec and remove redundant public modifiers
      String code = fileSpec.toString();
      code = removeRedundantPublicModifiers(code);
      // Ensure the file-level suppress annotation is the very first line
      code = ensureFileSuppressUnusedAnnotation(code);

      Path packageDir = outputRoot.resolve(packageName.replace('.', java.io.File.separatorChar));
      Files.createDirectories(packageDir);
      String outName = fileName.contains(".") ? fileName : fileName + ".kt";
      Path targetFile = packageDir.resolve(outName);
      Files.writeString(targetFile, code, StandardCharsets.UTF_8);
      return;
    }

    Path packageDir = outputRoot.resolve(packageName.replace('.', java.io.File.separatorChar));
    Files.createDirectories(packageDir);
    String outName = fileName.contains(".") ? fileName : fileName + ".kt";
    Path targetFile = packageDir.resolve(outName);
    String code = ensureFileSuppressUnusedAnnotation(rawContent);
    Files.writeString(targetFile, code, StandardCharsets.UTF_8);
  }

  /**
   * Ensures the first line of the file is `@file:Suppress("unused")`. If it's already present as
   * the first line, no changes are made.
   */
  private String ensureFileSuppressUnusedAnnotation(String code) {
    String header = "@file:Suppress(\"unused\")";
    if (code == null || code.isEmpty()) {
      return header + System.lineSeparator();
    }
    // If already starts with the exact header, return as-is
    if (code.startsWith(header)) {
      return code;
    }
    // Otherwise, prepend the header and a newline
    return header + System.lineSeparator() + code;
  }

  /**
   * Removes redundant 'public' modifiers from Kotlin code. In Kotlin, 'public' is the default
   * visibility modifier and doesn't need to be specified. This method removes explicit 'public'
   * modifiers from: - data classes, classes, objects, interfaces - properties and methods -
   * function parameters and constructor parameters
   */
  private String removeRedundantPublicModifiers(String code) {
    // Remove 'public ' before data/class/object/interface/fun/val/var keywords at start of line or
    // after annotations
    // Pattern: public followed by whitespace, then a Kotlin keyword
    code =
        code.replaceAll(
            "(?m)^(\\s*)public\\s+(data\\s+class|class|object|interface|suspend|fun|val|var|typealias)\\b",
            "$1$2");

    // Remove 'public ' from within function parameters and constructor parameters
    // This handles cases like: public val name: String
    code = code.replaceAll("\\bpublic\\s+(val|var)\\s+", "$1 ");

    return code;
  }
}
