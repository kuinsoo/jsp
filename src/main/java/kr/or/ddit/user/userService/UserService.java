package kr.or.ddit.user.userService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.userDao.UserDao;
import kr.or.ddit.user.userDao.UserDaoInf;

public class UserService implements UserServiceInf {
	
	public UserService() {}
	private static UserServiceInf us = null;
	
	public static UserServiceInf getInstance() {
		if(us == null) {
			us = new UserService();
		}
		return us;
	}

	private UserDaoInf ud = UserDao.getInstance();

	
	@Override
	public List<UserVo> selectUserAll() {
		return ud.selectUserAll();
	}

	@Override
	public UserVo selectUser(String userId) {
		return ud.selectUser(userId);
	}

	@Override
	public UserVo selectUserByVo(UserVo userVo) {
		return ud.selectUserByVo(userVo);
	}

	
	
	/**  * Method   : selectUserPageList
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param pageVo
	  * @return
	  * Method 설명 :  사용자 페이징 조회
	*/
	@Override
	public Map<String , Object> selectUserPageList(PageVo pageVo) {
		
		// 페이지에 해당 하는 유저 리스트(1~10건) 
		List<UserVo> userList = ud.selectUserPageList(pageVo);
		
		// 페이지 내비게이션을 위한 전체 유저 리스트 조회 
		int totalUserCnt = ud.getUserCnt();
		
		//리턴해야 하는게 두건일경우에는 (Map)
		// 결과를 담는 map
		Map<String , Object> resultMap = new HashMap<String , Object>();
		resultMap.put("userList",userList);
		//Math.ceil가 올림해주는 부분 
		resultMap.put("pageCnt",
				(int)Math.ceil((double)totalUserCnt / pageVo.getPageSize()));
		
		return resultMap;
		
	}

	/**  * Method   : inserUser
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param : userVo
	  * @return : 리턴은 없다
	  * Method 설명 :  사용자 등록
	*/
	@Override
	public int insertUser(UserVo userVo) {
		return ud.insertUser(userVo);
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
		
		int updateCnt = session.delete("user.updateUser", userVo);
		
		// commit을 해야 데이터가 확정된다 ( 꼭 해주기 !)
		session.commit();
		session.close();
		
		return updateCnt;
	}

}
