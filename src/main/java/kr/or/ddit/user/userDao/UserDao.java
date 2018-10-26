package kr.or.ddit.user.userDao;

import java.util.List;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


public class UserDao implements UserDaoInf {
	
	public UserDao () {}
	private static UserDaoInf ud = null;
	
	public static UserDaoInf getInstance() {
		if(ud == null) {
			ud = new UserDao();
		}
		return ud;
	}	
	
	
	// jspuser 테이블 테이터 전체 조회 쿼리 
	// select query id : selectUserAll
	public List<UserVo> selectUserAll(){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		
		List<UserVo> list = session.selectList("user.selectUserAll");
		
		session.close();
		
		// 매개변수가 없어서 값을 주지 않아도 된다 
		// 여러건을 조회할때에는 selectList를 사용한다
		// selectOne : 데이터가 한건 일 떄 
		// 메소드 인자 : 문자열 = 네임스페이스(일반적으로 모듈명을 이용) .쿼리아이디 
		return list;
	}
	
	// jspuser 테이블 테이터 전체 조회 쿼리 
	// select query id : selectUserAll
	public UserVo selectUser(String userId){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		UserVo user = session.selectOne("user.selectUser",userId);
		
		session.close();
		
		// 매개변수가 없어서 값을 주지 않아도 된다 
		// 여러건을 조회할때에는 selectList를 사용한다
		// selectOne : 데이터가 한건 일 떄 
		// 메소드 인자 : 문자열 = 네임스페이스(일반적으로 모듈명을 이용) .쿼리아이디 
		return user;
	}
	
	
	public UserVo selectUserByVo(UserVo userVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		UserVo user = session.selectOne("user.selectUserByVo", userVo);
		
		session.close();
		
		// 매개변수가 없어서 값을 주지 않아도 된다 
		// 여러건을 조회할때에는 selectList를 사용한다
		// selectOne : 데이터가 한건 일 떄 
		// 메소드 인자 : 문자열 = 네임스페이스(일반적으로 모듈명을 이용) .쿼리아이디 
		return user;
		
	}


	// 페이징 처리 
	@Override
	public List<UserVo> selectUserPageList(PageVo pageVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
	
		List<UserVo> userList = session.selectList("user.selectUserPageList", pageVo);
		
		// 명시적으로 처리해 주기 
		//session.rollback();
		//session.commit();
		
		// 세션을 사용했으니깐 닫아준다
		session.close();
		
		// 매개변수가 없어서 값을 주지 않아도 된다 
		// 여러건을 조회할때에는 selectList를 사용한다
		// selectOne : 데이터가 한건 일 떄 
		// 메소드 인자 : 문자열 = 네임스페이스(일반적으로 모듈명을 이용) .쿼리아이디 
		return userList;
		
		
	}

	/**  * Method   : getUserCnt
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @return
	  * Method 설명 :  사용자 전체 건수 조회 
	*/
	@Override
	public int getUserCnt() {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int totalUserCnt = session.selectOne("user.getUserCnt");
		session.close();
		
		return totalUserCnt;
	}
	
	
	/**  * Method   : inserUser
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param : userVo
	  * @return : 리턴은 없다
	  * Method 설명 :  사용자 등록
	*/
	@Override
	public int insertUser(UserVo userVo){
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int insertCnt = session.insert("user.insertUser", userVo);
		
		// commit을 해야 데이터가 확정된다 ( 꼭 해주기 !)
		session.commit();
		session.close();
		
		return insertCnt;
	}


	/**  * Method   : deleteUser
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param userID
	  * @return
	  * Method 설명 :  사용자 삭제 
	*/
	@Override
	public int deleteUser(String userId) {
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int deleteCnt = session.delete("user.deleteUser", userId);
		
		// commit을 해야 데이터가 확정된다 ( 꼭 해주기 !)
		session.commit();
		session.close();
		
		return deleteCnt;
	}


	/**  * Method   : updateUser
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param userId
	  * @return
	  * Method 설명 :  사용자 정보 수정
	*/
	@Override
	public int updateUser(UserVo userVo) {
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int updateCnt = session.update("user.updateUser", userVo);
		
		// commit을 해야 데이터가 확정된다 ( 꼭 해주기 !)
		session.commit();
		session.close();
		
		return updateCnt;
	}


}
