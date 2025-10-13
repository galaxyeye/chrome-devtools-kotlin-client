function printUsage {
  Write-Host "Usage: deploy [-clean|-test]"
  exit 1
}

if ($args.Length -gt 0) {
  printUsage
}

$User = "vincent"
$TargetHost = "platonic.fun"

$SKIP_TEST =$true
$CLEAN =$false

while ($args.Length -gt 0) {
  switch ($args[0]) {
    "-clean" {
      $CLEAN =$true
      $args =$args[1..($args.Length-1)] # past argument
    }
    "-skipTest" {
      $SKIP_TEST =$true
      $args =$args[1..($args.Length-1)] # past argument
    }
    { $_ -in "-h", "-help", "--help" } {
      printUsage
    }
    { $_ -in "-*", "--*" } {
      printUsage
    }
    default {
      printUsage
    }
  }
}

# Find the first parent directory containing the VERSION file
$AppHome=(Get-Item -Path $MyInvocation.MyCommand.Path).Directory
while ($AppHome -ne $null -and !(Test-Path "$AppHome/VERSION")) {
  $AppHome=$AppHome.Parent
}
cd $AppHome

# Maven command and options
$MvnCmd = Join-Path $AppHome '.\mvnw.cmd'

Write-Host "Deploy the project ..."
Write-Host "Changing version ..."

$SNAPSHOT_VERSION = Get-Content "$AppHome\VERSION" -TotalCount 1
$VERSION =$SNAPSHOT_VERSION -replace "-SNAPSHOT", ""
$VERSION | Set-Content "$AppHome\VERSION"

Get-ChildItem -Path "$AppHome" -Depth 2 -Filter 'pom.xml' -Recurse | ForEach-Object {
  (Get-Content $_.FullName) -replace $SNAPSHOT_VERSION, $VERSION | Set-Content $_.FullName
}

if ($CLEAN) {
  & $MvnCmd clean
  if ($LastExitCode -ne 0) {
    exit $LastExitCode
  }
}

if ($SKIP_TEST) {
  & $MvnCmd deploy -Pplaton-deploy -DskipTests=true -DaltDeploymentRepository=local::default::file:./target/staging-deploy
} else {
  & $MvnCmd deploy -Pplaton-release -Pplaton-deploy -DaltDeploymentRepository=local::default::file:./target/staging-deploy
}

$exitCode =$LastExitCode
if ($exitCode -eq 0) {
  Write-Host "Build successfully"
} else {
  exit $exitCode
}

# Finde source code jar in ./target/staging-deploy/ recursively and remove them
Get-ChildItem -Path "$AppHome\target\staging-deploy" -Filter '*-sources.jar' -Recurse | ForEach-Object {
  Remove-Item $_.FullName
}

scp -r ./target/staging-deploy/* "$User@${TargetHost}:~/platonic.fun/repo"

Write-Host "Artifacts are staged remotely."
Write-Host "Hit the following link to check if the artifacts are synchronized to the server: "
Write-Host "https://static.platonai.cn/repo/"
