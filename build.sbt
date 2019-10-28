resolvers += "Spark Packages Repo" at "http://dl.bintray.com/spark-packages/maven"

name := "scalab"

version := "0.0.1"

scalaVersion := "2.12.7"

resolvers ++= Seq(
  "cnvr_public" at "http://vault.cnvrmedia.net/nexus/content/groups/public",
  "confluent" at "http://packages.confluent.io/maven/"
)

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.0" % "provided"

libraryDependencies += "mrpowers" % "spark-daria" % "0.27.1-s_2.11"

libraryDependencies += "MrPowers" % "spark-fast-tests" % "0.17.2-s_2.11" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

libraryDependencies += "org.apache.hadoop" % "hadoop-aws" % "2.6.0"
libraryDependencies += "com.dotomi" % "vault-connector" % "201908.0.1198-SNAPSHOT"

// nexus credentials
credentials += Credentials(Path.userHome / ".sbt" / ".sbt.credentials")
// test suite settings
fork in Test := true
javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:MaxPermSize=2048M", "-XX:+CMSClassUnloadingEnabled")
// Show runtime of tests
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oD")

// JAR file settings

// don't include Scala in the JAR file
//assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)

// Add the JAR file naming conventions described here: https://github.com/MrPowers/spark-style-guide#jar-files
// You can add the JAR file naming conventions by running the shell script
