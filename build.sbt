import java.util.UUID

import com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider

name    := "typesafe-app"
version := "1.1.0"

organization := "uk.ac.wellcome"
scalaVersion := "2.12.6"

libraryDependencies := Dependencies.libraryDependencies

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-encoding",
  "UTF-8",
  "-Xlint",
  "-Xverify",
  "-feature",
  "-language:postfixOps"
)

publishMavenStyle := true

publishTo := Some(
  "S3 releases" at "s3://releases.mvn-repo.wellcomecollection.org/"
)

resolvers ++= Seq(
  "S3 releases" at "s3://releases.mvn-repo.wellcomecollection.org/"
)

s3CredentialsProvider := { _ =>
  val builder = new STSAssumeRoleSessionCredentialsProvider.Builder(
    "arn:aws:iam::760097843905:role/platform-read_only",
    UUID.randomUUID().toString
  )

  builder.build()
}

publishArtifact in Test := true
