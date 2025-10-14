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

/** Simple in-memory representation of a Kotlin source file backed by KotlinPoet. */
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

  public FileSpec getFileSpec() {
    return fileSpec;
  }

  public String getPackageName() {
    return packageName;
  }

  public String getFileName() {
    return fileName;
  }

  public String getRawContent() {
    return rawContent;
  }

  public void writeTo(Path outputRoot) throws IOException {
    if (fileSpec != null) {
      fileSpec.writeTo(outputRoot);
      return;
    }

    Path packageDir = outputRoot.resolve(packageName.replace('.', java.io.File.separatorChar));
    Files.createDirectories(packageDir);
    Path targetFile = packageDir.resolve(fileName + ".kt");
    Files.writeString(targetFile, rawContent, StandardCharsets.UTF_8);
  }
}
