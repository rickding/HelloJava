#!/bin/bash

rm *.war

cp ../../HelloWar/target/war-0.0.1-SNAPSHOT.war ./war.war
cp ../../HelloWebWar/target/web_war-0.0.1-SNAPSHOT.war ./web.war

cp ../../../work/ams/ams-web/target/ams.war ./

jar -cf ../ear.ear ./*
