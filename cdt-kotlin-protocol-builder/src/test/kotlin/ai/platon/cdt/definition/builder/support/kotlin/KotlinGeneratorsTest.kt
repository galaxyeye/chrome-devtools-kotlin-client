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
package ai.platon.cdt.definition.builder.support.kotlin

import ai.platon.cdt.definition.builder.support.protocol.builder.support.DomainTypeResolver
import ai.platon.cdt.definition.builder.support.utils.StringUtils
import ai.platon.cdt.protocol.definition.DevToolsProtocol
import ai.platon.cdt.protocol.definition.types.Command
import ai.platon.cdt.protocol.definition.types.Domain
import ai.platon.cdt.protocol.definition.types.Event
import ai.platon.cdt.protocol.definition.types.type.`object`.ObjectType
import ai.platon.cdt.protocol.definition.types.type.`object`.properties.ArrayProperty
import ai.platon.cdt.protocol.definition.types.type.`object`.properties.StringProperty
import ai.platon.cdt.protocol.definition.types.type.`object`.properties.array.items.StringArrayItem
import com.tschuchort.compiletesting.KotlinCompilation
import com.tschuchort.compiletesting.SourceFile
import org.jetbrains.kotlin.compiler.plugin.ExperimentalCompilerApi
import org.jetbrains.kotlin.config.JvmDefaultMode
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.util.stream.Collectors

class KotlinGeneratorsTest {
    private val context = KotlinGenerationContext(
        basePackage = "ai.platon.cdt.protocol",
        typesPackage = "ai.platon.cdt.protocol.types",
        eventsPackage = "ai.platon.cdt.protocol.events",
        commandsPackage = "ai.platon.cdt.protocol.commands",
        supportTypesPackage = "ai.platon.cdt.protocol.support.types",
        supportAnnotationsPackage = "ai.platon.cdt.protocol.support.annotations"
    )
    private val mapper = KotlinTypeMapper(context)
    private val typesBuilder = KotlinTypesBuilder(context, mapper)
    private val commandsBuilder = KotlinCommandsBuilder(context, mapper, typesBuilder)
    private val eventsBuilder = KotlinEventsBuilder(context, mapper)
    private val resolver: DomainTypeResolver = DomainTypeResolver { _, _ -> null }

    @Test
    fun `command builder emits suspend overloads and annotations`() {
        val requestId = StringProperty().apply {
            name = "requestId"
            description = "Network request id"
        }
        val format = StringProperty().apply {
            name = "format"
            optional = true
        }
        val bodyItems = StringArrayItem()
        val body = ArrayProperty().apply {
            name = "body"
            description = "Chunks"
            items = bodyItems
        }

        val command = Command().apply {
            name = "getResponseBody"
            description = "Returns body for request"
            parameters = listOf(requestId, format)
            returns = listOf(body)
        }

        val eventPayload = StringProperty().apply { name = "status" }
        val event = Event().apply {
            name = "responseReceived"
            parameters = listOf(eventPayload)
        }

        val domain = Domain().apply {
            domain = "Network"
            commands = listOf(command)
            events = listOf(event)
        }

        val files = commandsBuilder.build(domain, resolver)
        val networkSpec = files.first { it.fileName == StringUtils.toEnumClass(domain.domain) }.fileSpec
        val code = networkSpec.toString()

        val hasSuspend = code.contains("suspend fun getResponseBody(")
        val hasParamName = code.contains("@ParamName(\"requestId\")")
        val hasOptional = code.contains("@Optional")
        val hasFormat = code.contains("format: String?")
        val hasCorrectOptionalOrder = code.indexOf("@Optional") < code.indexOf("format: String?")
        val hasReturns = code.contains("@Returns(\"body\")")
        val hasReturnTypeParam = code.contains("@ReturnTypeParameter(String::class)")
        val hasOverload =
            code.contains("suspend fun getResponseBody(@ParamName(\"requestId\") requestId: String): List<String>")
        val hasReturnDelegate = code.contains("return getResponseBody(requestId, null)")
        val hasEventHandlerVariant =
            code.contains("fun onResponseReceived(eventListener: EventHandler<ResponseReceived>): EventListener")
        val hasSuspendLambdaVariant =
            code.contains("fun onResponseReceived(eventListener: suspend (ResponseReceived) -> Unit): EventListener")

        assertTrue(hasSuspend)
        assertTrue(hasParamName)
        assertTrue(hasOptional)
        assertTrue(hasFormat)
        assertTrue(hasCorrectOptionalOrder)
        assertTrue(hasReturns)
        assertTrue(hasReturnTypeParam)
        assertTrue(hasOverload)
        assertTrue(hasReturnDelegate)
        assertTrue(hasEventHandlerVariant)
        assertTrue(hasSuspendLambdaVariant)
    }

