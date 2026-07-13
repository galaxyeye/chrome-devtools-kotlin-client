#!/usr/bin/env pwsh

# ═══════════════════════════════════════════════════════════════════
# CROSS-PLATFORM: This script must run on Linux, macOS, and Windows.
# - Use $IsWindows / $IsLinux / $IsMacOS for platform detection.
# - Use "($IsWindows -or $env:OS -eq 'Windows_NT')" for PS 5.1 compat.
# - Windows-only env vars ($env:TEMP) need $env:TMPDIR fallback.
# - Guard "chcp" and other Windows-only commands behind platform checks.
# ═══════════════════════════════════════════════════════════════════
<#
.SYNOPSIS
    Checks if the current project version has been fully published.

.DESCRIPTION
    Compares the local version against the latest GitHub release and determines
    whether it is ready to publish:

      - [OK] Local version IS the latest release — already published.
      - [GO] Local version is the next patch/minor/major — ready to publish.
      - [XX] Local version is BEHIND the latest release — something is wrong.

    Provides detailed information about the latest release, including publish
    date, author, release URL, and asset list.

    Exits with code 0 if the project version is published or is the natural
    next version in sequence, non-zero otherwise.

.PARAMETER Version
    The version to check (without the -SNAPSHOT suffix).
    If omitted, reads the version from the VERSION file in the repo root.

.EXAMPLE
    .\check-publish-status.ps1
    Checks the version from the VERSION file.

.EXAMPLE
    .\check-publish-status.ps1 -Version 4.8.4
    Checks version 4.8.4 explicitly.
#>
[CmdletBinding()]
param (
    [Parameter(HelpMessage = "The version to check (without -SNAPSHOT)")]
    [string]$Version
)

$ErrorActionPreference = "Stop"

# Force UTF-8 output encoding for correct display of special characters
[Console]::OutputEncoding = [System.Text.Encoding]::UTF8

# Determine repo root
$repoRoot = (git rev-parse --show-toplevel 2>$null)
if ($null -eq $repoRoot) {
    Write-Error "Could not determine project root. Are you in a git repository?"
    exit 2
}
Set-Location $repoRoot

# Resolve the version
if (-not $Version) {
    if (-not (Test-Path "$repoRoot\VERSION")) {
        Write-Error "VERSION file not found at $repoRoot\VERSION and no -Version argument was provided."
        exit 2
    }
    $snapshotVersion = (Get-Content "$repoRoot\VERSION" -TotalCount 1).Trim()
    $Version = $snapshotVersion -replace "-SNAPSHOT", ""
}

# Validate version format
if ($Version -notmatch "^\d+\.\d+\.\d+") {
    Write-Error "Version '$Version' does not match the expected format X.Y.Z"
    exit 2
}

Write-Host ""
Write-Host "══════════════════════════════════════════════" -ForegroundColor Cyan
Write-Host "  Release Status Check"                       -ForegroundColor Cyan
Write-Host "══════════════════════════════════════════════" -ForegroundColor Cyan

# Derive GitHub repository from the git remote
$remoteUrl = git config --get remote.origin.url
if ($remoteUrl -notmatch 'github\.com[:/](.+?)(?:\.git)?$') {
    Write-Error "Could not determine GitHub repository from remote URL: $remoteUrl"
    exit 2
}
$githubRepo = $matches[1]
Write-Host "  GitHub repository : $githubRepo"
Write-Host "  Current version   : v$Version"
Write-Host ""

