package org.sc.bean;

public class PostCount {
	 private String author;
	 private String count;
	 public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public PostCount(String author, String count) {
		super();
		this.author = author;
		this.count = count;
	}
	public PostCount() {
		super();
	}




}
