package com.kh.app01.notice;

public class NoticeVo {
	
	private String title;
	private String content;
	
	public NoticeVo() {
		
	}

	public NoticeVo(String title, String content) {
		super();
		this.title = title;
		this.content = content;
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

	@Override
	public String toString() {
		return "NoticeVo [title=" + title + ", content=" + content + "]";
	}
	
	

}
