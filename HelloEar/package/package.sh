#!/bin/bash

rm *.war

cp /data/work/ams/ams-web/target/ams.war ./

jar -cf ../ear.ear ./*