# ---------------------------------------------------------------
# Helper: Fetch latest release from GitHub using gh
# ---------------------------------------------------------------
function Get-GitHubLatestRelease {
    param(
        [string]$GitHubRepo,
        [string]$ReleaseTagPattern = "*"
    )

    $result = @{
        Tag         = $null
        Name        = $null
        PublishedAt = $null
        Author      = $null
        HtmlUrl     = $null
        IsPrerelease = $false
        IsDraft     = $false
        Body        = $null
        AssetCount  = 0
        AssetNames  = @()
    }

    $ghAvailable = $null -ne (Get-Command gh -ErrorAction SilentlyContinue)

    if ($ghAvailable) {
        try {
            # Fetch the latest release matching the pattern
            if ($ReleaseTagPattern -eq "*") {
                $releases = & gh release list --repo $GitHubRepo --limit 1 --json tagName,name,publishedAt,author,url,isPrerelease,isDraft,body,assets 2>&1
            } else {
                # gh release list doesn't support tag filtering, so fetch more and filter
                $releases = & gh release list --repo $GitHubRepo --limit 50 --json tagName,name,publishedAt,author,url,isPrerelease,isDraft,body,assets 2>&1
            }

            if ($LASTEXITCODE -eq 0 -and $releases) {
                $allReleases = $releases | ConvertFrom-Json

                if ($ReleaseTagPattern -ne "*") {
                    # Filter releases matching the tag pattern
                    $wildcard = [System.Management.Automation.WildcardPattern]::new($ReleaseTagPattern, [System.Management.Automation.WildcardOptions]::IgnoreCase)
                    $allReleases = @($allReleases | Where-Object { $wildcard.IsMatch($_.tagName) })
                }

                if ($allReleases -and $allReleases.Count -gt 0) {
                    $latest = $allReleases[0]
                    $result.Tag         = $latest.tagName
                    $result.Name        = $latest.name
                    $result.PublishedAt = $latest.publishedAt
                    $result.Author      = $latest.author.login
                    $result.HtmlUrl     = $latest.url
                    $result.IsPrerelease = $latest.isPrerelease
                    $result.IsDraft     = $latest.isDraft
                    $result.Body        = $latest.body
                    $result.AssetCount  = $latest.assets.Count
                    $result.AssetNames  = @($latest.assets | ForEach-Object { $_.name })
                }
            }
        } catch {
            # Fall through to API method
        }
    }

    # Fallback: GitHub API
    if ($null -eq $result.Tag) {
        try {
            $apiUrl = "https://api.github.com/repos/$GitHubRepo/releases?per_page=50"
            $releases = Invoke-RestMethod -Uri $apiUrl -Method Get -Headers @{
                Accept = "application/vnd.github+json"
            } -ErrorAction SilentlyContinue

            if ($releases) {
                if ($ReleaseTagPattern -ne "*") {
                    $wildcard = [System.Management.Automation.WildcardPattern]::new($ReleaseTagPattern, [System.Management.Automation.WildcardOptions]::IgnoreCase)
                    $releases = @($releases | Where-Object { $wildcard.IsMatch($_.tag_name) })
                }

                if ($releases.Count -gt 0) {
                    $latest = $releases[0]
                    $result.Tag         = $latest.tag_name
                    $result.Name        = $latest.name
                    $result.PublishedAt = $latest.published_at
                    $result.Author      = $latest.author.login
                    $result.HtmlUrl     = $latest.html_url
                    $result.IsPrerelease = $latest.prerelease
                    $result.IsDraft     = $latest.draft
                    $result.Body        = $latest.body
                    $result.AssetCount  = $latest.assets.Count
                    $result.AssetNames  = @($latest.assets | ForEach-Object { $_.name })
                }
            }
        } catch {
            # Fall through to git fallback
        }
    }

    # Second fallback: git tags
    if ($null -eq $result.Tag) {
        if ($ReleaseTagPattern -eq "*") {
            $latestTag = git ls-remote --tags --sort=-version:refname origin 2>$null `
                | Select-Object -First 1 `
                | ForEach-Object { $_ -match 'refs/tags/(v\d+\.\d+\.\d+)$' | Out-Null; $matches[1] }
        } else {
            # Convert wildcard to grep pattern
            $grepPattern = $ReleaseTagPattern -replace '\*', '.*'
            $latestTag = git ls-remote --tags --sort=-version:refname origin 2>$null `
                | ForEach-Object { if ($_ -match "refs/tags/($grepPattern)") { $matches[1] } } `
                | Select-Object -First 1
        }
        if ($latestTag) {
            $result.Tag = $latestTag
        }
    }

    return $result
}

