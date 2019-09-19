package login_board_MVC2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {
	public DataBase() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1단계:드라이버로딩성공");
		} catch (ClassNotFoundException e) {
			System.out.println("1단계:드라이버로딩실패:"+getClass());
			e.printStackTrace();
		}
	}


	//2단계:DB연결 ->connection 객체생성(url,user,pw)
	public Connection getConnection() throws SQLException{
		//예외처리 2가지 방법 :try~catch(직접처리),throws~~(다른곳에서 처리:예외던지기)
		Connection conn=null;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="hk5";
		String password="hk5";
		conn = DriverManager.getConnection(url);
		return conn;

	}



	//6단계DB닫기
	public void close(ResultSet rs,PreparedStatement pmst,Connection conn) {
		try {

			if(rs!=null) {
				rs.close();
			}
			if(pmst!=null) {
				pmst.close();	
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
		
		}

	}
}