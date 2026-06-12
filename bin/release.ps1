#!/usr/bin/env pwsh

$repoRoot = (git rev-parse --show-toplevel 2>$null)
Set-Location $repoRoot

.\mvnw -Prelease clean deploy -DskipTests -pl cdt-kotlin-client -am
