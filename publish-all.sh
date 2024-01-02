#!/bin/bash

studio=coffee-studio

plugins=(
    'java-springboot-restapi-base-plugin'
    'java-spring-data-jpa-plugin'
)

for plugin in "${plugins[@]}"
do
    cd $plugin
    stk publish plugin --studio $studio
    cd ..
done