package login_board_MVC2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import login_board_MVC2.DataBase;
import login_board_MVC2.HkDto;
public class HkDao extends DataBase {





	//생성자란: 클래스의 값을 초기화할때 사용한다.
	//HkDao dao=new HkDao();
	//3대 예외처리: java.sql, java.io, java.net
	public HkDao() {

	}

	public List<HkDto> getAllList() {
		List<HkDto> list= new ArrayList();
		String url= "jdbc:oracle:thin:@localhost:1521:xe";
		String user ="hk5";
		String password = "hk5";

		Connection conn= null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql= "SELECT SEQ,ID,NAME,TITLE,CONTENT ,REGDATE"
				+"FORM HKBOARD ORDER BY REGDATE DESC";
		try {
			conn=DriverManager.getConnection(url,user,password);
			System.out.println("2단계:DB연결성공");
			psmt=conn.prepareStatement(sql);
			System.out.print("3단계:쿼리준비성공");
			rs=psmt.executeQuery();
			System.out.print("4단계:쿼리실행성공");
			while(rs.next()) {
				HkDto dto=new HkDto();
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setTitle(rs.getString(4));
				dto.setContent(rs.getString(5));
				dto.setRegdate(rs.getDate(6));
				list.add(dto);
				System.out.print(dto);
			}

			System.out.println("5단계:쿼리결과받기성공");
		} catch (SQLException e) {
			System.out.println("jdbc실패:"+getClass()+":"+"getAllList()");
		}finally {
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
				System.out.println("6단계:DB닫기실행성공");
			} catch (final SQLException e) {
				System.out.println("6단계:DB닫기실패");
				e.printStackTrace();
			}

		}
		return list;
	}
	//글추가하기:insert문실행:성공하면 1반환 실패하면0반환
	public boolean insertBoard(HkDto dto) {
		int count=0;
		String url= "jdbc:oralce:thin:@localhost:1521xe";
		String user="hk5";
		String password="hk5";

		Connection conn=null;
		PreparedStatement psmt=null;
		String sql= "INSERT INTO HKBOARD(SEQ,ID,NAME,TITLE,CONTENT,REGDATE)"
				+"VALUES(HKBOARD_SEQ,NEXTVAL??????,SYSDATE)";
		try {
			conn=DriverManager.getConnection(url,user,password);
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getTitle());
			psmt.setString(4, dto.getContent());
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("jdbc실패:"+getClass()+":"+"insertBoard()");
			e.printStackTrace();
		}finally {
			try {
				if(psmt!=null) {
					psmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return count>0?true:false;
	}
	public HkDto getBoard(int seq) {
		HkDto dto = new HkDto();
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="SELECT SEQ,ID,NAME,TITLE,CONTENT,REGDATE"
				+"FORM HKBOARD WHERE SEQ=?";
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			rs=psmt.executeQuery();
			while(rs.next()) {
				int i=1;
				dto.setSeq(rs.getInt(i++));
				dto.setId(rs.getString(i++));
				dto.setName(rs.getString(i++));
				dto.setTitle(rs.getString(i++));
				dto.setContent(rs.getString(i++));
				dto.setRegdate(rs.getDate(i++));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs,psmt,conn);
		}
		return dto;
	}
	//글수정하기update문 실행:성공하면 1반환,실패하면0반환
	public boolean upateBoard(HkDto dto) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		String sql="UPATE HKBOARD SET TITLE=?,CONTENT=?, REGDATE=SYSDATE"
				+"WHERE SEQ=?";
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			count=psmt.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count>0? true:false;
	}
	public boolean delBoard(int seq) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		String sql="DELETE FORM HKBOARD WHERE SEQ=?";
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(null,psmt,conn);
		}
		return count>0?true:false;

	}

	 
	}



