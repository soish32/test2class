package test3;

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
		}
	}


	//2단계:DB연결-->Connection객체생성(url,uesr,pw)
	public Connection getConnection() throws SQLException{

		//예외처리 2가지 방법: try~catch(직접처리),throws~~(다른곳에서 처리:예외던지기)
		Connection conn=null;
		String url="jdbc:oracle:thin:@locallhost:1521xe";
		String user="hk5";
		String password="hk5";
		try {
			conn=DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	//6단계:DB닫기
	public void close(ResultSet rs, PreparedStatement psmt,Connection conn) throws ClassNotFoundException {
		try {
			if(rs!=null) {
				rs.close();	
			}
			if(psmt!=null) {
				psmt.close();
			}
			if(conn!=null) {
				conn.close();

			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


