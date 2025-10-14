#!/usr/bin/env bash
set -euo pipefail

BASE_PACKAGE="ai.platon.cdt.kt.protocol"
OUTPUT_PROJECT="cdt-kotlin-client"
JS_PROTOCOL="js_protocol.json"
BROWSER_PROTOCOL="browser_protocol.json"
LANGUAGE="kotlin"
SKIP_BUILD="false"

usage() {
  cat <<'EOF'
Usage: generate-kotlin.sh [options]

Options:
  --base-package <package>     Base package for generated sources (default: ai.platon.cdt.protocol)
  --output <dir>               Target project directory (default: cdt-kotlin-client)
  --js-protocol <file>         Path to js_protocol.json (default: js_protocol.json)
  --browser-protocol <file>    Path to browser_protocol.json (default: browser_protocol.json)
  --language <java|kotlin>     Generation language (default: kotlin)
  --skip-build                 Skip building the protocol builder before running
  -h, --help                   Show this help message

Environment variables can also override the defaults:
  BASE_PACKAGE, OUTPUT_PROJECT, JS_PROTOCOL, BROWSER_PROTOCOL, LANGUAGE, SKIP_BUILD
EOF
}

# Allow environment variables to override defaults
BASE_PACKAGE="${BASE_PACKAGE:-$BASE_PACKAGE}"
OUTPUT_PROJECT="${OUTPUT_PROJECT:-$OUTPUT_PROJECT}"
JS_PROTOCOL="${JS_PROTOCOL:-$JS_PROTOCOL}"
BROWSER_PROTOCOL="${BROWSER_PROTOCOL:-$BROWSER_PROTOCOL}"
LANGUAGE="${LANGUAGE:-$LANGUAGE}"
SKIP_BUILD="${SKIP_BUILD:-$SKIP_BUILD}"

while [[ $# -gt 0 ]]; do
  case "$1" in
    --base-package)
      BASE_PACKAGE="$2"
      shift 2
      ;;
    --output)
      OUTPUT_PROJECT="$2"
      shift 2
      ;;
    --js-protocol)
      JS_PROTOCOL="$2"
      shift 2
      ;;
    --browser-protocol)
      BROWSER_PROTOCOL="$2"
      shift 2
      ;;
    --language)
      LANGUAGE="$2"
      shift 2
      ;;
    --skip-build)
      SKIP_BUILD="true"
      shift 1
      ;;
    -h|--help)
      usage
      exit 0
      ;;
    *)
      echo "Unknown option: $1" >&2
      usage
      exit 1
      ;;
  esac
done

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
PROJECT_ROOT="$SCRIPT_DIR"
while [[ ! -f "$PROJECT_ROOT/pom.xml" ]]; do
  PARENT_DIR="$(dirname "$PROJECT_ROOT")"
  if [[ "$PARENT_DIR" == "$PROJECT_ROOT" ]]; then
    echo "Unable to locate project root (missing pom.xml)." >&2
    exit 1
  fi
  PROJECT_ROOT="$PARENT_DIR"
done

pushd "$PROJECT_ROOT" > /dev/null

MVNW="./mvnw"
if [[ ! -x "$MVNW" ]]; then
  chmod +x "$MVNW"
fi

BUILDER_DIR="$PROJECT_ROOT/cdt-kotlin-protocol-builder"
JAR_PATH="$BUILDER_DIR/target/cdt-kotlin-protocol-builder.jar"

if [[ "$SKIP_BUILD" != "true" ]]; then
  echo "Building cdt-kotlin-protocol-builder..."
  "$MVNW" -pl cdt-kotlin-protocol-builder -am package
fi

if [[ ! -f "$JAR_PATH" ]]; then
  echo "Builder jar not found at $JAR_PATH. Run without --skip-build." >&2
  exit 1
fi

to_absolute() {
  case "$1" in
    /*) echo "$1" ;;
    *) echo "$PROJECT_ROOT/$1" ;;
  esac
}

JS_PATH="$(to_absolute "$JS_PROTOCOL")"
BROWSER_PATH="$(to_absolute "$BROWSER_PROTOCOL")"
OUTPUT_PATH="$(to_absolute "$OUTPUT_PROJECT")"

for path in "$JS_PATH" "$BROWSER_PATH"; do
  if [[ ! -f "$path" ]]; then
    echo "Required protocol file not found: $path" >&2
    exit 1
  fi
done

mkdir -p "$OUTPUT_PATH"

case "$LANGUAGE" in
  java|kotlin) ;;
  *)
    echo "Unsupported language '$LANGUAGE'. Expected java or kotlin." >&2
    exit 1
    ;;
esac

JAVA_BIN="${JAVA_HOME:+$JAVA_HOME/bin/}java"
JAVA_BIN="${JAVA_BIN:-java}"

if ! command -v "$JAVA_BIN" >/dev/null 2>&1; then
  echo "Java runtime not found. Set JAVA_HOME or add java to PATH." >&2
  exit 1
fi

echo "Running Kotlin protocol generator..."
"$JAVA_BIN" -jar "$JAR_PATH" \
  --base-package "$BASE_PACKAGE" \
  --js-protocol "$JS_PATH" \
  --browser-protocol "$BROWSER_PATH" \
  --output "$OUTPUT_PATH" \
  --language "$LANGUAGE"

echo "Kotlin sources generated in $OUTPUT_PATH"

popd > /dev/null
