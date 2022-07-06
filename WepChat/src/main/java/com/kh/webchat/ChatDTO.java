package com.kh.webchat;

public class ChatDTO {
	private String nickname;
	private String message;
	
	public ChatDTO() {}
	public ChatDTO(String nickname, String message) {
		super();
		this.nickname = nickname;
		this.message = message;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
