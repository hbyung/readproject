package com.springproj.book.repository;

import java.util.List;

public class test1 {
	private List<String> isbn;
	private List<String> title;
	private List<String> author;
	private List<String> genre;
	
	

	public List<String> getIsbn() {
		return isbn;
	}

	public void setIsbn(List<String> isbn) {
		this.isbn = isbn;
	}

	public List<String> getTitle() {
		return title;
	}

	public void setTitle(List<String> title) {
		this.title = title;
	}

	public List<String> getAuthor() {
		return author;
	}

	public void setAuthor(List<String> author) {
		this.author = author;
	}

	public List<String> getGenre() {
		return genre;
	}

	public void setGenre(List<String> genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "[test1 [isbn:" + isbn + ", title:" + title + ", author:" + author + ", genre:" + genre + "]]";
	}

}
