package com.geekidentity.lucene;

public class Article {
	private Integer id;
	private String title;
	private String content;
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Article(int id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}
	public Article() {
		// TODO Auto-generated constructor stub
	}

	
}
