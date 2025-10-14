[CmdletBinding()]
param(
    [string]$BasePackage = "ai.platon.cdt.kt.protocol",
    [string]$OutputProject = "cdt-kotlin-client",
    [string]$JsProtocol = "js_protocol.json",
    [string]$BrowserProtocol = "browser_protocol.json",
    [ValidateSet("java", "kotlin")]
    [string]$Language = "kotlin",
    [switch]$SkipBuild
)

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
    } else {
        Write-Host "Creating output directory $outputProjectPath"
        New-Item -ItemType Directory -Path $outputProjectPath -Force | Out-Null
    }

    $resolvedJsProtocol = (Get-Item $jsProtocolPath).FullName
    $resolvedBrowserProtocol = (Get-Item $browserProtocolPath).FullName
    $resolvedOutput = (Get-Item $outputProjectPath).FullName

    if (-not (Get-Command java -ErrorAction SilentlyContinue)) {
        throw "Java runtime not found on PATH. Set JAVA_HOME or add java to PATH."
    }

    Write-Host "Running Kotlin protocol generator..."
    $javaArgs = @(
        "-jar", (Get-Item $jarPath).FullName,
        "--base-package", $BasePackage,
        "--js-protocol", $resolvedJsProtocol,
        "--browser-protocol", $resolvedBrowserProtocol,
        "--output", $resolvedOutput,
        "--language", $Language
    )

    & java @javaArgs
    if ($LASTEXITCODE -ne 0) {
        throw "Protocol generator failed with exit code $LASTEXITCODE."
    }

    Write-Host "Kotlin sources generated in $($resolvedOutput)"
}
finally {
    Pop-Location
}
