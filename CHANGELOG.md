# CHANGELOG

## v3.0.0 - 2020-06-08

Include Logback and akka-slf4j as dependencies.

akka-slf4j is required to ensure akka logs use the sl4j adapter: https://doc.akka.io/docs/akka/current/logging.html

Consumers will need to remove their own references to Logback and akka-slf4j.

This change also includes some tests to check config is set correctly.

## v2.0.0 - 2020-04-20

Upgrade Akka from 2.5.9 to 2.6.4.

## v1.2.0 - 2020-02-12

An optional maxConnections parameter added to AWSClientConfig.

## v1.1.0 - 2019-07-01

Bump the version of scala-fixtures to 1.2.0.

## v1.0.0 - 2019-02-07

Initial release of wellcome-typesafe-app.

## v0.0.0 - 2019-02-07

Dummy release to trigger the build scripts.
