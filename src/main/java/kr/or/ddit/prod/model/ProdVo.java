package kr.or.ddit.prod.model;

import java.util.Date;

public class ProdVo {
	
	private String prod_id;
	private String prod_name;
	private String prod_lgu;
	private String lprod_nm;
	private Date prod_insdate;
	
	private String buyer_name;
	private String buyer_mail;
	
	
	
	
	
	public String getBuyer_name() {
		return buyer_name;
	}

	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}

	public String getBuyer_mail() {
		return buyer_mail;
	}

	public void setBuyer_mail(String buyer_mail) {
		this.buyer_mail = buyer_mail;
	}

	// 기본생성자
	public ProdVo() {
		
	}
	
	
	// 페이징 처리
	private int rnum;


	public String getProd_id() {
		return prod_id;
	}

	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public String getProd_lgu() {
		return prod_lgu;
	}

	public void setProd_lgu(String prod_lgu) {
		this.prod_lgu = prod_lgu;
	}

	public String getLprod_nm() {
		return lprod_nm;
	}

	public void setLprod_nm(String lprod_nm) {
		this.lprod_nm = lprod_nm;
	}

	public Date getProd_insdate() {
		return prod_insdate;
	}

	public void setProd_insdate(Date prod_insdate) {
		this.prod_insdate = prod_insdate;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	
	
	
	

}
