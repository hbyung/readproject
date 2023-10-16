


package com.springproj.free.repository;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class FreeBoardVO {
	private int seq;
	private String ttl;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	private String searchCondition; // 검색 기능 추가
	private String searchKeyword; // 검색 기능 추가
	private MultipartFile uploadFile; // 파일 첨부 기능 추가
	private int pageNum;
	private int amount;
	private int seqs;
	private String id;
	private String password;
	private String name;
	private String email;
	private String contents;
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
	private int auseq;
	private String autitle;
	private String auwriter;
	private String aucontent;
	private Date auregDate;
	private int aucnt;
	private int cuseq;
	private String cutitle;
	private String cuwriter;
	private String cucontent;
	private Date curegdate;
	private int cucnt;
	
	@Override
	public String toString() {
		return "FreeBoardVO [seq=" + seq + ", ttl=" + ttl + ", writer=" + writer + ", content=" + content
				+ ", regDate=" + regDate + ", cnt=" + cnt + ", searchCondition=" + searchCondition + ", searchKeyword="
				+ searchKeyword + ", uploadFile=" + uploadFile + ", pageNum=" + pageNum + ", amount=" + amount + "]";
	}
	
	
	
	public int getSeqs() {
		return seqs;
	}


	public void setSeqs(int seqs) {
		this.seqs = seqs;
	}


	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTtl() {
		return ttl;
	}
	public void setTtl(String ttl) {
		this.ttl = ttl;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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

	public void setContents(String contents) {
		this.contents = contents;
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

	public void setSummary(String smmary) {
		this.summary = smmary;
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



	public int getCuseq() {
		return cuseq;
	}



	public void setCuseq(int cuseq) {
		this.cuseq = cuseq;
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
	
	
	
	
	
	
	
	
}
