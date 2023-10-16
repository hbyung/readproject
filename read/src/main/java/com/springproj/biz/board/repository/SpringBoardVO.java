package com.springproj.biz.board.repository;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class SpringBoardVO { //VO(Value Object, ~DTO, ~BEAN
	private int auseq;
	private String autitle;
	private String auwriter;
	private String aucontent;
	private Date auregDate;
	private int aucnt;
	private String searchCondition; // 검색 기능 추가
	private String searchKeyword; // 검색 기능 추가
	private MultipartFile uploadFile; // 파일 첨부 기능 추가
	private int pageNum;
	private int amount;
	
	@Override
	public String toString() {
		String info = 
				"SpringBoardVO[auseq:"+auseq
			   +", autitle:"+autitle
			   +", auwriter:"+auwriter
			   +", aucontent:"+aucontent
			   +", auregDate:"+auregDate
			   +", aucnt:"+aucnt+"]";
		
		return info;
	}
	
	

	public int getAuseq() {
		return auseq;
	}



	public void setAuseq(int auseq) {
		this.auseq = auseq;
	}



	public String getAutitle() {
		return autitle;
	}



	public void setAutitle(String autitle) {
		this.autitle = autitle;
	}



	public String getAuwriter() {
		return auwriter;
	}



	public void setAuwriter(String auwriter) {
		this.auwriter = auwriter;
	}



	public String getAucontent() {
		return aucontent;
	}



	public void setAucontent(String aucontent) {
		this.aucontent = aucontent;
	}



	public Date getAuregDate() {
		return auregDate;
	}



	public void setAuregDate(Date auregDate) {
		this.auregDate = auregDate;
	}



	public int getAucnt() {
		return aucnt;
	}



	public void setAucnt(int aucnt) {
		this.aucnt = aucnt;
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

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
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


