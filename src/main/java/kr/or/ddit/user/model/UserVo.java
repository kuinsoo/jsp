package kr.or.ddit.user.model;

import java.util.Date;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class UserVo implements HttpSessionBindingListener {

	// userVo에는 userId,name , alias / brown / 브라운 / 곰) 
	private String userId;
	private String name;
	private String alias;
	
	// UserVo DB만들면서 만들것
	private String pass;
	private String addr1;
	private String addr2;
	private String zipcd;
	private Date birth;
	private String email;
	private String tel;
	private String profile;
	
	// 페이징 처리
	private int rnum;

	
	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getZipcd() {
		return zipcd;
	}

	public void setZipcd(String zipcd) {
		this.zipcd = zipcd;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	// 기본생성자
	public UserVo() {

	}
	

	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAlias() {
		return alias;
	}


	public void setAlias(String alias) {
		this.alias = alias;
	}


	/**  * Method   : authPass
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param encryptPass
	  * @return
	  * Method 설명 : 비밀번호 검증 
	*/
	public boolean authPass(String encryptPass) {
		return getPass().equals(encryptPass);
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("userVo : " + event.getName());
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
}
