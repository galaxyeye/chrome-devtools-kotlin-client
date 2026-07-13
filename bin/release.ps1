#!/usr/bin/env pwsh
<#
.SYNOPSIS
    Release the cdt-kotlin-client-serialization module to Maven Central.

.DESCRIPTION
    1. Checks the latest released version on Maven Central.
    2. Validates that the local SNAPSHOT version is the next patch release.
    3. Removes the -SNAPSHOT suffix to create the release version.
    4. Runs Maven deploy with the release profile.
#>

$ErrorActionPreference = "Stop"

$repoRoot = (git rev-parse --show-toplevel 2>$null)
if (-not $repoRoot) {
    Write-Host "ERROR: Not in a git repository." -ForegroundColor Red
    exit 1
}
Set-Location $repoRoot

# ------------------------------------------------------------------
# Configuration
# ------------------------------------------------------------------
$groupId    = "ai.platon.cdt"
$artifactId = "cdt-kotlin-client-serialization"
$moduleDir  = Join-Path $repoRoot $artifactId
$pomPath    = Join-Path $moduleDir "pom.xml"

if (-not (Test-Path $pomPath)) {
    Write-Host "ERROR: pom.xml not found at $pomPath" -ForegroundColor Red
    exit 1
}

# ------------------------------------------------------------------
# 1. Read the local SNAPSHOT version
# ------------------------------------------------------------------
[xml]$pom = Get-Content $pomPath
$snapshotVersion = $pom.project.version

if ($snapshotVersion -notlike "*-SNAPSHOT") {
    Write-Host "ERROR: Version '$snapshotVersion' is not a SNAPSHOT. Already released?" -ForegroundColor Red
    exit 1
}

$releaseVersion = $snapshotVersion -replace "-SNAPSHOT$", ""

Write-Host "Local SNAPSHOT version : $snapshotVersion" -ForegroundColor Cyan
Write-Host "Target release version  : $releaseVersion" -ForegroundColor Cyan

# ------------------------------------------------------------------
# 2. Check the latest released version on Maven Central
# ------------------------------------------------------------------
$groupPath  = $groupId -replace '\.', '/'
$metadataUrl = "https://repo1.maven.org/maven2/$groupPath/$artifactId/maven-metadata.xml"

Write-Host "`nFetching latest released version from Maven Central..." -ForegroundColor Cyan
Write-Host "  $metadataUrl" -ForegroundColor Gray

$latestVersion = $null
try {
    $response = Invoke-WebRequest -Uri $metadataUrl -UseBasicParsing -TimeoutSec 30
    if ($response.StatusCode -eq 200) {
        [xml]$metadata = $response.Content
        $latestVersion = $metadata.metadata.versioning.latest
        Write-Host "Latest released version  : $latestVersion" -ForegroundColor Green
    } else {
        Write-Warning "Unexpected response status: $($response.StatusCode)"
    }
} catch {
    if ($_.Exception.Response.StatusCode -eq 404) {
        Write-Host "No existing releases found on Maven Central (HTTP 404). This may be the first release." -ForegroundColor Yellow
    } else {
        Write-Warning "Could not fetch version metadata from Maven Central: $_"
        Write-Warning "Skipping version verification. Proceeding with release version: $releaseVersion"
    }
}

