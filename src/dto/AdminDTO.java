package dto;

/**
 * SB_ADMIN
 * @author 손가연
 * 관리자 정보 테이블
 */
public class AdminDTO {

	private String ID;	//아이디	VARCHAR2(20) NOT NULL 
	private String NAME;//이름		VARCHAR2(20) 
	private String PWD;	//비밀번호	VARCHAR2(20) 
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getPWD() {
		return PWD;
	}
	public void setPWD(String pWD) {
		PWD = pWD;
	}
	
	
	@Override
	public String toString() {
		return "AdminDTO [ID=" + ID + ", NAME=" + NAME + ", PWD=" + PWD + "]";
	}

	
}
