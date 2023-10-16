package com.springproj.biz.rental.repository;

import java.sql.Date;

public class BookRentalVO { //VO(Value Object, ~DTO, ~BEAN
	private String risbn;
	private String remail;
	private String rid;
	private String rtitle;
	private String rauthor;
	private Date rrentalDate;
	private Date rreturnDate;
	private String searchCondition;
	private String searchKeyword;
	//bookVO
	private String title;
	private String author;
	
	// memberVO
	private String id;
	private String password;
	private String name;
	private String email;

	
	
	@Override
	public String toString() {
		String info = 
				"BookRentalVO[isbn:"+risbn
			   +", email:"+remail
			   +", rid:"+rid
			   +", rtitle:"+rtitle
			   +", rauthor:"+rauthor
			   +", rrentalDate:"+rrentalDate
			   +", rreturnDate:"+rreturnDate
			   +", id:"+rid
			   +", password:"+password
			   +", name:"+name
			   +", email:"+email
			   +"]";
		
		return info;
	}


	public String getRisbn() {
		return risbn;
	}


	public void setRisbn(String risbn) {
		this.risbn = risbn;
	}


	public String getRemail() {
		return remail;
	}


	public void setRemail(String remail) {
		this.remail = remail;
	}


	public String getRid() {
		return rid;
	}


	public void setRid(String rid) {
		this.rid = rid;
	}


	public String getRtitle() {
		return rtitle;
	}


	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}


	public String getRauthor() {
		return rauthor;
	}


	public void setRauthor(String rauthor) {
		this.rauthor = rauthor;
	}


	public Date getRrentalDate() {
		return rrentalDate;
	}


	public void setRrentalDate(Date rrentalDate) {
		this.rrentalDate = rrentalDate;
	}


	public Date getRreturnDate() {
		return rreturnDate;
	}


	public void setRreturnDate(Date rreturnDate) {
		this.rreturnDate = rreturnDate;
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


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}

	
	
	
	
}