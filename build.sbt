name := "sqlclient"

version := "1.0"

libraryDependencies ++= Seq(
        "postgresql" % "postgresql" % "9.1-901.jdbc4",
        "mysql" % "mysql-connector-java" % "5.1.10"
)
