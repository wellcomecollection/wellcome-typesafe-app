import sbt._

object WellcomeDependencies {
  val fixturesLibrary: Seq[ModuleID] = library(
    name = "fixtures",
    version = "1.0.0"
  )

  private def library(name: String, version: String): Seq[ModuleID] = Seq(
    "uk.ac.wellcome" %% name % version,
    "uk.ac.wellcome" %% name % version % "test" classifier "tests"
  )
}


object Dependencies {

  lazy val versions = new {
    val akka     = "2.5.9"
    val typesafe = "1.3.2"
  }

  val akkaDependencies: Seq[ModuleID] = Seq(
    "com.typesafe.akka" %% "akka-actor" % versions.akka,
    "com.typesafe.akka" %% "akka-stream" % versions.akka
  )

  val typesafeDependencies: Seq[ModuleID] = Seq(
    "com.typesafe" % "config" % versions.typesafe
  )

  val libraryDependencies =
    akkaDependencies ++
    typesafeDependencies ++
    WellcomeDependencies.fixturesLibrary
}
