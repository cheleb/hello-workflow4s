val scala3Version = "3.7.1"
val workflow4sVersion = "0.3.0"
lazy val root = project
  .in(file("."))
  .settings(
    name := "Hello Workflow4s",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies += "org.business4s" %% "workflows4s-core" % workflow4sVersion,
    libraryDependencies += "org.business4s" %% "workflows4s-bpmn" % workflow4sVersion,
    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0" % Test
  )
