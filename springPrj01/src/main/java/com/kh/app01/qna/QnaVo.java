package com.kh.app01.qna;

public class QnaVo {
	
	private String title;
	private String content;
	
	public QnaVo () {
		
	}

	public QnaVo(String title, String content) {
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
		return "QnaVo [title=" + title + ", content=" + content + "]";
	}
	
	

}
