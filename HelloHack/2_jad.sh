#!/bin/bash

# config jad path

cd ./lib

for FILE_NAME in atlassian-extras-3.2 atlassian-universal-plugin-manager-plugin-2.22.9 \
    hibernate-validator-5.0.3.Final
do
    rm $FILE_NAME-src -rf
    jad -r -d $FILE_NAME-src -s java -8 $FILE_NAME/**/*.class
done

cd ..
