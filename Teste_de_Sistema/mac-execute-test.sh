#!/bin/bash
set -x

RC=0

export TESTS_BROWSER=chrome
export TESTS_ENVIRONMENT=sistema-dev
export EXECUTION_ENVIRONEMENT=development
export ENABLE_ATTACHMENTS_STORE=true

if [ -z "$1" ]; then
    echo "Executando todas as features..."
    # mvn -s local-settings.xml -Dbrowser=CHROME_MAC test
    mvn -s local-settings.xml \
        -Dwebdriver.chrome.driver="../drivers/mac/chromedriver" \
        -Dwebdriver.gecko.driver="../drivers/mac/geckodriver" \
        test
    RC=$?

else
    echo "Executando as features correspondentes as tags: ${1}"
    # mvn -s local-settings.xml -Dbrowser=CHROME_MAC test -Dcucumber.options="--tags $1"
    mvn -s local-settings.xml \
        -Dwebdriver.chrome.driver="../drivers/mac/chromedriver" \
        -Dwebdriver.gecko.driver="../drivers/mac/geckodriver" \
        -Dcucumber.filter.tags="$1" \
        test
    RC=$?
    
fi

if [ "x${RC}" != "x0" ]; then
    exit 1
fi

exit 0


