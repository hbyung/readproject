package com.springproj.member.repository;

public class memberVO {
	
	private String id;
	private String password;
	private String name;
	private String email;
	private int rank;
	private int rank1;
	private int rank2;
	private int blackrank;
	
	private String cuseq;
	private String searchCondition; // 검색 기능 추가
	private String searchKeyword; // 검색 기능 추가
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public int getRank1() {
		return rank1;
	}
	public void setRank1(int rank1) {
		this.rank1 = rank1;
	}
	public int getRank2() {
		return rank2;
	}
	public void setRank2(int rank2) {
		this.rank2 = rank2;
	}
	public String getCuseq() {
		return cuseq;
	}
	public void setCuseq(String cuseq) {
		this.cuseq = cuseq;
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
	
	public int getBlackrank() {
		return blackrank;
	}
	public void setBlackrank(int blackrank) {
		this.blackrank = blackrank;
	}
	
	
}
