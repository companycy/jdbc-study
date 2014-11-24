import org.javatuples.Quartet;
import org.javatuples.Triplet;

import java.sql.*;

/**
 * Created by bjcheny on 10/16/14.
 */
public class Test {

  public static void test(Quartet<String, String, String, String> dns, String sql) {
    String driver = dns.getValue0();
    String url = dns.getValue1();
    String user = dns.getValue2();
    String password = dns.getValue3();
    try {
      Class.forName(driver);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    Connection connection = null;
    try {
      connection = DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    try {
      assert connection != null;
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        System.out.println(rs.toString());
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void testPostgre() {
    Quartet dns = new Quartet(
        "org.postgresql.Driver",                     // driver
        "jdbc:postgresql://127.0.0.1:5432/postgres", // url
        "postgres",                                  // user
        "postgres");                                 // password
    String sql = "select * from pg_database";
    test(dns, sql);
  }

  private static void testMysql() {
    Quartet dns = new Quartet(
        "com.mysql.jdbc.Driver",                     // driver
        "jdbc:mysql://localhost:3306/",              // url
        "",                                          // user
        "");                                         // password
    String sql = "show databases";
    test(dns, sql);
  }

  public static void testSqlserver() {  // sqlserver version
    Quartet dns = new Quartet(
        "com.microsoft.sqlserver.jdbc.SQLServerDriver",    // driver
        "jdbc:sqlserver://192.168.31.184;database=school", // url
        "bjcheny",                                         // user
        "123");                                            // password
    String sql = "select * from sys.server_permissions";
    test(dns, sql);
  }

  public static void testSqlserver2() {
    Quartet dns = new Quartet(
        "net.sourceforge.jtds.jdbc.Driver",
        "jdbc:jtds:sqlserver://192.168.31.184/school;",
        "bjcheny",
        "123");
    String sql = "select * from sys.server_permissions";
    test(dns, sql);
  }

  private static void testOracle() {
    Quartet dns = new Quartet(
        "oracle.jdbc.driver.OracleDriver",
        "jdbc:oracle:thin:@localhost:1521:mkyong", // url
        "",                                        // user
        "");                                       // password
    String sql = "show databases";
    test(dns, sql);
  }

  public static void main(String[] args) throws Exception {
    // testPostgre();
    // testOracle();
    // testSqlserver();
    testSqlserver2();
    // testMysql();
  }

}
