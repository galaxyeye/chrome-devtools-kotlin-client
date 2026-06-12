#!/usr/bin/env pwsh
<#
.SYNOPSIS
    Release script for Chrome DevTools Kotlin client.
    Strips the -SNAPSHOT suffix, deploys cdt-kotlin-client to Maven Central, then bumps to the next SNAPSHOT version.

.DESCRIPTION
    This script:
    1. Reads the current version from the VERSION file
    2. Strips the -SNAPSHOT suffix for the release
    3. Updates cdt-kotlin-client/pom.xml and the VERSION file to the release version
    4. Commits and tags the release
    5. Runs the Maven deploy (cdt-kotlin-client only)
    6. Bumps to the next patch version with -SNAPSHOT
    7. Commits the new snapshot version

.PARAMETER DryRun
    If set, the script will print what it would do without making any changes.

.PARAMETER SkipTests
    If set, tests are skipped during the deploy (default: $true).

.EXAMPLE
    .\bin\release.ps1
    .\bin\release.ps1 -DryRun
#>

param(
    [switch] $DryRun,
    [switch] $SkipTests = $true
)

$ErrorActionPreference = "Stop"

$repoRoot = (git rev-parse --show-toplevel 2>$null)
if (-not $repoRoot) {
    Write-Error "Not inside a git repository."
    exit 1
}
Set-Location $repoRoot

# -------------------------------------------------------------------
# Helper functions
# -------------------------------------------------------------------

function Write-Step {
    param([string] $Message)
    Write-Host ""
    Write-Host "============================================================" -ForegroundColor Cyan
    Write-Host "  $Message" -ForegroundColor Cyan
    Write-Host "============================================================" -ForegroundColor Cyan
}

function Get-CurrentVersion {
    $versionFile = Join-Path $repoRoot "VERSION"
    if (-not (Test-Path $versionFile)) {
        Write-Error "VERSION file not found at $versionFile"
        exit 1
    }
    $version = (Get-Content $versionFile).Trim()
    if (-not $version) {
        Write-Error "VERSION file is empty."
        exit 1
    }
    return $version
}

function Update-PomVersion {
    param(
        [string] $OldVersion,
        [string] $NewVersion
    )
    $pom = Join-Path $repoRoot "cdt-kotlin-client" "pom.xml"
    if (-not (Test-Path $pom)) {
        Write-Error "POM file not found: $pom"
        exit 1
    }
    Write-Host "  Updating cdt-kotlin-client/pom.xml : $OldVersion -> $NewVersion"
    if (-not $DryRun) {
        $content = Get-Content $pom -Raw
        $updated = $content -replace "<version>$([regex]::Escape($OldVersion))</version>", "<version>$NewVersion</version>"
        Set-Content -Path $pom -Value $updated -NoNewline
    }
}

function Update-VersionFile {
    param(
        [string] $Version
    )
    Write-Host "  Updating VERSION: $Version"
    if (-not $DryRun) {
        $versionFile = Join-Path $repoRoot "VERSION"
        Set-Content -Path $versionFile -Value $Version -NoNewline
    }
}

function Invoke-Git {
    param(
        [string[]] $Arguments
    )
    if ($DryRun) {
        Write-Host "  [DRY RUN] git $($Arguments -join ' ')" -ForegroundColor DarkGray
    } else {
        git @Arguments
        if ($LASTEXITCODE -ne 0) {
            Write-Error "git command failed: git $($Arguments -join ' ')"
            exit $LASTEXITCODE
        }
    }
}

function Get-NextSnapshotVersion {
    param([string] $ReleaseVersion)

    if ($ReleaseVersion -match '^(.+)\.(\d+)$') {
        $base = $Matches[1]
        $patch = [int]$Matches[2] + 1
        return "$base.$patch-SNAPSHOT"
    }

    Write-Error "Cannot parse version: $ReleaseVersion. Expected format: X.Y.Z"
    exit 1
}

# -------------------------------------------------------------------
# Main flow
# -------------------------------------------------------------------

Write-Step "Step 1: Read current version"
$currentVersion = Get-CurrentVersion
Write-Host "Current version: $currentVersion"

if ($currentVersion -notmatch '-SNAPSHOT$') {
    Write-Warning "Version '$currentVersion' does not end with -SNAPSHOT. Are you sure this is a snapshot version?"
    $answer = Read-Host "Continue anyway? (y/N)"
    if ($answer -ne 'y') { exit 0 }
    $releaseVersion = $currentVersion
} else {
    $releaseVersion = $currentVersion -replace '-SNAPSHOT$', ''
}
Write-Host "Release version: $releaseVersion"

$nextSnapshotVersion = Get-NextSnapshotVersion $releaseVersion
Write-Host "Next snapshot version: $nextSnapshotVersion"

# -------------------------------------------------------------------
Write-Step "Step 2: Ensure working tree is clean"
$status = git status --porcelain
if ($status) {
    Write-Error "Working tree is not clean. Please commit or stash changes before releasing."
    Write-Host "Uncommitted changes:"
    Write-Host $status
    exit 1
}

# -------------------------------------------------------------------
Write-Step "Step 3: Update versions to release version ($releaseVersion)"
Update-PomVersion -OldVersion $currentVersion -NewVersion $releaseVersion
Update-VersionFile -Version $releaseVersion

# -------------------------------------------------------------------
Write-Step "Step 4: Commit and tag the release"
Invoke-Git -Arguments @("add", "cdt-kotlin-client/pom.xml", "VERSION")
Invoke-Git -Arguments @("commit", "-m", "release: prepare release $releaseVersion")
Invoke-Git -Arguments @("tag", "-a", "v$releaseVersion", "-m", "Release v$releaseVersion")

# -------------------------------------------------------------------
Write-Step "Step 5: Deploy to Maven Central"
$skipTestsFlag = if ($SkipTests) { "-DskipTests" } else { "" }
Write-Host "Running: .\mvnw -Prelease clean deploy $skipTestsFlag -pl cdt-kotlin-client -am"

if (-not $DryRun) {
    .\mvnw -Prelease clean deploy -DskipTests -pl cdt-kotlin-client -am
    if ($LASTEXITCODE -ne 0) {
        Write-Error "Maven deploy failed with exit code $LASTEXITCODE"
        Write-Warning "Release commit and tag v$releaseVersion have already been created."
        Write-Warning "Fix the issue and re-run the deploy manually, then re-run steps 5-6."
        exit $LASTEXITCODE
    }
}

# -------------------------------------------------------------------
Write-Step "Step 6: Bump to next snapshot version ($nextSnapshotVersion)"
Update-PomVersion -OldVersion $releaseVersion -NewVersion $nextSnapshotVersion
Update-VersionFile -Version $nextSnapshotVersion

Invoke-Git -Arguments @("add", "cdt-kotlin-client/pom.xml", "VERSION")
Invoke-Git -Arguments @("commit", "-m", "release: prepare next development version $nextSnapshotVersion")

# -------------------------------------------------------------------
Write-Step "Release complete!"
Write-Host "Released: v$releaseVersion" -ForegroundColor Green
Write-Host "Next snapshot: $nextSnapshotVersion" -ForegroundColor Green
if (-not $DryRun) {
    Write-Host ""
    Write-Host "To push the release, run:" -ForegroundColor Yellow
    Write-Host "  git push origin HEAD" -ForegroundColor Yellow
    Write-Host "  git push origin v$releaseVersion" -ForegroundColor Yellow
}
