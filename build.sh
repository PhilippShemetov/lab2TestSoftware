#!/bin/bash
set -e

gpg --passphrase=${GPG_PASSPHRASE} --no-use-agent --output - keys.asc | gpg --import

mvn -B -s settings.xml -P gpg clean install

VERSION=$(cat pom.xml | grep '<version>' -m 1 | sed 's/[^0-9.]//g')
echo "Creating dummy app based on version ${VERSION}"

cd target
mvn archetype:generate -DgroupId=myapp \
    -DartifactId=myapp \
    -DarchetypeGroupId=com.github.ngeor \
    -DarchetypeArtifactId=archetype-quickstart-jdk8 \
    -DarchetypeVersion=${VERSION} \
    -DinteractiveMode=false \
    -DarchetypeCatalog=local

cd myapp
mvn test

gpg --fingerprint --with-colons ${GPG_KEY} |\
    grep "^fpr" |\
    sed -n 's/^fpr:::::::::\([[:alnum:]]\+\):/\1/p' |\
    xargs gpg --batch --delete-secret-keys

gpg --batch --yes --delete-key ${GPG_KEY}
