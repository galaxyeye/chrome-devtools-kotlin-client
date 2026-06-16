MVN=mvnw.cmd
define copy_file
	bash -c "cp '$(1)' '$(2)'"
endef
define remove_tree
	bash -c "rm -rf '$(1)'"
endef

JAVA=java
RUN_JAR=$(JAVA) -jar

PROTOCOL_PARSER_DIR=cdt-protocol-parser
PROTOCOL_PARSER=cdt-protocol-parser
CDT_PROTOCOL_BUILDER_DIR=cdt-kotlin-protocol-builder
CDT_PROTOCOL_BUILDER_JAR="$(CDT_PROTOCOL_BUILDER_DIR)/target/cdt-kotlin-protocol-builder.jar"

CDT_CLIENT_DIR=cdt-kotlin-client
CDT_CLIENT_PACKAGE=ai/platon/cdt/kt/protocol

CDT_SERIALIZATION_CLIENT_DIR=cdt-kotlin-client-serialization
CDT_SERIALIZATION_CLIENT_PACKAGE=ai/platon/cdt/kt/serialization/protocol

LANGUAGE=kotlin
ifeq ($(LANGUAGE),kotlin)
PACKAGE_NAME=ai.platon.cdt.kt.protocol
else
PACKAGE_NAME=ai.platon.cdt.protocol
endif
SERIALIZATION_PACKAGE_NAME=ai.platon.cdt.kt.serialization.protocol
JS_PROTOCOL_JSON_FILE=./js_protocol.json
BROWSER_PROTOCOL_JSON_FILE=./browser_protocol.json

EXAMPLES_DIR=cdt-examples

copy-protocol-files-to-test-resources:
	@echo Copy protocol files to cdt-protocol-parser test resources dir.
	$(call copy_file,$(JS_PROTOCOL_JSON_FILE),./$(PROTOCOL_PARSER)/src/test/resources/js_protocol.json)
	$(call copy_file,$(BROWSER_PROTOCOL_JSON_FILE),./$(PROTOCOL_PARSER)/src/test/resources/browser_protocol.json)
	$(MVN) --file "$(PROTOCOL_PARSER_DIR)/" clean install

build-all-modules:
	@echo Building all modules
	$(MVN) clean package -Dgpg.skip=true

compile-cdt-kotlin-client:
	@echo Compiling cdt-kotlin-client project...
	$(MVN) --file "$(CDT_CLIENT_DIR)/" clean compile

compile-cdt-kotlin-client-serialization:
	@echo Compiling cdt-kotlin-client-serialization project...
	$(MVN) --file "$(CDT_SERIALIZATION_CLIENT_DIR)/" clean compile

compile-cdt-kotlin-client-ktor-serialization:
	@echo Compiling cdt-kotlin-client-ktor-serialization project...
	$(MVN) --file cdt-kotlin-client-ktor-serialization/ clean compile

clean-cdt-kotlin-client-ktor-serialization:
	@echo Cleaning cdt-kotlin-client-ktor-serialization project...
	$(MVN) --file cdt-kotlin-client-ktor-serialization/ clean

clean-cdt-kotlin-protocol-builder:
	@echo Cleaning cdt-kotlin-protocol-builder project...
	$(MVN) --file "$(CDT_PROTOCOL_BUILDER_DIR)/" clean

clean-cdt-kotlin-client:
	@echo Cleaning cdt-kotlin-client project...
	$(MVN) --file "$(CDT_CLIENT_DIR)/" clean

clean-cdt-kotlin-client-serialization:
	@echo Cleaning cdt-kotlin-client-serialization project...
	$(MVN) --file "$(CDT_SERIALIZATION_CLIENT_DIR)/" clean

clean-previous-protocol:
	@echo Cleaning previous protocol...
	$(call remove_tree,$(CDT_CLIENT_DIR)/src/main/$(LANGUAGE)/$(CDT_CLIENT_PACKAGE)/types)
	$(call remove_tree,$(CDT_CLIENT_DIR)/src/main/$(LANGUAGE)/$(CDT_CLIENT_PACKAGE)/events)
	$(call remove_tree,$(CDT_CLIENT_DIR)/src/main/$(LANGUAGE)/$(CDT_CLIENT_PACKAGE)/commands)

