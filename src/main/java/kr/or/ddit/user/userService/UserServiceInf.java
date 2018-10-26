package kr.or.ddit.user.userService;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface UserServiceInf {
	
	// jspuser 테이블 테이터 전체 조회 쿼리 
	// select query id : selectUserAll
	List<UserVo> selectUserAll();
	
	// jspuser 테이블 테이터 전체 조회 쿼리 
	// select query id : selectUserAll
	UserVo selectUser(String userId);
	
	
	// vo로 매개변수설정한후 vo로 가지고 오는 쿼리 
	UserVo selectUserByVo(UserVo userVo);
	
	
	/**  * Method   : selectUserPageList
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param pageVo
	  * @return
	  * Method 설명 :  사용자 페이징 조회
	*/
	// 페이징 처리하는 방법
	Map<String , Object> selectUserPageList(PageVo pageVo);
	
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