# ---------------------------------------------------------------
# Helper: Determine version relationship (same / next-patch / next-minor / behind / ahead)
# ---------------------------------------------------------------
function Test-NextVersion {
    param(
        [string]$LatestVersion,
        [string]$LocalVersion
    )

    # Returns: 'same', 'next-patch', 'next-minor', 'next-major', 'ahead', 'behind', 'unknown'

    try {
        $latest = [version](($LatestVersion -replace '^v', '') -replace '^(\d+\.\d+\.\d+).*', '$1')
        $local  = [version](($LocalVersion  -replace '^v', '') -replace '^(\d+\.\d+\.\d+).*', '$1')

        if ($local -eq $latest) { return 'same' }
        if ($local -lt $latest) { return 'behind' }

        # Local is ahead — is it the natural next step?
        if ($local.Major -eq $latest.Major -and
            $local.Minor -eq $latest.Minor -and
            $local.Build -eq $latest.Build + 1) {
            return 'next-patch'
        }
        if ($local.Major -eq $latest.Major -and
            $local.Minor -eq $latest.Minor + 1 -and
            $local.Build -eq 0) {
            return 'next-minor'
        }
        if ($local.Major -eq $latest.Major + 1 -and
            $local.Minor -eq 0 -and
            $local.Build -eq 0) {
            return 'next-major'
        }

        return 'ahead'
    } catch {
        return 'unknown'
    }
}

# ---------------------------------------------------------------
# Release status check
# ---------------------------------------------------------------
Write-Host "────────────────────────────────────────────────" -ForegroundColor Yellow
Write-Host "  Release Status"                               -ForegroundColor Yellow
Write-Host "────────────────────────────────────────────────" -ForegroundColor Yellow
Write-Host ""

$isLatestRelease = $false
$latestReleaseInfo = $null

Write-Host "Fetching latest GitHub release for $githubRepo ..."
$latestReleaseInfo = Get-GitHubLatestRelease -GitHubRepo $githubRepo

