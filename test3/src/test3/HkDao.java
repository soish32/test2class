package test3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HkDao extends DataBase {



	private ResultSet rs;
	private List<HkDto> list;
	private String url;
	private String user;
	private String password;

	//생성자란:클래스의값을초기화 할때 사용한다.
	//HkDao dao=new HkDao();
	//3대예외처리 : java.sql,javaio,javanet	
	public HkDao() {
		super();
	}

	//글목록조회:select문실행: 반환값은 List타입(Dto담겨있음)
	//	public List<HkDto> list=new ArrayList<>();
	//	
	//	Connection conn=null;//DB계정에 연결할때 사용할 객체
	//	PreparedStatement psmt=null;
	//	ResultSet rs=null;//DB결과를 받을때 사용할 객체
	//	
	//	String sql="SELECT SEQ,ID, NAME,TITLE,CONTENT,REGDATE"
	//			+"FROM HKBOARD ORDER BY REGDATE DESC";

	public List<HkDto> getAllList(){
		List<HkDto> list=new ArrayList<HkDto>();
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="hk5";
		String password="hk5";
		Connection conn=null;//DB계정에 연결할 때 사용할 객체
		PreparedStatement psmt=null;//쿼리 준비할때 사용할 객체
		ResultSet rs=null;//DB결과를 받을 때 사용할 객체
		String sql=" SELECT SEQ,ID, NAME,TITLE,CONTENT,REGDATE "
				+" FROM HKBOARD ORDER BY REGDATE DESC ";


		try {
			conn=DriverManager.getConnection(url,user,password);
			System.out.println("2단계:DB연결성공");
			psmt=conn.prepareStatement(sql);
			System.out.println("3단계:쿼리준비연결성공");
			rs=psmt.executeQuery();
			System.out.println("4단계:쿼리실행성공");
			while(rs.next()) {
				HkDto dto=new HkDto();
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setTitle(rs.getString(4));
				dto.setContent(rs.getString(5));
				dto.setRegdate(rs.getDate(6));
				list.add(dto);
				System.out.println(dto);
			}
			System.out.println("5단계:쿼리결과받기성공");
		} catch (SQLException e) {
			System.out.println("JDBC:실패:"+getClass()+":"+"getAllList()");
			e.printStackTrace();
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
				System.out.println("6단계:DB닫기성공");
			} catch (SQLException e) {
				System.out.println("6단계:DB닫기실패");
				e.printStackTrace();
			}
		}
		return list;
	}

	public boolean insertBoard(HkDto dto ) {
		int count=0;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="hk5";
		String password="hk5";
		Connection conn=null;
		PreparedStatement psmt=null;

		String sql=" INSERT INTO HKBOARD(SEQ,ID,NAME,TITLE,CONTENT,REGDATE) "
				+" VALUES(HKBOARD_SEQ.NEXTVAL,?,?,?,?,SYSDATE) ";

		try {
			conn=DriverManager.getConnection(url,user,password);
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getTitle());
			psmt.setString(4,dto.getContent());
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("JDBC:실패:"+getClass()+":"+"insertBoard()");
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
				
				e.printStackTrace();
			}
		}
		return count>0?true:false;//삼항연산자
	}


	public HkDto getBoard(int seq) {
		HkDto dto=new HkDto();
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql= " SELECT SEQ,ID,NAME,TITLE,CONTENT,REGDATE "
				+" FROM HKBOARD WHERE SEQ=?";

		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1,seq);
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
			System.out.println("jdbc실패:"+getClass()+":getBoard()");
			e.printStackTrace();
		}finally {
			close(rs, psmt, conn);
		}
		return dto;

	}
	public boolean updateBoard(HkDto dto) {
		int count =0;
		Connection conn =null;
		PreparedStatement psmt=null;
		String sql=" UPDATE HKBOARD SET TITLE=?, CONTENT=? , REGDATE=SYSDATE "
				+" WHERE SEQ=?";

		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setInt(3, dto. getSeq());
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return count>0?true:false;

	}

	public boolean delBoard(int seq) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		String sql=" DELETE FROM HKBOARD WHERE SEQ=?";
		try {
			conn= getConnection();
			psmt= conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(null,psmt,conn);
		}
		return count>0?true:false;
	}


	public boolean muldel(String[]seqs) {
		boolean isS=true;
		int[]count=null;
		Connection conn=null;
		PreparedStatement psmt=null;
		String sql=" DELETE FROM HKBOARD WHERE SEQ=?";

		try {
			conn=getConnection();
			conn.setAutoCommit(false);
			psmt=conn.prepareStatement(sql);
			for(int i= 0; i<seqs.length;i++) {
				psmt.setString(1,seqs[i]);
				psmt.addBatch();
			}
			count=psmt.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {

		}
		try {
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//화면처리위해서 성공여부를확인
		for(int i=0;i<count.length;i++) {
			isS=false;
			break;
		}
		return isS;

	}

	
	}

	
	












