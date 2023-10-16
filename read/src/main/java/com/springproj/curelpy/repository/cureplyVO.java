package com.springproj.curelpy.repository;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class cureplyVO {
	private int cuseq;
	private int cuseqs;
	private String id;
	private String password;
	private String cucontents;
	private Date curegDate;
	private int cucnt;
	private String searchCondition; // 검색 기능 추가
	private String searchKeyword; // 검색 기능 추가
	private int pageNum;
	private int amount;
	
	
	@Override
	public String toString() {
		return "cureplyVO [cuseq=" + cuseq + ", cuseqs=" + cuseqs + ", id=" + id + ", password=" + password
				+ ", cucontents=" + cucontents + ", curegDate=" + curegDate + ", cucnt=" + cucnt + ", searchCondition="
				+ searchCondition + ", searchKeyword=" + searchKeyword + ", pageNum=" + pageNum + ", amount=" + amount
				+ "]";
	}
	
	
	


	public int getCuseq() {
		return cuseq;
	}




	public void setCuseq(int cuseq) {
		this.cuseq = cuseq;
	}





	public int getCuseqs() {
		return cuseqs;
	}




	public void setCuseqs(int cuseqs) {
		this.cuseqs = cuseqs;
	}




	public String getCucontents() {
		return cucontents;
	}




	public void setCucontents(String cucontents) {
		this.cucontents = cucontents;
	}




	public Date getCuregDate() {
		return curegDate;
	}




	public void setCuregDate(Date curegDate) {
		this.curegDate = curegDate;
	}




	public int getCucnt() {
		return cucnt;
	}




	public void setCucnt(int cucnt) {
		this.cucnt = cucnt;
	}




	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
