package com.geekidentity.es;

import io.searchbox.annotations.JestId;

public class News {
	@JestId
	private long id;
	private String title;
	private String content;
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public News() {
	}
	public News(long id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
}
