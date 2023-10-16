package com.springproj.relpy.repository;

import java.sql.Date;

public class replyVO {
	private int seq;
	private int seqs;
	private String id;
	private String password;
	private String contents;
	private Date regDate;
	private int cnt;
	private String searchCondition; // 검색 기능 추가
	private String searchKeyword; // 검색 기능 추가
	private int pageNum;
	private int amount;
	
	@Override
	public String toString() {
		return "replyVO [seq=" + seqs + ", id=" + id + ", password=" + password + ", contents=" + contents + ", regDate="
				+ regDate + ", cnt=" + cnt + ", searchCondition=" + searchCondition + ", searchKeyword=" + searchKeyword
				+ ", pageNum=" + pageNum + ", amount=" + amount + "]";
	}
	
	
	public int getSeq() {
		return seq;
	}

	public void setSeqs(int seqs) {
		this.seqs = seqs;
	}

	public int getSeqs() {
		return seqs;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
	public String getContents() {
		return contents;
	}
	public void setContents(String content) {
		this.contents = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
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
