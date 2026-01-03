ifeq ($(OS),Windows_NT)
MVN=.\\mvnw.cmd
else
MVN=./mvnw
endif

RM=rm
JAVA=java
CP=cp
RUN_JAR=$(JAVA) -jar

PROTOCOL_PARSER_DIR=cdt-protocol-parser
CDT_PROTOCOL_BUILDER_DIR=cdt-kotlin-protocol-builder
CDT_PROTOCOL_BUILDER_JAR="$(CDT_PROTOCOL_BUILDER_DIR)/target/cdt-kotlin-protocol-builder.jar"
PROTOCOL_PARSER=cdt-protocol-parser

CDT_CLIENT_DIR=cdt-kotlin-client
CDT_CLIENT_PACKAGE=ai/platon/cdt/protocol

LANGUAGE=kotlin
ifeq ($(LANGUAGE),kotlin)
PACKAGE_NAME=ai.platon.cdt.kt.protocol
else
PACKAGE_NAME=ai.platon.cdt.protocol
endif
JS_PROTOCOL_JSON_FILE=./js_protocol.json
BROWSER_PROTOCOL_JSON_FILE=./browser_protocol.json

EXAMPLES_DIR=cdt-examples

copy-protocol-files-to-test-resources:
	@echo Copy protocol files to cdt-protocol-parser test resources dir.
	$(CP) $(JS_PROTOCOL_JSON_FILE) "./$(PROTOCOL_PARSER)/src/test/resources/js_protocol.json"
	$(CP) $(BROWSER_PROTOCOL_JSON_FILE) "./$(PROTOCOL_PARSER)/src/test/resources/browser_protocol.json"
	$(MVN) --file "$(PROTOCOL_PARSER_DIR)/" clean install

build-all-modules:
	@echo Building all modules
	$(MVN) clean package

compile-cdt-kotlin-client:
	@echo Compiling cdt-kotlin-client project...
	$(MVN) --file "$(CDT_CLIENT_DIR)/" clean compile

clean-cdt-kotlin-protocol-builder:
	@echo Cleaning cdt-kotlin-protocol-builder project...
	$(MVN) --file "$(CDT_PROTOCOL_BUILDER_DIR)/" clean

clean-cdt-kotlin-client:
	@echo Cleaning cdt-kotlin-client project...
	$(MVN) --file "$(CDT_CLIENT_DIR)/" clean

clean-previous-protocol:
	@echo Cleaning previous protocol...
	$(RM) -rf $(CDT_CLIENT_DIR)/src/main/$(LANGUAGE)/$(CDT_CLIENT_PACKAGE)/types
	$(RM) -rf $(CDT_CLIENT_DIR)/src/main/$(LANGUAGE)/$(CDT_CLIENT_PACKAGE)/events
	$(RM) -rf $(CDT_CLIENT_DIR)/src/main/$(LANGUAGE)/$(CDT_CLIENT_PACKAGE)/commands

generate-chrome-devtools-client:
	@echo Generating chrome devtools client ...
	$(RUN_JAR) $(CDT_PROTOCOL_BUILDER_JAR) --base-package="$(PACKAGE_NAME)" \
		--language=$(LANGUAGE) \
		--output=./$(CDT_CLIENT_DIR)/ \
		--js-protocol=$(JS_PROTOCOL_JSON_FILE) \
		--browser-protocol=$(BROWSER_PROTOCOL_JSON_FILE)

upgrade-protocol: copy-protocol-files-to-test-resources build-all-modules clean-previous-protocol
	@echo Upgrading protocol
	$(RUN_JAR) $(CDT_PROTOCOL_BUILDER_JAR) --base-package="$(PACKAGE_NAME)" \
		--language=$(LANGUAGE) \
		--output=./$(CDT_CLIENT_DIR)/ \
		--js-protocol=$(JS_PROTOCOL_JSON_FILE) \
		--browser-protocol=$(BROWSER_PROTOCOL_JSON_FILE)

update-protocol: upgrade-protocol
	@echo Updated protocol on cdt-kotlin-client
	$(MVN) verify

update-copyright-license-header:
	@echo Updating copyright license header
	$(MVN) clean license:update-file-header
	$(MVN) com.coveo:fmt-maven-plugin:format

sonar-analysis:
	@echo Running sonar analysis
	cd $(CDT_PROTOCOL_BUILDER_DIR)/ && make sonar-analysis
	cd $(CDT_CLIENT_DIR)/ && make sonar-analysis

verify:
	@echo Running unit tests
	$(MVN) verify

download-latest-protocol:
	@echo Downloads the latest protocol json files
	curl -o browser_protocol.json https://raw.githubusercontent.com/ChromeDevTools/devtools-protocol/master/json/browser_protocol.json
	curl -o js_protocol.json https://raw.githubusercontent.com/ChromeDevTools/devtools-protocol/master/json/js_protocol.json