clean-previous-protocol-serialization:
	@echo Cleaning previous serialization protocol...
	$(call remove_tree,$(CDT_SERIALIZATION_CLIENT_DIR)/src/main/kotlin/$(CDT_SERIALIZATION_CLIENT_PACKAGE)/types)
	$(call remove_tree,$(CDT_SERIALIZATION_CLIENT_DIR)/src/main/kotlin/$(CDT_SERIALIZATION_CLIENT_PACKAGE)/events)
	$(call remove_tree,$(CDT_SERIALIZATION_CLIENT_DIR)/src/main/kotlin/$(CDT_SERIALIZATION_CLIENT_PACKAGE)/commands)
	$(call remove_tree,$(CDT_SERIALIZATION_CLIENT_DIR)/src/main/kotlin/$(CDT_SERIALIZATION_CLIENT_PACKAGE)/support)

generate-chrome-devtools-client:
	@echo Generating chrome devtools client ...
	$(RUN_JAR) $(CDT_PROTOCOL_BUILDER_JAR) --base-package="$(PACKAGE_NAME)" \
		--language=$(LANGUAGE) \
		--output=./$(CDT_CLIENT_DIR)/ \
		--js-protocol=$(JS_PROTOCOL_JSON_FILE) \
		--browser-protocol=$(BROWSER_PROTOCOL_JSON_FILE)

generate-chrome-devtools-client-serialization:
	@echo Generating chrome devtools client with kotlinx.serialization ...
	$(RUN_JAR) $(CDT_PROTOCOL_BUILDER_JAR) --base-package="$(SERIALIZATION_PACKAGE_NAME)" \
		--language=$(LANGUAGE) \
		--serialization \
		--output=./$(CDT_SERIALIZATION_CLIENT_DIR)/ \
		--js-protocol=$(JS_PROTOCOL_JSON_FILE) \
		--browser-protocol=$(BROWSER_PROTOCOL_JSON_FILE)

upgrade-protocol: copy-protocol-files-to-test-resources build-all-modules clean-previous-protocol
	@echo Upgrading protocol
	$(RUN_JAR) $(CDT_PROTOCOL_BUILDER_JAR) --base-package="$(PACKAGE_NAME)" \
		--language=$(LANGUAGE) \
		--output=./$(CDT_CLIENT_DIR)/ \
		--js-protocol=$(JS_PROTOCOL_JSON_FILE) \
		--browser-protocol=$(BROWSER_PROTOCOL_JSON_FILE)

upgrade-protocol-serialization: copy-protocol-files-to-test-resources build-all-modules clean-previous-protocol-serialization
	@echo Upgrading serialization protocol
	$(RUN_JAR) $(CDT_PROTOCOL_BUILDER_JAR) --base-package="$(SERIALIZATION_PACKAGE_NAME)" \
		--language=$(LANGUAGE) \
		--serialization \
		--output=./$(CDT_SERIALIZATION_CLIENT_DIR)/ \
		--js-protocol=$(JS_PROTOCOL_JSON_FILE) \
		--browser-protocol=$(BROWSER_PROTOCOL_JSON_FILE)

update-protocol: upgrade-protocol
	@echo Updated protocol on cdt-kotlin-client
	$(MVN) verify -Dgpg.skip=true

update-protocol-serialization: upgrade-protocol-serialization
	@echo Updated serialization protocol on cdt-kotlin-client-serialization
	$(MVN) -f "$(CDT_SERIALIZATION_CLIENT_DIR)/" verify -Dgpg.skip=true

update-copyright-license-header:
	@echo Updating copyright license header
	$(MVN) clean license:update-file-header
	$(MVN) com.coveo:fmt-maven-plugin:format

sonar-analysis:
	@echo Running sonar analysis
	bash -c "cd $(CDT_PROTOCOL_BUILDER_DIR)/ && make sonar-analysis"
	bash -c "cd $(CDT_CLIENT_DIR)/ && make sonar-analysis"

verify:
	@echo Running unit tests
	$(MVN) verify -Dgpg.skip=true

download-latest-protocol:
	@echo Downloads the latest protocol json files
	bash -c "curl -o browser_protocol.json https://raw.githubusercontent.com/ChromeDevTools/devtools-protocol/master/json/browser_protocol.json"
	bash -c "curl -o js_protocol.json https://raw.githubusercontent.com/ChromeDevTools/devtools-protocol/master/json/js_protocol.json"
