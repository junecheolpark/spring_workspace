package com.ry.board;

public class Board_masterDTO {
	private int MASTER_BOARD_IDX; // 게시판 idx
	private int BOARD_TP; // 게시판 종류
	private int VIEW_TP; // 보기구분
	private String REG_DATE; // 등록일시
	private int REG_IDX; // 등록자 idx
	private String MOD_DATE; // 수정일시
	private int MOD_DIX; // 수정자 idx
	private String BOARD_NM; // 게시글이름
	
	public Board_masterDTO () {};
	public Board_masterDTO(int mASTER_BOARD_IDX, int bOARD_TP, int vIEW_TP, String rEG_DATE, int rEG_IDX,
			String mOD_DATE, int mOD_DIX, String bOARD_NM) {
		super();
		MASTER_BOARD_IDX = mASTER_BOARD_IDX;
		BOARD_TP = bOARD_TP;
		VIEW_TP = vIEW_TP;
		REG_DATE = rEG_DATE;
		REG_IDX = rEG_IDX;
		MOD_DATE = mOD_DATE;
		MOD_DIX = mOD_DIX;
		BOARD_NM = bOARD_NM;
	}
	public int getMASTER_BOARD_IDX() {
		return MASTER_BOARD_IDX;
	}
	public void setMASTER_BOARD_IDX(int mASTER_BOARD_IDX) {
		MASTER_BOARD_IDX = mASTER_BOARD_IDX;
	}
	public int getBOARD_TP() {
		return BOARD_TP;
	}
	public void setBOARD_TP(int bOARD_TP) {
		BOARD_TP = bOARD_TP;
	}
	public int getVIEW_TP() {
		return VIEW_TP;
	}
	public void setVIEW_TP(int vIEW_TP) {
		VIEW_TP = vIEW_TP;
	}
	public String getREG_DATE() {
		return REG_DATE;
	}
	public void setREG_DATE(String rEG_DATE) {
		REG_DATE = rEG_DATE;
	}
	public int getREG_IDX() {
		return REG_IDX;
	}
	public void setREG_IDX(int rEG_IDX) {
		REG_IDX = rEG_IDX;
	}
	public String getMOD_DATE() {
		return MOD_DATE;
	}
	public void setMOD_DATE(String mOD_DATE) {
		MOD_DATE = mOD_DATE;
	}
	public int getMOD_DIX() {
		return MOD_DIX;
	}
	public void setMOD_DIX(int mOD_DIX) {
		MOD_DIX = mOD_DIX;
	}
	public String getBOARD_NM() {
		return BOARD_NM;
	}
	public void setBOARD_NM(String bOARD_NM) {
		BOARD_NM = bOARD_NM;
	}
	@Override
	public String toString() {
		return "Board_masterDTO [MASTER_BOARD_IDX=" + MASTER_BOARD_IDX + ", BOARD_TP=" + BOARD_TP + ", VIEW_TP="
				+ VIEW_TP + ", REG_DATE=" + REG_DATE + ", REG_IDX=" + REG_IDX + ", MOD_DATE=" + MOD_DATE + ", MOD_DIX="
				+ MOD_DIX + ", BOARD_NM=" + BOARD_NM + "]";
	}
	
	
	
	
	
	
}
