#!/bin/bash

cd ./lib

# jira
mkdir -p ../src/main/java/com/atlassian/license/
cp ./atlassian-extras-3.2-src/com/atlassian/license/LicenseManager.java \
  ../src/main/java/com/atlassian/license/.

mkdir -p ../src/main/java/com/atlassian/extras/decoder/v2/
cp ./atlassian-universal-plugin-manager-plugin-2.22.9-src/com/atlassian/extras/decoder/v2/Version2LicenseDecoder.java \
  ../src/main/java/com/atlassian/extras/decoder/v2/.

# hibernate
mkdir -p ../src/main/java/org/hibernate/validator/internal/engine/resolver/
cp ./hibernate-validator-5.0.3.Final-src/org/hibernate/validator/internal/engine/resolver/JPATraversableResolver.java \
  ../src/main/java/org/hibernate/validator/internal/engine/resolver/.

cd ..

# update code manually
