#!/bin/bash

# Determine the project root directory by locating the nearest pom.xml
app_home=$(git rev-parse --show-toplevel 2>/dev/null || { echo "Not in a Git repository or unable to determine project root."; exit 1; })
cd "$app_home" || { echo "Unable to determine project root."; exit 1; }

echo "Starting deployment process ..."

# Read the snapshot version from VERSION file and remove '-SNAPSHOT' to get release version
snapshot_version=$(head -n 1 "$app_home/VERSION")
release_version=${snapshot_version%-SNAPSHOT}
echo "$release_version" > "$app_home/VERSION"

# Update all pom.xml files to use the release version
find "$app_home" -name 'pom.xml' -exec sed -i.bak "s/$snapshot_version/$release_version/g" {} +

# Extract Pulsar version from pom.xml, removing '-SNAPSHOT'
pulsar_version=$(grep -oP '(?<=<pulsar\.version>)[^<]+(?=-SNAPSHOT</pulsar\.version>)' "$app_home/pom.xml")
sed -i.bak "s/<pulsar\.version>$pulsar_version-SNAPSHOT<\/pulsar\.version>/<pulsar\.version>$pulsar_version<\/pulsar\.version>/" "$app_home/pom.xml"

# Execute Maven commands for cleaning and deploying
mvn clean
mvn deploy -Pplaton-deploy -DskipTests -DaltDeploymentRepository=local::default::file:./target/staging-deploy

# Securely copy deployment artifacts to remote server
scp -r ./target/staging-deploy/* master:~/platonic.fun/repo && echo "Artifacts copied to remote server." || echo "Failed to copy artifacts."
