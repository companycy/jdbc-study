name := "Test"

version := "1.0"

libraryDependencies ++= Seq(
  "postgresql" % "postgresql" % "9.1-901.jdbc4",
  "mysql" % "mysql-connector-java" % "5.1.10",
  "net.sourceforge.jtds" % "jtds" % "1.2.7" // 1.3.0
  // "com.microsoft.sqlserver" % "sqljdbc4" % "4.0"
)
