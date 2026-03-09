#!/usr/bin/env pwsh

Set-Location cdt-kotlin-client
.\mvnw -Prelease clean deploy -DskipTests
