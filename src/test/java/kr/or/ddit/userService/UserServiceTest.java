package kr.or.ddit.userService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import kr.or.ddit.db.TempDao;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.userDao.UserDao;
import kr.or.ddit.user.userDao.UserDaoInf;
import kr.or.ddit.user.userService.UserService;
import kr.or.ddit.user.userService.UserServiceInf;

import org.apache.ibatis.annotations.ResultMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserServiceTest {
	
	
	
	// junit 실행주기 
	// @BeforeClass 이 적용된 메소드 실행 (최초1회) 
	// @Before 어노테이션이 적용된 메소드 실행 (테스트 메소드 실행전 실행) , 단 static 메소드로 선언 
	// @Test 실행 (3개가 있음)
	// @After 어노테이션이 적용된 메소드 실행(테스트 메소드 실행후 실행) 
	// @AfterClass 어보테이션이 적용된 메소드 실행(최초1회) , 단 static 메소드로 선언 
	
	// beforeClass 
	// before --> selectUserAll --> after
	// before --> selectUser(String) --> after
	// before --> selectUser(UserVo) --> after
	//afterClass로 실행
	
	private UserService userService;
	private final String TETUSERID = "test";
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("beforeClass");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("afterClass");
	}
	
	@Before
	public void beore(){
		System.out.println("before");
		userService = new UserService();
		userService.deleteUser(TETUSERID);
	}
	
	@After
	public void after(){
		System.out.println("after");
	}
	
	// DB에 jspuser 부분의 회원이 몇명있는지 확인하는 부분 
	// 운영메소드 이름 + Test
	@Test
	public void selectUserAllTest() {
		/***Given : 주어진 상황 ***/
	
		
		/***When : 어떤 동작 수행(메소드 호출)***/
		List<UserVo> list = userService.selectUserAll();
		System.out.println(list);
		

		//select 'X' as result from dual
		//result : X
		
		/***Then : 결과가 어떠해야하는지 정의 ***/
		//assertEquals(5,list.size());
				
	}
	
	//회원 정보 조회 
	@Test
	public void selectUser(){
		/***Given : 주어진 상황 ***/

		
		/***When : 어떤 동작 수행(메소드 호출)***/
		// ()괄호 안에 값을 넣어주기  -> 비교할값
		UserVo user = userService.selectUser("brown");
		
		/***Then : 결과가 어떠해야하는지 정의 ***/
		assertEquals("brown" ,user.getUserId());
		assertNotNull(user);

	}
	
	@Test
	public void selectUserByVo(){
		/***Given : 주어진 상황 ***/
		
		// selectUserByVo할떄 DB에 N.N로 설정된 부분은 꼭 필요한것들 값을 넣어 보내줘야 한다
		UserVo userVo = new UserVo();
		userVo.setUserId("brown");
		userVo.setName("브라운");
		userVo.setPass("brownpass");
	
		/***When : 어떤 동작 수행(메소드 호출)***/
		// ()괄호 안에 값을 넣어주기  -> 비교할값
		UserVo user = userService.selectUserByVo(userVo);

		/***Then : 결과가 어떠해야하는지 정의 ***/
		assertEquals("brown" ,user.getUserId());
		assertNotNull(user);
	}
	
	// 페이징 처리 
	@Test
	public void selectUserPageList(){
		/***Given : 주어진 상황 ***/
	
		PageVo userPage = new PageVo();
		userPage.setPage(1);
		userPage.setPageSize(10);
		
		/***When : 어떤 동작 수행(메소드 호출)***/
		Map<String , Object> resultMap = userService.selectUserPageList(userPage);
		
		List<UserVo> userList = (List<UserVo>)resultMap.get("userList");
		
		int pageCnt = (Integer)resultMap.get("pageCnt");

		/***Then : 결과가 어떠해야하는지 정의 ***/
		assertEquals(10 ,userList.size());
		assertEquals(11 ,pageCnt);
	}
	
	// 테스트 이름은 메서드뒤에 test입력하기 
	@Test
	public void inserUserTest(){
		/***Given : 주어진 상황 ***/
		// userVo 준비 

		UserVo userVo = new UserVo();
			
		userVo.setUserId("test");
		userVo.setName("테스트");
		userVo.setPass("pass");
		userVo.setAddr1("세종시");
		userVo.setAddr2("아름동");
		
		GregorianCalendar gr = new GregorianCalendar();
		userVo.setBirth(new Date(gr.getTimeInMillis()));
		
		userVo.setZipcd("39419");
		userVo.setEmail("laswl4090@gmail.com");
		userVo.setTel("0448674090");
		

		/***When : 어떤 동작 수행(메소드 호출)***/
		// userDao.insertUser()
		
		int result = userService.insertUser(userVo);

		/***Then : 결과가 어떠해야하는지 정의 ***/
		// 입력건수 비교 
		
		assertEquals(1,result);

		
	}
	
	

}