    @Test
    fun `types builder maps optional properties to nullable defaults`() {
        val urlProperty = StringProperty().apply {
            name = "url"
            description = "Resource url"
        }
        val mimeType = StringProperty().apply {
            name = "mimeType"
            optional = true
        }

        val payload = ObjectType().apply {
            id = "Request"
            description = "HTTP request"
            properties = listOf(urlProperty, mimeType)
        }

        val domain = Domain().apply {
            domain = "Network"
            types = listOf(payload)
        }

        val files = typesBuilder.build(domain, resolver)
        val requestSpec = files.first { it.fileName == "Request" }.fileSpec
        val content = requestSpec.toString()

        assertTrue(content.contains("data class Request"))
        assertTrue(content.contains("@field:JsonProperty(\"url\")"))
        assertTrue(content.contains("val url: String"))
        assertTrue(content.contains("@param:Optional"))
        assertTrue(content.contains("val mimeType: String?"))
        assertTrue(content.contains("mimeType: String? = null"))
    }

    @OptIn(ExperimentalCompilerApi::class)
    @Test
    fun `protocol generator output compiles`() {
        val bodyChunks = ArrayProperty().apply {
            name = "chunks"
            items = StringArrayItem()
        }
        val command = Command().apply {
            name = "capture"
            parameters = listOf(StringProperty().apply { name = "targetId" })
            returns = listOf(bodyChunks)
        }

        val domain = Domain().apply {
            domain = "Profiler"
            commands = listOf(command)
            types = listOf(ObjectType().apply {
                id = "Target"
                properties = listOf(StringProperty().apply { name = "id" })
            })
        }

        val protocol = DevToolsProtocol().apply { domains = listOf(domain) }
        val outputDir = Files.createTempDirectory("kotlin-gen-test")

        try {
            val generator = KotlinProtocolGenerator(
                context.basePackage,
                context.typesPackage,
                context.eventsPackage,
                context.commandsPackage,
                context.supportTypesPackage,
                context.supportAnnotationsPackage,
                outputDir
            )
            generator.generate(protocol, resolver)

            val sources = Files.walk(outputDir).use { walk ->
                walk.filter { Files.isRegularFile(it) && it.toString().endsWith(".kt") }
                    .map { path ->
                        val content = String(Files.readAllBytes(path), StandardCharsets.UTF_8)
                        SourceFile.kotlin(path.fileName.toString(), content)
                    }
                    .collect(Collectors.toCollection { ArrayList<SourceFile>() })
            }

            // No manual support stubs added; generator already produced support types

            assertTrue("Expected generated Kotlin sources", sources.isNotEmpty())

            // java.lang.NoSuchFieldError: JvmDefaultMode.DEFAULT
            // waiting for compiletesting's to fix the issue
            val compatible = JvmDefaultMode.entries.map { it.name }.contains("DEFAULT")
            if (compatible) {
                val compilation = KotlinCompilation().apply {
                    inheritClassPath = true
                    this.sources = sources
                }

                val result = compilation.compile()
                assertEquals(KotlinCompilation.ExitCode.OK, result.exitCode)
            }
        } finally {
            outputDir.toFile().deleteRecursively()
        }
    }

    @Test
    fun `events builder creates payload classes`() {
        val event = Event().apply {
            name = "dataAvailable"
            description = "Payload delivered"
            parameters = listOf(StringProperty().apply { name = "state" })
        }

        val domain = Domain().apply {
            domain = "Storage"
            events = listOf(event)
        }

        val files = eventsBuilder.build(domain, resolver)
        val eventSpec = files.first { it.fileName == StringUtils.toEnumClass(event.name) }.fileSpec
        val code = eventSpec.toString()

        assertTrue(code.contains("data class DataAvailable"))
        assertTrue(code.contains("@field:JsonProperty(\"state\")"))
        assertTrue(code.contains("val state: String"))
    }
}
