name := "sqlclient"

version := "1.0"

libraryDependencies ++= Seq(
  "postgresql" % "postgresql" % "9.1-901.jdbc4",
  "org.javatuples" % "javatuples" % "1.1",
  "mysql" % "mysql-connector-java" % "5.1.10"
)