if ($null -ne $latestReleaseInfo.Tag) {
    Write-Host ""
    Write-Host "  ── Latest GitHub Release ──"
    Write-Host "  Tag          : $($latestReleaseInfo.Tag)"

    if ($latestReleaseInfo.Name) {
        Write-Host "  Title        : $($latestReleaseInfo.Name)"
    }

    if ($latestReleaseInfo.PublishedAt) {
        Write-Host "  Published    : $($latestReleaseInfo.PublishedAt)"
    }

    if ($latestReleaseInfo.Author) {
        Write-Host "  Author       : @$($latestReleaseInfo.Author)"
    }

    if ($latestReleaseInfo.HtmlUrl) {
        Write-Host "  URL          : $($latestReleaseInfo.HtmlUrl)"
    }

    # Flags
    $flags = @()
    if ($latestReleaseInfo.IsPrerelease) { $flags += "PRE-RELEASE" }
    if ($latestReleaseInfo.IsDraft)     { $flags += "DRAFT" }
    if ($flags.Count -gt 0) {
        Write-Host "  Flags        : $($flags -join ', ')" -ForegroundColor Yellow
    }

    # Assets
    Write-Host "  Assets       : $($latestReleaseInfo.AssetCount)"
    if ($latestReleaseInfo.AssetCount -gt 0) {
        $maxAssetsToShow = 8
        $shown = 0
        foreach ($asset in $latestReleaseInfo.AssetNames) {
            if ($shown -ge $maxAssetsToShow) {
                $remaining = $latestReleaseInfo.AssetCount - $maxAssetsToShow
                Write-Host "                 ... and $remaining more"
                break
            }
            Write-Host "                 - $asset"
            $shown++
        }
    }

    # Release body summary (first few lines)
    if ($latestReleaseInfo.Body) {
        $bodyLines = $latestReleaseInfo.Body -split "`n" | Where-Object { $_.Trim() -ne "" } | Select-Object -First 5
        if ($bodyLines.Count -gt 0) {
            Write-Host "  Notes        :"
            foreach ($line in $bodyLines) {
                $trimmed = $line.Trim()
                if ($trimmed.Length -gt 100) { $trimmed = $trimmed.Substring(0, 97) + "..." }
                Write-Host "                 $trimmed"
            }
        }
    }

    Write-Host ""
    Write-Host "  Local version : v$Version"
    Write-Host "  Latest release: $($latestReleaseInfo.Tag)"

    $versionStatus = Test-NextVersion -LatestVersion $latestReleaseInfo.Tag -LocalVersion "v$Version"

    switch ($versionStatus) {
        'same' {
            $isLatestRelease = $true
            Write-Host "  [OK] Local version IS the latest GitHub release (already published)." -ForegroundColor Green
        }
        'next-patch' {
            $isLatestRelease = $true
            Write-Host "  [GO] Local version is the next PATCH release — ready to publish!" -ForegroundColor Green
        }
        'next-minor' {
            $isLatestRelease = $true
            Write-Host "  [GO] Local version is the next MINOR release — ready to publish!" -ForegroundColor Green
        }
        'next-major' {
            $isLatestRelease = $true
            Write-Host "  [GO] Local version is the next MAJOR release — ready to publish!" -ForegroundColor Green
        }
        'behind' {
            $isLatestRelease = $false
            Write-Host "  [XX] Local version is BEHIND the latest release!" -ForegroundColor Red

            # Show how far behind
            try {
                $currentTag = "v$Version"
                $latestTag = $latestReleaseInfo.Tag
                $allTags = git ls-remote --tags --sort=-version:refname origin 2>$null `
                    | ForEach-Object { if ($_ -match 'refs/tags/(v\d+\.\d+\.\d+)$') { $matches[1] } } `
                    | Where-Object { $_ }

                if ($allTags) {
                    $currentIndex = [array]::IndexOf($allTags, $currentTag)
                    $latestIndex  = [array]::IndexOf($allTags, $latestTag)

                    if ($currentIndex -ge 0 -and $latestIndex -ge 0) {
                        $behind = $latestIndex - $currentIndex
                        if ($behind -lt 0) { $behind = $currentIndex - $latestIndex }
                        if ($behind -gt 0) {
                            Write-Host "  Releases behind: $behind release(s)" -ForegroundColor Yellow

                            if ($behind -le 10) {
                                Write-Host "  Recent releases:"
                                $startIdx = [Math]::Min($currentIndex, $latestIndex)
                                $endIdx   = [Math]::Max($currentIndex, $latestIndex)
                                for ($i = $startIdx; $i -le $endIdx; $i++) {
                                    $marker = if ($allTags[$i] -eq $currentTag) { " <= current" } else { "" }
                                    Write-Host "    - $($allTags[$i])$marker"
                                }
                            } else {
                                Write-Host "  Recent releases (last 5):"
                                for ($i = 0; $i -lt [Math]::Min(5, $allTags.Count); $i++) {
                                    $marker = if ($allTags[$i] -eq $currentTag) { " <= current" } else { "" }
                                    Write-Host "    - $($allTags[$i])$marker"
                                }
                            }
                        }
                    }
                }
            } catch {
                # Non-critical: just skip the behind count
            }
        }
        'ahead' {
            $isLatestRelease = $true
            Write-Host "  [!!] Local version is AHEAD of latest release by more than one step." -ForegroundColor Yellow
        }
        default {
            $isLatestRelease = $false
            Write-Host "  [!!] Could not determine version relationship." -ForegroundColor Yellow
        }
    }
} else {
    Write-Host "  [XX] No GitHub releases found for $githubRepo." -ForegroundColor Red
    Write-Host "  This may indicate no releases have been created yet."
}

# ---------------------------------------------------------------
# Summary
# ---------------------------------------------------------------
Write-Host ""
Write-Host "══════════════════════════════════════════════" -ForegroundColor Cyan
Write-Host "  Summary"                                    -ForegroundColor Cyan
Write-Host "══════════════════════════════════════════════" -ForegroundColor Cyan
Write-Host ""

Write-Host "  Local version    : v$Version"
Write-Host "  Latest release   : $($latestReleaseInfo.Tag)"
Write-Host "  Status           : $(
    switch ($versionStatus) {
        'same'        { '[OK] Already published' }
        'next-patch'  { '[GO] Next patch — can publish' }
        'next-minor'  { '[GO] Next minor — can publish' }
        'next-major'  { '[GO] Next major — can publish' }
        'behind'      { '[XX] BEHIND latest release' }
        'ahead'       { '[!!] Ahead (not next in sequence)' }
        default       { '[??] Unknown' }
    }
)"
Write-Host ""

if ($isLatestRelease) {
    Write-Host "Version v$Version is ready (published or next in sequence)." -ForegroundColor Green
    exit 0
} else {
    Write-Host "Version v$Version is BEHIND the latest release — not safe to bump." -ForegroundColor Red
    exit 1
}
