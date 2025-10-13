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

/** Simple in-memory representation of a Kotlin source file. */
public class KotlinSourceFile {
  private final String packageName;
  private final String fileName;
  private final String content;

  public KotlinSourceFile(String packageName, String fileName, String content) {
    this.packageName = packageName;
    this.fileName = fileName;
    this.content = content;
  }

  public String getPackageName() {
    return packageName;
  }

  public String getFileName() {
    return fileName;
  }

  public String getContent() {
    return content;
  }
}
