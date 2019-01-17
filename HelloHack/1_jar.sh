#!/bin/bash

# config jdk/jar path

cd ./lib

for FILE_NAME in atlassian-extras-3.2 atlassian-universal-plugin-manager-plugin-2.22.9 \
    hibernate-validator-5.0.3.Final
do
    rm $FILE_NAME -rf; mkdir $FILE_NAME

    cd $FILE_NAME
    jar xvf ../$FILE_NAME.jar
    cd ..
done

cd ..
