package ai.platon.cdt.definition.builder.support.kotlin;

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

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** Default implementation of {@link KotlinSourceProject}. */
public class KotlinSourceProjectImpl implements KotlinSourceProject {
  private final Path outputRoot;
  private final Map<String, KotlinSourceFile> files = new LinkedHashMap<>();

  public KotlinSourceProjectImpl(Path outputRoot) {
    this.outputRoot = outputRoot;
  }

  @Override
  public void addFile(KotlinSourceFile file) {
    if (file == null) {
      return;
    }
    String key = file.getPackageName() + "." + file.getFileName();
    KotlinSourceFile existing = files.get(key);
    if (existing != null && !Objects.equals(existing.getContent(), file.getContent())) {
      throw new IllegalStateException(
          "Duplicate Kotlin file generated for " + key + " with conflicting content");
    }
    files.putIfAbsent(key, file);
  }

  @Override
  public void writeAll() throws IOException {
    for (KotlinSourceFile file : files.values()) {
      Path packageRoot =
          outputRoot.resolve(file.getPackageName().replace('.', java.io.File.separatorChar));
      Files.createDirectories(packageRoot);

      Path destination = packageRoot.resolve(file.getFileName() + ".kt");
      Files.write(destination, file.getContent().getBytes(StandardCharsets.UTF_8));
    }
  }
}
