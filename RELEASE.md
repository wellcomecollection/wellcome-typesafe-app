RELEASE_TYPE: major 

Include Logback and akka-slf4j as dependencies.

akka-slf4j is required to ensure akka logs use the sl4j adapter: https://doc.akka.io/docs/akka/current/logging.html

Consumers will need to remove their own references to Logback and akka-slf4j.

This change also includes some tests to check config is set correctly.
