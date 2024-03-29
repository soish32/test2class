package test5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDao extends DataBase {
	private String id;
	private String passwrod;
	public LoginDao() {
		super();
	}

	//사용자 기능
	//1.회원가입 기능구현
	public 	boolean insertUser(LoginDto dto) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		String sql="INSERT INTO USERINFO VALUES("
				+" USERINFO_SEQ.NEXTVAL,?,?,?,?,?,'Y','USER',SYSDATE,?) ";

		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,dto.getId());
			psmt.setString(2, dto.getPassword());
			psmt.setString(3, dto.getAddress());
			psmt.setString(4, dto.getPhone());
			psmt.setString(5, dto.getEmail());
			psmt.setString(6, dto.getName());
			log("3단계 쿼리준비","insertUser()");
			count=psmt.executeUpdate();
			log("4단계 쿼리실행","insertUser()");
		} catch (SQLException e) {
			log	  ("JDBC","insertUser()",e);
			e.printStackTrace();
		}finally {
			close(null,psmt,conn);
		}
		return count>0?true:false;

	}
	//2.로그인 기능 구현---id와 password를 입력받아서 두개의값을 만족하는 조건을확인해서 결과있으면 로그인실행
	public LoginDto getLogin(String id, String passwrod) {
		LoginDto dto=new LoginDto();
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="SELECT SEQ,ID,NAME,PASSWORD,ADDRESS,PHONE,EMAIL,"
				+" ENABLED,ROLE,REGDATE "
				+" FROM USERINFO WHERE ID=? AND PASSWORD=? AND ENABLED='Y'";
		try {
			conn=getConnection();//2단계 DB연결
			psmt=conn.prepareStatement(sql);//3단계 쿼리준비
			psmt.setString(1, id);
			psmt.setString(2, passwrod);
			log("3단계 쿼리준비","getLogin()");
			rs=psmt.executeQuery();
			log("4단계 쿼리실행","getLogin()");
			while(rs.next()) {
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setPassword(rs.getString(4));
				dto.setAddress(rs.getString(5));
				dto.setPhone(rs.getString(6));
				dto.setEmail(rs.getString(7));
				dto.setEnabled(rs.getString(8));
				dto.setRole(rs.getString(9));
				dto.setRegdate(rs.getDate(10));
				System.out.println(dto);
			}
			log("5 단계 결과받기","getLogin()");
		} catch (SQLException e) {
			log("JDBC","getLogin()",e);
		}finally {
			close(rs,psmt,conn);

		}
		return dto;
	}
	//3.나의 정보 조회 기능 구현(seq,id,name,address,phone, email,regdate)
	public LoginDto getInfo(int seq) {
		LoginDto dto=new LoginDto();
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=" SELECT SEQ,ID,NAME,ADDRESS,PHONE,EMAIL,REGDATE "
				+"FROM USERINFO WHERE SEQ=?";
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			rs=psmt.executeQuery();
			while(rs.next()) {
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setPhone(rs.getString(5));
				dto.setEmail(rs.getString(6));
				dto.setRegdate(rs.getDate(7));
				System.out.println(dto);

			}

		} catch (SQLException e) {
			log("JDBC","idChk()",e);
			e.printStackTrace();
		}finally {
			close(rs,psmt,conn);
		}
		return dto;

	}
	//4.나의정보 수정 기능 구현(address,phone,email수정)
	public boolean updateUser(LoginDto dto) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		String sql="UPDATE USERINFO SET ADDRESS=?,PHONE=?,EMAIL=? WHERE SEQ=?";
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getAddress());
			psmt.setString(2, dto.getPhone());
			psmt.setString(3, dto.getEmail());
			psmt.setInt(4, dto.getSeq());
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			log("JDBC","updateUser()",e);
		}finally {
			close(null,psmt,conn);
		}
		return count>0?true:false;
	}
	//회원탈퇴기능 구현 (enabled를'N'으로 수정
	//          --->getLogin():로그인시 쿼리 를 수정해야됨)
	public boolean delUser(int seq) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		String sql="UPDATE USERINFO SET ENABLED='N' WHERE SEQ=?";

		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1,seq);
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			log("JDBC","delUser()",e);
		}finally {
			close(null,psmt,conn);
		}
		return count>0?true:false;
	}





//아이디 중복 체크 기능 구현 
	public LoginDto idChk(String id) {
		LoginDto dto=new LoginDto();
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=" SELECT ID FROM USERINFO WHERE ID=? ";
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,id);
			rs=psmt.executeQuery();
			while(rs.next()) {
				dto.setId(rs.getString(1));
				System.out.println(dto);
			}
		} catch (SQLException e) {
			log("JDBC","idChk()",e);
			e.printStackTrace();
		}finally {
			close(rs,psmt,conn);
		}
		return dto;

	}
	public List<LoginDto> getAllUserStatus(){
		System.out.println("안녕");
		List<LoginDto>list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="SELECT SEQ,ID, NAME ,ADDRESS, PHONE ,EMAIL , ENABLED , ROLE , REGDATE"
				+" FROM USERINFO";

		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();			

			while(rs.next()) {
				LoginDto dto=new LoginDto();
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setPhone(rs.getString(5));
				dto.setEmail(rs.getString(6));
				dto.setEnabled(rs.getString(7));
				dto.setRole(rs.getString(8));
				dto.setRegdate(rs.getDate(9));
				list.add(dto);
				System.out.println(dto);
			}
		} catch (SQLException e) {
			log("JDBC","getAllUesrStatus()",e);
		}finally {
			close(rs,psmt,conn);
		}
		return list;

	}
	public List<LoginDto> getAllUserList(){
		List<LoginDto> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="SELECT SEQ,ID,ROLE,NAME, REGDATE "
				+" FROM USERINFO WHERE ENABLED='Y'";

		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
				while(rs.next()) {
				LoginDto dto=new LoginDto();
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setRole(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
				list.add(dto);
				System.out.println(dto);


			}
		} catch (SQLException e) {
			log("JDBC","gteAllUSerList()",e);
		}finally {
			close(rs, psmt, conn);
		}
		return list;
	}
	public LoginDto getUser(int seq) {
		LoginDto dto=new LoginDto();

		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="SELECT SEQ,ID, NAME ,ADDRESS,PHONE,EMAIL,ENABLED,ROLE,REGDATE "
				+" FROM USERINFO WHERE SEQ=?";

		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			rs=psmt.executeQuery();
			while(rs.next()) {
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setPhone(rs.getString(5));
				dto.setEmail(rs.getString(6));
				dto.setEnabled(rs.getString(7));
				dto.setRole(rs.getString(8));
				dto.setRegdate(rs.getDate(9));
			}
				System.out.println(dto);
			
		} catch (SQLException e) {
			log("JDBC","getUser()",e);
		}finally {
			close(rs, psmt, conn);
		}
		return dto;
	}

	public boolean updateUserRole(int seq,String role) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		String sql="UPDATE USERINFO SET ROLE=? WHERE SEQ=?";
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, role);
			psmt.setInt(2, seq);
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			log("JDBC","updateUserRole()",e);
		}finally {
			close(null, psmt, conn);
		}
		return count>0?true:false;

	}
}



