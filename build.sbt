organization := "com.github.jurajburian"

name := "mailer"

version := "1.2.1"

description := "Thin wrapper of JavaMail library written in Scala language. Mailer is aim to be used in situations when is necessary send multiple mails, e.t. instance of javax.mail.Session is created and used by Mailer."

scalaVersion := "2.12.1"

crossScalaVersions := Seq("2.10.5", "2.11.8", "2.12.1")

publishMavenStyle := true

publishTo := {
	val nexus = "https://oss.sonatype.org/"
	if (isSnapshot.value)
		Some("snapshots" at nexus + "content/repositories/snapshots")
	else
		Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

// enable automatic linking to the external Scaladoc of managed dependencies
autoAPIMappings := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }


pomExtra := (
	<url>https://github.com/JurajBurian/mailer</url>
		<licenses>
			<license>
				<name>unlicense</name>
				<url>http://unlicense.org/</url>
				<distribution>repo</distribution>
			</license>
		</licenses>
		<scm>
			<url>https://github.com/jurajburian/mailer</url>
			<connection>scm:git:https://github.com/jurajburian/mailer</connection>
		</scm>
		<developers>
			<developer>
				<id>JurajBurian</id>
				<name>Juraj Burian</name>
				<url>https://github.com/JurajBurian</url>
			</developer>
			<developer>
				<id>xwinus</id>
				<name>Vaclav Svejcar</name>
				<url>https://github.com/xwinus</url>
			</developer>
			<developer>
				<id>jannad</id>
				<name>Jan Nad</name>
				<url>https://github.com/jannad</url>
			</developer>
		</developers>)

scalacOptions := Seq(
	"-encoding", "UTF-8",
	"-unchecked",
	"-deprecation",
	"-feature",
	"-Xfatal-warnings",
	"-Xlint",
	"-Yrangepos",
	"-language:postfixOps"
)

libraryDependencies ++= Seq(
	"javax.mail" % "mail" % "1.4.7",
	"de.saly" % "javamail-mock2-fullmock" % "0.5-beta4" % "test",
	"org.scalatest" %% "scalatest" % "3.0.1" % "test"
)
