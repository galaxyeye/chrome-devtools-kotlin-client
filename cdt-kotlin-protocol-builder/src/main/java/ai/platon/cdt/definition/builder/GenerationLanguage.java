package ai.platon.cdt.definition.builder;

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

import java.util.Locale;
import lombok.Getter;

/** Supported generation languages. */
public enum GenerationLanguage {
  JAVA("java", "src/main/java"),
  KOTLIN("kotlin", "src/main/kotlin");

  private final String cliToken;
  @Getter private final String sourceFolder;

  GenerationLanguage(String cliToken, String sourceFolder) {
    this.cliToken = cliToken;
    this.sourceFolder = sourceFolder;
  }

  public static GenerationLanguage fromCliToken(String token) {
    if (token == null) {
      return JAVA;
    }
    String normalized = token.toLowerCase(Locale.ROOT).trim();
    for (GenerationLanguage value : values()) {
      if (value.cliToken.equals(normalized)) {
        return value;
      }
    }
    throw new IllegalArgumentException(
        "Unsupported language '" + token + "'. Expected one of: java, kotlin");
  }
}
