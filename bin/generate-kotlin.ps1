<#
.SYNOPSIS
    Generates Kotlin source files for the Chrome DevTools protocol.

.DESCRIPTION
    Builds the cdt-kotlin-protocol-builder JAR (unless -SkipBuild is passed) and
    runs it to produce Kotlin classes from the browser and JS protocol JSON files.

    Two output modes are supported:

    - **Standard mode** (default): produces sources under the `cdt-kotlin-client`
      module (package `ai.platon.cdt.kt.protocol`) with Jackson (`@JsonProperty`,
      `@JsonEnumDefaultValue`) annotations.

    - **Serialization mode** (`-Serialization`): produces sources under the
      `cdt-kotlin-client-serialization` module (package
      `ai.platon.cdt.kt.serialization.protocol`) with kotlinx.serialization
      (`@Serializable`, `@SerialName`) annotations. No Jackson/Gson dependency.

.PARAMETER BasePackage
    Base Kotlin package for the generated sources.
    Standard mode default: `ai.platon.cdt.kt.protocol`
    Serialization mode default: `ai.platon.cdt.kt.serialization.protocol`

.PARAMETER OutputProject
    Directory name under the project root where generated sources are written.
    Standard mode default: `cdt-kotlin-client`
    Serialization mode default: `cdt-kotlin-client-serialization`

.PARAMETER JsProtocol
    Path (relative to project root) to the js_protocol.json file.

.PARAMETER BrowserProtocol
    Path (relative to project root) to the browser_protocol.json file.

.PARAMETER Language
    Generation language: `java` or `kotlin`. Default is `kotlin`.

.PARAMETER Serialization
    When set, generates code annotated with kotlinx.serialization annotations
    (`@Serializable`, `@SerialName`) instead of Jackson. Also switches the
    default output directory and package to the serialization module.

.PARAMETER SkipBuild
    When set, skips the Maven build of `cdt-kotlin-protocol-builder`. The JAR
    must already exist at `cdt-kotlin-protocol-builder/target/cdt-kotlin-protocol-builder.jar`.

.EXAMPLE
    # Generate Jackson-annotated sources into cdt-kotlin-client
    .\bin\generate-kotlin.ps1

.EXAMPLE
    # Generate kotlinx.serialization-annotated sources
    .\bin\generate-kotlin.ps1 -Serialization

.EXAMPLE
    # Generate serialization sources with a custom output directory
    .\bin\generate-kotlin.ps1 -Serialization -OutputProject "my-serialization-client"

.EXAMPLE
    # Skip the builder build (use when iterating on protocol JSON only)
    .\bin\generate-kotlin.ps1 -Serialization -SkipBuild
#>

[CmdletBinding()]
param(
    [string]$BasePackage,
    [string]$OutputProject,
    [string]$JsProtocol = "js_protocol.json",
    [string]$BrowserProtocol = "browser_protocol.json",
    [ValidateSet("java", "kotlin")]
    [string]$Language = "kotlin",
    [switch]$Serialization,
    [switch]$SkipBuild
)

# ---- resolve project root ------------------------------------------------
$scriptPath = Split-Path -Parent $MyInvocation.MyCommand.Path
$projectRoot = $scriptPath
while ($projectRoot -and -not (Test-Path (Join-Path $projectRoot "pom.xml"))) {
    $projectRoot = Split-Path -Parent $projectRoot
}

if (-not $projectRoot) {
    Write-Error "Unable to locate project root (missing pom.xml)."
    exit 1
}

Push-Location $projectRoot
try {
    $mvnw = Join-Path $projectRoot "mvnw.cmd"
    if (-not (Test-Path $mvnw)) {
        Write-Error "mvnw.cmd not found. Ensure Maven wrapper is available."
        exit 1
    }

    # ---- resolve defaults driven by -Serialization -----------------------
    $serializationFlag = if ($Serialization) { $true } else { $false }

    if (-not $PSBoundParameters.ContainsKey('BasePackage')) {
        if ($Serialization) {
            $BasePackage = "ai.platon.cdt.kt.serialization.protocol"
        }
        else {
            $BasePackage = "ai.platon.cdt.kt.protocol"
        }
    }

    if (-not $PSBoundParameters.ContainsKey('OutputProject')) {
        if ($Serialization) {
            $OutputProject = "cdt-kotlin-client-serialization"
        }
        else {
            $OutputProject = "cdt-kotlin-client"
        }
    }

    # ---- build the protocol builder JAR ----------------------------------
    $builderModule = Join-Path $projectRoot "cdt-kotlin-protocol-builder"
    $jarPath = Join-Path $builderModule "target/cdt-kotlin-protocol-builder.jar"

    if (-not $SkipBuild) {
        Write-Host "Building cdt-kotlin-protocol-builder..."
        & $mvnw -pl cdt-kotlin-protocol-builder -am package
        if ($LASTEXITCODE -ne 0) {
            throw "Maven build failed with exit code $LASTEXITCODE."
        }
    }

    if (-not (Test-Path $jarPath)) {
        throw "Builder jar not found at $jarPath. Run without -SkipBuild to compile it."
    }

    # ---- validate inputs --------------------------------------------------
    $jsProtocolPath = Join-Path $projectRoot $JsProtocol
    $browserProtocolPath = Join-Path $projectRoot $BrowserProtocol
    $outputProjectPath = Join-Path $projectRoot $OutputProject

    foreach ($path in @($jsProtocolPath, $browserProtocolPath)) {
        if (-not (Test-Path $path)) {
            throw "Required protocol file not found: $path"
        }
    }

    if (Test-Path $outputProjectPath) {
        if (-not (Get-Item $outputProjectPath).PSIsContainer) {
            throw "Output path is not a directory: $outputProjectPath"
        }
    }
    else {
        Write-Host "Creating output directory $outputProjectPath"
        New-Item -ItemType Directory -Path $outputProjectPath -Force | Out-Null
    }

    $resolvedJsProtocol = (Get-Item $jsProtocolPath).FullName
    $resolvedBrowserProtocol = (Get-Item $browserProtocolPath).FullName
    $resolvedOutput = (Get-Item $outputProjectPath).FullName

    if (-not (Get-Command java -ErrorAction SilentlyContinue)) {
        throw "Java runtime not found on PATH. Set JAVA_HOME or add java to PATH."
    }

    # ---- run the generator ------------------------------------------------
    $modeLabel = if ($Serialization) { "kotlinx.serialization" } else { "Jackson" }
    Write-Host "Running Kotlin protocol generator ($modeLabel mode)..."

    $javaArgs = @(
        "-jar", (Get-Item $jarPath).FullName,
        "--base-package", $BasePackage,
        "--js-protocol", $resolvedJsProtocol,
        "--browser-protocol", $resolvedBrowserProtocol,
        "--output", $resolvedOutput,
        "--language", $Language
    )

    if ($Serialization) {
        $javaArgs += "--serialization=true"
    }

    & java @javaArgs
    if ($LASTEXITCODE -ne 0) {
        throw "Protocol generator failed with exit code $LASTEXITCODE."
    }

    Write-Host "Kotlin sources ($modeLabel) generated in $($resolvedOutput)"
}
finally {
    Pop-Location
}
