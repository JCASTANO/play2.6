name := "web"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, LauncherJarPlugin)

scalaVersion := "2.12.2"

libraryDependencies += guice

// Configuracion para eclipse
EclipseKeys.preTasks := Seq(compile in Compile)
EclipseKeys.projectFlavor := EclipseProjectFlavor.Java           // Java project. Don't expect Scala IDE
EclipseKeys.createSrc := EclipseCreateSrc.ValueSet(EclipseCreateSrc.ManagedClasses, EclipseCreateSrc.ManagedResources)  // Use .class files instead of generated .scala files for views and routes

// Excluir documentacion de API
sources in (Compile, doc) := Seq.empty
publishArtifact in (Compile, packageDoc) := false
