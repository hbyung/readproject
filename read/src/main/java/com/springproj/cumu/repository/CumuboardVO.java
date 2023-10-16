package com.springproj.cumu.repository;

import java.sql.Date;

public class CumuboardVO {
	private int cuseq;
	private int cuseqs;
	private String cutitle;
	private String cuwriter;
	private String cucontent;
	private Date curegdate;
	private int cucnt;
	private String id;
	private String password;
	private String cucontents;
	private String SearchCondition;
	private String SearchKeyword;
	
	
	@Override
	public String toString() {
		return "CumuboardVO [cuseq=" + cuseq + ", cutitle=" + cutitle + ", cuwriter=" + cuwriter + ", cucontent="
				+ cucontent + ", curegdate=" + curegdate + ", cucnt=" + cucnt + ", id=" + id + ", password=" + password
				+ ", cucontents=" + cucontents + "]";
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


	public String getCutitle() {
		return cutitle;
	}


	public void setCutitle(String cutitle) {
		this.cutitle = cutitle;
	}


	public String getCuwriter() {
		return cuwriter;
	}


	public void setCuwriter(String cuwriter) {
		this.cuwriter = cuwriter;
	}


	public String getCucontent() {
		return cucontent;
	}


	public void setCucontent(String cucontent) {
		this.cucontent = cucontent;
	}


	public Date getCuregdate() {
		return curegdate;
	}


	public void setCuregdate(Date curegdate) {
		this.curegdate = curegdate;
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



	public String getCucontents() {
		return cucontents;
	}


	public void setCucontents(String cucontents) {
		this.cucontents = cucontents;
	}


	public String getSearchCondition() {
		return SearchCondition;
	}


	public void setSearchCondition(String searchCondition) {
		SearchCondition = searchCondition;
	}


	public String getSearchKeyword() {
		return SearchKeyword;
	}


	public void setSearchKeyword(String searchKeyword) {
		SearchKeyword = searchKeyword;
	}

	
	

	
	


}