# ------------------------------------------------------------------
# 3. Validate that the local version is the next patch after latest
# ------------------------------------------------------------------
if ($latestVersion) {
    # Parse versions into numeric components (ignore pre-release suffixes like -alpha, -beta, etc.)
    function Parse-Version($v) {
        $clean = $v -replace '-.*$', ''  # strip any pre-release suffix
        return [int[]]($clean -split '\.')
    }

    $latestParts  = Parse-Version $latestVersion
    $releaseParts = Parse-Version $releaseVersion

    if ($latestParts.Count -lt 2 -or $releaseParts.Count -lt 2) {
        Write-Warning "Could not parse version numbers properly. Skipping version check."
    } else {
        # Compute the expected next-patch version (increment the last component of latest)
        $expectedParts = @($latestParts[0..($latestParts.Count - 2)]) + @($latestParts[-1] + 1)
        $expectedNextPatch = $expectedParts -join '.'

        if ($releaseVersion -ne $expectedNextPatch) {
            Write-Host ""
            Write-Warning "Version mismatch detected!"
            Write-Host "  Latest released version : $latestVersion"
            Write-Host "  Expected next patch     : $expectedNextPatch"
            Write-Host "  Local release version   : $releaseVersion"
            Write-Host ""

            $response = Read-Host "Continue with version '$releaseVersion' anyway? (y/N)"
            if ($response -notin @('y', 'Y')) {
                Write-Host "Aborted by user." -ForegroundColor Yellow
                exit 0
            }
            Write-Host "Proceeding with version $releaseVersion per user confirmation." -ForegroundColor Yellow
        } else {
            Write-Host "Version check passed: $releaseVersion is the next patch after $latestVersion" -ForegroundColor Green
        }
    }
}

# ------------------------------------------------------------------
# 4. Confirm before proceeding
# ------------------------------------------------------------------
Write-Host ""
Write-Host "========================================" -ForegroundColor Cyan
Write-Host "  RELEASE SUMMARY" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host "  Group ID    : $groupId"
Write-Host "  Artifact ID : $artifactId"
Write-Host "  Release ver : $releaseVersion" -ForegroundColor Yellow
if ($latestVersion) {
    Write-Host "  Latest Maven: $latestVersion"
}
Write-Host "========================================" -ForegroundColor Cyan

$confirm = Read-Host "Proceed with release? (y/N)"
if ($confirm -notin @('y', 'Y')) {
    Write-Host "Aborted by user." -ForegroundColor Yellow
    exit 0
}

# ------------------------------------------------------------------
# 5. Remove -SNAPSHOT suffix to create release version
# ------------------------------------------------------------------
Write-Host "`nRemoving -SNAPSHOT suffix from $pomPath ..." -ForegroundColor Cyan

$pomContent = Get-Content $pomPath -Raw
$pomContent = $pomContent -replace [regex]::Escape($snapshotVersion), $releaseVersion
Set-Content -Path $pomPath -Value $pomContent -NoNewline

Write-Host "Updated $artifactId/pom.xml : $snapshotVersion -> $releaseVersion" -ForegroundColor Green

# ------------------------------------------------------------------
# 6. Run Maven release
# ------------------------------------------------------------------
Write-Host "`nRunning Maven release (clean deploy) ..." -ForegroundColor Cyan

try {
    .\mvnw -Prelease clean deploy -DskipTests -pl $artifactId -am
    if ($LASTEXITCODE -ne 0) {
        throw "Maven exited with code $LASTEXITCODE"
    }
    Write-Host "`nRelease $releaseVersion deployed successfully to Maven Central!" -ForegroundColor Green
} catch {
    Write-Host "`nMaven release failed: $_" -ForegroundColor Red
    Write-Host "Restoring SNAPSHOT version in pom.xml ..." -ForegroundColor Yellow

    $pomContent = Get-Content $pomPath -Raw
    $pomContent = $pomContent -replace [regex]::Escape($releaseVersion), $snapshotVersion
    Set-Content -Path $pomPath -Value $pomContent -NoNewline

    Write-Host "Restored $artifactId/pom.xml to $snapshotVersion" -ForegroundColor Yellow
    exit 1
}

# ------------------------------------------------------------------
# 7. Post-release reminder
# ------------------------------------------------------------------
Write-Host "`nNext steps:" -ForegroundColor Cyan
Write-Host "  1. Update $artifactId/pom.xml to the next development SNAPSHOT version"
Write-Host "  2. Commit and tag the release: git commit -am 'Release $releaseVersion' && git tag v$releaseVersion"
Write-Host "  3. Push: git push --follow-tags"
