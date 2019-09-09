package test3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HkDao extends DataBase {

	private String sql;


	public HkDao() {
		super();
	}

	public List<HkDto> getAllList(){
		List<HkDto> list=new ArrayList<HkDto>();
		String url="jdbc:oracle:thin@localhost:1521:xe";
		String user="hk5";
		String password="hk5";
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="SELECT SEQ, ID , NAME, TITLE  CONTET,REGDATE,  "
				+"FORM HKBOARD ORDER BY REGDATE DESC";
				
		
		try {
			conn=DriverManager.getConnection(url,user,password);
			System.out.println("2단계:DB연결성공");
			conn=getConnection();
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
			System.out.println("jdbc:실패"+getClass()+":"+"getAllList()");
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
		
		return count>0?true:false;//삼항연산자
	}


	public HkDto getBoard(int seq) {
		HkDto dto=new HkDto();
		
		return dto;

	}
	public boolean updateBoard(HkDto dto) {
		int count =0;
		
		return count>0?true:false;

	}

	public boolean delBoard(int seq) {
		int count=0;
		
		return count>0?true:false;
	}


	public boolean muldel(String[]seqs) {
		boolean isS=true;
		int[]count=null;
		
		return isS;

	}

	
}//class종료

	
	












