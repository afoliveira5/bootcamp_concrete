#!/bin/bash
set -x

export TESTS_BROWSER=chrome
export TESTS_ENVIRONMENT=itau-hom
export EXECUTION_ENVIRONEMENT=production
export ENABLE_ATTACHMENTS_STORE=true

if [ -z "$1" ]; then
    echo "Executando todas as features..."
    # mvn -s local-settings.xml -Dbrowser=CHROME_WINDOWS test
    mvn -s local-settings.xml \
        -Dwebdriver.chrome.driver="../drivers/windows/chromedriver.exe" \
        -Dwebdriver.gecko.driver="../drivers/windows/geckodriver.exe" \
        test
else
    echo "Executando as features correspondentes as tags: ${1}"
    # mvn -s local-settings.xml -Dbrowser=CHROME_WINDOWS test -Dcucumber.options="--tags $1"
    mvn -s local-settings.xml \
        -Dwebdriver.chrome.driver="../drivers/windows/chromedriver.exe" \
        -Dwebdriver.gecko.driver="../drivers/windows/geckodriver.exe" \
        -Dcucumber.filter.tags="$1" \
        test
fi

exit $?
