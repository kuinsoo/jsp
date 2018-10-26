package kr.or.ddit.user.userDao;

import java.util.List;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;


public interface UserDaoInf {
	
	// jspuser 테이블 테이터 전체 조회 쿼리 
	// select query id : selectUserAll
	public List<UserVo> selectUserAll();
	
	// jspuser 테이블 테이터 전체 조회 쿼리 
	// select query id : selectUserAll
	public UserVo selectUser(String userId);
	
	
	// vo로 매개변수설정한후 vo로 가지고 오는 쿼리 
	public UserVo selectUserByVo(UserVo userVo);
	
	
	// 페이징 처리
	public List<UserVo> selectUserPageList(PageVo pageVo);
	
	
	/**  * Method   : getUserCnt
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @return
	  * Method 설명 :  사용자 전체 건수 조회 
	*/
	int getUserCnt();
	
	/**  * Method   : inserUser
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param : userVo
	  * @return : 리턴은 없다
	  * Method 설명 :  사용자 등록
	*/
	int insertUser(UserVo userVo);
	
	
	/**  * Method   : deleteUser
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param userID
	  * @return
	  * Method 설명 :  사용자 삭제 
	*/
	int deleteUser(String userId);
	
	
	
	/**  * Method   : updateUser
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param userId
	  * @return
	  * Method 설명 :  사용자 정보 수정
	*/
	int updateUser(UserVo userVo);
	

}
