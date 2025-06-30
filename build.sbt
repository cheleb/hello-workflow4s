val scala3Version = "3.7.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "Hello Workflow4s",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies += "org.business4s" %% "workflows4s-core" % "0.1.2",
    libraryDependencies += "org.business4s" %% "workflows4s-bpmn" % "0.1.2",
    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0" % Test
  )
