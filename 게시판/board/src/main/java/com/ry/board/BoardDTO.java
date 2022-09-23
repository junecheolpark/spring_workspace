package com.ry.board;

public class BoardDTO {
	private int BOARD_IDX;// 게시물
	private int MASTER_BOARD_IDX; //게시판
	private int PARENT_IDX; //상위게시물
	private int IS_NOTICE; // 공지구분
	private boolean IS_SECRET; // 비밀글 여부
	private String PWD; //비밀번호
	private int BOARD_THREAD; //게시물 정렬
	private int BOARD_DEPTH; //기시물 단계
	private String REG_NM; //작성자
	private int READ_CNT; //조회수
	private String SUBJ; //제목
	private String CONTS; //내용
	private boolean IS_SHOW; //노출여부
	private String REG_DATE; //등록일시
	private int REG_IDX; // 등록자
	private String MOD_DATE; // 수정일시
	private int MOD_IDX; // 수정자 IDX
	
	public BoardDTO () {}

	public BoardDTO(int bOARD_IDX, int mASTER_BOARD_IDX, int pARENT_IDX, int iS_NOTICE, boolean iS_SECRET, String pWD,
			int bOARD_THREAD, int bOARD_DEPTH, String rEG_NM, int rEAD_CNT, String sUBJ, String cONTS, boolean iS_SHOW,
			String rEG_DATE, int rEG_IDX, String mOD_DATE, int mOD_IDX) {
		super();
		BOARD_IDX = bOARD_IDX;
		MASTER_BOARD_IDX = mASTER_BOARD_IDX;
		PARENT_IDX = pARENT_IDX;
		IS_NOTICE = iS_NOTICE;
		IS_SECRET = iS_SECRET;
		PWD = pWD;
		BOARD_THREAD = bOARD_THREAD;
		BOARD_DEPTH = bOARD_DEPTH;
		REG_NM = rEG_NM;
		READ_CNT = rEAD_CNT;
		SUBJ = sUBJ;
		CONTS = cONTS;
		IS_SHOW = iS_SHOW;
		REG_DATE = rEG_DATE;
		REG_IDX = rEG_IDX;
		MOD_DATE = mOD_DATE;
		MOD_IDX = mOD_IDX;
	}

	public int getBOARD_IDX() {
		return BOARD_IDX;
	}

	public int getMASTER_BOARD_IDX() {
		return MASTER_BOARD_IDX;
	}

	public int getPARENT_IDX() {
		return PARENT_IDX;
	}

	public int getIS_NOTICE() {
		return IS_NOTICE;
	}

	public boolean isIS_SECRET() {
		return IS_SECRET;
	}

	public String getPWD() {
		return PWD;
	}

	public int getBOARD_THREAD() {
		return BOARD_THREAD;
	}

	public int getBOARD_DEPTH() {
		return BOARD_DEPTH;
	}

	public String getREG_NM() {
		return REG_NM;
	}

	public int getREAD_CNT() {
		return READ_CNT;
	}

	public String getSUBJ() {
		return SUBJ;
	}

	public String getCONTS() {
		return CONTS;
	}

	public boolean isIS_SHOW() {
		return IS_SHOW;
	}

	public String getREG_DATE() {
		return REG_DATE;
	}

	public int getREG_IDX() {
		return REG_IDX;
	}

	public String getMOD_DATE() {
		return MOD_DATE;
	}

	public int getMOD_IDX() {
		return MOD_IDX;
	}

	public void setBOARD_IDX(int bOARD_IDX) {
		BOARD_IDX = bOARD_IDX;
	}

	public void setMASTER_BOARD_IDX(int mASTER_BOARD_IDX) {
		MASTER_BOARD_IDX = mASTER_BOARD_IDX;
	}

	public void setPARENT_IDX(int pARENT_IDX) {
		PARENT_IDX = pARENT_IDX;
	}

	public void setIS_NOTICE(int iS_NOTICE) {
		IS_NOTICE = iS_NOTICE;
	}

	public void setIS_SECRET(boolean iS_SECRET) {
		IS_SECRET = iS_SECRET;
	}

	public void setPWD(String pWD) {
		PWD = pWD;
	}

	public void setBOARD_THREAD(int bOARD_THREAD) {
		BOARD_THREAD = bOARD_THREAD;
	}

	public void setBOARD_DEPTH(int bOARD_DEPTH) {
		BOARD_DEPTH = bOARD_DEPTH;
	}

	public void setREG_NM(String rEG_NM) {
		REG_NM = rEG_NM;
	}

	public void setREAD_CNT(int rEAD_CNT) {
		READ_CNT = rEAD_CNT;
	}

	public void setSUBJ(String sUBJ) {
		SUBJ = sUBJ;
	}

	public void setCONTS(String cONTS) {
		CONTS = cONTS;
	}

	public void setIS_SHOW(boolean iS_SHOW) {
		IS_SHOW = iS_SHOW;
	}

	public void setREG_DATE(String rEG_DATE) {
		REG_DATE = rEG_DATE;
	}

	public void setREG_IDX(int rEG_IDX) {
		REG_IDX = rEG_IDX;
	}

	public void setMOD_DATE(String mOD_DATE) {
		MOD_DATE = mOD_DATE;
	}

	public void setMOD_IDX(int mOD_IDX) {
		MOD_IDX = mOD_IDX;
	}

	@Override
	public String toString() {
		return "BoardDTO [BOARD_IDX=" + BOARD_IDX + ", MASTER_BOARD_IDX=" + MASTER_BOARD_IDX + ", PARENT_IDX="
				+ PARENT_IDX + ", IS_NOTICE=" + IS_NOTICE + ", IS_SECRET=" + IS_SECRET + ", PWD=" + PWD
				+ ", BOARD_THREAD=" + BOARD_THREAD + ", BOARD_DEPTH=" + BOARD_DEPTH + ", REG_NM=" + REG_NM
				+ ", READ_CNT=" + READ_CNT + ", SUBJ=" + SUBJ + ", CONTS=" + CONTS + ", IS_SHOW=" + IS_SHOW
				+ ", REG_DATE=" + REG_DATE + ", REG_IDX=" + REG_IDX + ", MOD_DATE=" + MOD_DATE + ", MOD_IDX=" + MOD_IDX
				+ "]";
	};
	
	
}
