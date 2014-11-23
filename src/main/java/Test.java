import java.sql.*;

/**
 * Created by bjcheny on 10/16/14.
 */
public class Test {

  private static final int PORT = Integer.parseInt(System.getProperty("port", "7686"));

  public static void testPostgre() {
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    String url = "jdbc:postgresql://127.0.0.1:5433/postgres";
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(url, "postgres", "postgres");
    } catch (SQLException e) {
      e.printStackTrace();
    }

    String sql="select * from pg_database";
    try {
      assert conn != null;
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        System.out.println(rs.toString());
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void testSqlserver() {
    try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    String url = "jdbc:sqlserver://192.168.31.184;user=bjcheny;password=;database=school";
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(url);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    String sql = "select * from student";
    try {
      assert conn != null;
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      if (rs.next()) {
        System.out.println(rs.getString("txt_title"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private static void testOracle() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
    } catch (ClassNotFoundException e) {
      System.out.println("Where is your Oracle JDBC Driver?");
      e.printStackTrace();
    }

    Connection connection = null;
    try {
      connection = DriverManager.getConnection(
              "jdbc:oracle:thin:@localhost:1521:mkyong", "username",
              "password");
    } catch (SQLException e) {
      e.printStackTrace();
      return;
    }

    if (connection != null) {
      System.out.println("You made it, take control of oracle");
    } else {
      System.out.println("Failed to make connection!");
    }
  }

  private static void testMysql() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      return;
    }

    Connection connection = null;
    try {
      connection = DriverManager
              .getConnection("jdbc:mysql://localhost:3306/","", "");

    } catch (SQLException e) {
      System.out.println("Connection Failed! Check output console");
      e.printStackTrace();
      return;
    }

    if (connection != null) {
      System.out.println("You made it, take control of mysql");
    } else {
      System.out.println("Failed to make connection!");
    }
  }

  public static void main(String[] args) throws Exception {
    // testPostgre();
    // testOracle();
    testSqlserver();
    // testMysql();
  }

}
