#!/usr/bin/env pwsh

$repoRoot = (git rev-parse --show-toplevel 2>$null)
Set-Location $repoRoot

$pomPath = Join-Path $repoRoot "cdt-kotlin-client\pom.xml"
[xml]$pom = Get-Content $pomPath
$version = $pom.project.version
if ($version -like "*-SNAPSHOT") {
    Write-Host "Version $version is a snapshot version. Please update the version in cdt-kotlin-client/pom.xml to a release version before running this script."
    exit 1
}

.\mvnw -Prelease clean deploy -DskipTests -pl cdt-kotlin-client -am
