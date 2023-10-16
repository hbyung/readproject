package com.springproj.book.repository;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class BookVO {
	private String isbn;
	private String title;
	private String author;
	private String genre;
	private String publisher;
	private String image;
	private int bcount;
	private String summary;
	private int hit;
	private Date bdate;
	private String searchCondition; // 검색 기능 추가
	private String searchKeyword; // 검색 기능 추가
	private MultipartFile uploadFile; // 파일 첨부 기능 추가

	@Override
	public String toString() {
		String info = "BookVO[isbn:" +isbn+ ", +title:" +title+ ", author:" + author
				+ ", genre:" + genre + ", publisher:" + publisher + ", image:" + image 
				+ ", bcount:" + bcount + ", summary:" + summary + ", hit:" + hit + ", bdate:" + bdate + "]";
		return info;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getBcount() {
		return bcount;
	}

	public void setBcount(int bcount) {
		this.bcount = bcount;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
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


}
