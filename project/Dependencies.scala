import sbt._

object Dependencies {

  val finagleV = "6.43.0"
  val jacksonV = "2.4.4"
  val akkaVersion = "2.5.17"

  val slf4j = "org.slf4j" % "slf4j-api" % "1.7.7"
  val scrooge = "com.twitter" %% "scrooge-core" % "4.15.0"
  val finagleCore = "com.twitter" %% "finagle-core" % finagleV exclude("com.twitter", "util-logging_2.11") exclude("com.twitter", "util-app_2.11")
  val finagleThrift = "com.twitter" %% "finagle-thrift" % finagleV
  val finagleHttp = "com.twitter" %% "finagle-http" % finagleV
  val configDep = "com.typesafe" % "config" % "1.0.2"
  val mapdb = "org.mapdb" % "mapdb" % "0.9.13"
  val chill = "com.twitter" %% "chill" % "0.9.3"
  val jacksonAfterBurner = "com.fasterxml.jackson.module" % "jackson-module-afterburner" % jacksonV
  val jacksonScala = "com.fasterxml.jackson.module" %% "jackson-module-scala" % jacksonV
  val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
  val logback = "ch.qos.logback" % "logback-classic" % "1.1.2"
  val thrift = "org.apache.thrift" % "libthrift" % "0.9.2"
  val akkaActor = "com.typesafe.akka" %% "akka-actor" % akkaVersion
  val akkaActorType = "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion
  val akkaActorTest = "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion
}
