#!/bin/bash

cd ./lib

rm com -rf; mv ../target/classes/com ./
rm org -rf; mv ../target/classes/org ./

# jira
jar -uvf atlassian-extras-3.2.jar \
  com/atlassian/license/LicenseManager.class

jar -uvf atlassian-universal-plugin-manager-plugin-2.22.9.jar \
  com/atlassian/extras/decoder/v2/Version2LicenseDecoder.class

# hibernate
jar -uvf hibernate-validator-5.0.3.Final.jar \
  org/hibernate/validator/internal/engine/resolver/JPATraversableResolver.class

cd ..
