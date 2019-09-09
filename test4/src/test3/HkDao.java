package test3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HkDao extends DataBase {

	public HkDao() {
		super();
	}

	public List<HkDto> getAllList(){
		List<HkDto> list=new ArrayList<HkDto>();
		
		
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

	
	












