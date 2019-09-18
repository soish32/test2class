package test6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	public DataBase() {

		try {
			Class.forName("oracle.jdbc.driver.OralceDriver");
			System.out.println("1단계:드라이버성공");
		} catch (ClassNotFoundException e) {
			System.out.println("1단계:드라이버로딩실패:"+getClass());
			e.printStackTrace();
		}
	}


	//2단계:DB연결-->Connection객체생성(url,user,pw)
	public Connection getConnection() throws SQLException {
		//예외처리2가지방법:try~catch(직접처리),throws~~(다른곳에서 처리:예외던지기)
		Connection conn=null;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="hk5";
		String password="hk5";
		conn=DriverManager.getConnection(url,user,password);
		return conn;
		
	}
}


