package DatabaseAccess;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseAccess {

	  static Connection getConnection() throws Exception {

	    //JDBCドライバのロード
	    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

	    //各設定
	    String url = "jdbc:odbc:SampleDB030";
	    String user = "";
	    String pass = "";

	    //データベースに接続
	    Connection con = DriverManager.getConnection(url,user,pass);

	    return con;
	  }

}
