#!/usr/bin/env pwsh

$ghCopilotHelper = Join-Path $PSScriptRoot "gh-copilot.ps1"
. $ghCopilotHelper
$repoRoot = Get-WorkspaceRoot
$copilotCommand = Get-GHCopilotCommand -RepoRoot $repoRoot

$prompt = @"
Commit all changes in "$repoRoot".
Pull from remote.
Then push to remote.
If conflicts occur, resolve them automatically.
"@

$copilotArguments = New-GHCopilotArguments -BaseArgs $copilotCommand.BaseArgs -Prompt $prompt -AdditionalArguments @('--allow-all-tools')

Write-Host "Running:"
Write-Host (Format-GHCopilotCommand -Executable $copilotCommand.Executable -Arguments $copilotArguments)

Invoke-GHCopilot -Prompt $prompt -AdditionalArguments @('--allow-all-tools') -RepoRoot $repoRoot -WorkingDirectory $repoRoot
exit $LASTEXITCODE
