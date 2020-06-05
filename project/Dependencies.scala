import sbt._

object WellcomeDependencies {
  val fixturesLibrary: Seq[ModuleID] = library(
    name = "fixtures",
    version = "1.2.0"
  )

  private def library(name: String, version: String): Seq[ModuleID] = Seq(
    "uk.ac.wellcome" %% name % version,
    "uk.ac.wellcome" %% name % version % "test" classifier "tests"
  )
}


object Dependencies {

  lazy val versions = new {
    val akka     = "2.6.4"
    val typesafe = "1.3.2"
    val scalatest = "3.1.1"
    val logback = "1.2.3"
  }

  val logbackDependencies = Seq(
    "ch.qos.logback" % "logback-classic" % versions.logback,
    "ch.qos.logback" % "logback-core" % versions.logback,
    "ch.qos.logback" % "logback-access" % versions.logback
  )

  val akkaDependencies: Seq[ModuleID] = Seq(
    "com.typesafe.akka" %% "akka-actor" % versions.akka,
    "com.typesafe.akka" %% "akka-stream" % versions.akka,
    // Force Akka to use SL4J logging adapter
    // https://doc.akka.io/docs/akka/current/logging.html#slf4j
    "com.typesafe.akka" %% "akka-slf4j" % versions.akka,
  )

  val typesafeDependencies: Seq[ModuleID] = Seq(
    "com.typesafe" % "config" % versions.typesafe
  )

  val scalatestDependencies = Seq[ModuleID](
    "org.scalatest" %% "scalatest" % versions.scalatest % "test"
  )

  val libraryDependencies =
    akkaDependencies ++
    logbackDependencies ++
    typesafeDependencies ++
    scalatestDependencies ++
    WellcomeDependencies.fixturesLibrary
}
