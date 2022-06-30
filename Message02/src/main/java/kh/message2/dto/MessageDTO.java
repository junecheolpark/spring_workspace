package kh.message2.dto;

public class MessageDTO {
	private int no;
	private String nickname;
	private String message;
	
	public MessageDTO() {}
	public MessageDTO(int no, String nickname, String message) {
		super(); 
		this.no = no;
		this.nickname = nickname;
		this.message = message; 
	}	
	
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNickname() {
		return this.nickname;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return this.message;
	}
	@Override
	public String toString() {
		return "MessageDTO [no=" + no + ", nickname=" + nickname + ", message=" + message + "]";
	}

	
	
}
