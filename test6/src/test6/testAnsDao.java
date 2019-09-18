package test6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.Closeable;

public class testAnsDao extends DataBase {
	public testAnsDao() {
		super();	
	}
	
	//글목록조회(list를반환)
	public List<testAnsDto> getAllList(){
		List<testAnsDto>list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT,SEQ,ID,TITLE,REGDATE");
		sb.append("REFER,DEPTH,READCOUNT,DELFLAG");
		sb.append("FORM ANSWEBOARD ORDER BY REFER,STEP");
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sb.toString());
			rs=psmt.executeQuery();
			while(rs.next()) {
				testAnsDto dto=new testAnsDto();
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setRegdate(rs.getDate(4));
				dto.setRefer(rs.getInt(5));
				dto.setStep(rs.getInt(6));
				dto.setDepth(rs.getInt(7));
				dto.setRedcount(rs.getInt(8));
				dto.setDelfalag(rs.getString(9));
				list.add(dto);
				System.out.println(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
					close(rs,psmt,conn);
		}
		
		return list;
		
	

	
		
		
	}

	
	}
	
	



