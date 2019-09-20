package login_board_MVC2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import login_board_MVC2.SqlMapConfig;
import login_board_MVC2.DataBase;
import login_board_MVC2.HkDto;
public class HkDao extends SqlMapConfig {
	private String nameSpace="login_board_MVC2";

	public HkDao() {
		super();

	}

	//글목록조회 :select문실행:반환값은 List타입(Dto담겨있음)
	public List<HkDto> getAllList(){
		List<HkDto> list=new ArrayList<>();
		SqlSession sqlSession=null;

		try {
			SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
			sqlSession=sqlSessionFactory.openSession(true);
			list=sqlSession.selectList(nameSpace+"boardlist");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}

	//글추가하기 :insert문실행:성공하면 1반환 실패하면0반환
	public boolean insertBoard(HkDto dto) {
		int count=0;
		SqlSession sqlSession=null;
		try {
			sqlSession=getSqlSessionFactory().openSession(true);
			//(실행할 쿼리 이름, 전달할 파라미터)
			count=sqlSession.insert(nameSpace+"insertboard",dto);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return count>0?true:false;
	}
	//글상세보기:select문실행:반환값은Dto:파라미터:seq
	public HkDto getBoard(int seq) {
		HkDto dto=new HkDto();
		SqlSession sqlSession=null;
		try {

			sqlSession=getSqlSessionFactory().openSession(true);
			dto=sqlSession.selectOne(nameSpace+"getboard",seq);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return dto;
	}


	//글수정하기 :update문실행:성공하면1반환, 실패하면0반환
	public boolean updateBoard(HkDto dto) {
		int count =0;
		SqlSession sqlSession=null;
		try {


			sqlSession=getSqlSessionFactory().openSession(true);
			count=sqlSession.update(nameSpace+"updateboard",dto);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return count>0?true:false;
	}
	
	//글삭제하기 :delete문 실행 :성공하면 1반환 실패하면 0반환
	public boolean delBoard(int seq) {
		int count=0;
		SqlSession sqlSession=null;
		
		try {
			sqlSession=getSqlSessionFactory().openSession(true);
			count=sqlSession.delete(nameSpace+"delboard",seq);
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return count>0?true:false;
	}

//글 여러개 삭제하기 :delete문 실행 --->여러개가실행
//batch 개념 :동일한 작업을 한번에 실행하는 개념
/*
 *  *  DELETE FROM HKBOARD WHERE SEQ=1
 *  DELETE FROM HKBOARD WHERE SEQ=6
 *  DELETE FROM HKBOARD WHERE SEQ=9
 *  
 *  DELETE FROM HKBOARD WHERE SEQ IN (1,6,9)
 */
public boolean muldel(String[]seqs) {
	int count=0;
	SqlSession sqlSession=null;
	//다이나믹 쿼리 사용시 파라미터는 반드시 Map에 담아 전달한다
	Map<String, String[]>map=new HashMap<>();
	map.put("seqs", seqs);

	try {
		sqlSession=getSqlSessionFactory().openSession(true);
		count=sqlSession.delete(nameSpace+"muldel",map);
		sqlSession.commit();
	} catch (Exception e) {
		//			 sqlSession.rollback();
		e.printStackTrace();
	}finally {
		sqlSession.close();
	}
	return count>0?true:false;
}


}//class



