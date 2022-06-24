package kh.board.file;

public class FileDTO {
	private int seq_file;
	private int seq_board;
	private String content_image;
	
	public FileDTO() {}

	public FileDTO(int seq_file, int seq_board, String content_image) {
		super();
		this.seq_file = seq_file;
		this.seq_board = seq_board;
		this.content_image = content_image;
	}

	public int getSeq_file() {
		return seq_file;
	}

	public void setSeq_file(int seq_file) {
		this.seq_file = seq_file;
	}

	public int getSeq_board() {
		return seq_board;
	}

	public void setSeq_board(int seq_board) {
		this.seq_board = seq_board;
	}

	public String getContent_image() {
		return content_image;
	}

	public void setContent_image(String content_image) {
		this.content_image = content_image;
	}

	@Override
	public String toString() {
		return "FileDTO [seq_file=" + seq_file + ", seq_board=" + seq_board + ", content_image=" + content_image + "]";
	}
	
	

}
