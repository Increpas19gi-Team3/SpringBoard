package dto;
/**
 * SB_BOARD
 * @author 2-17
 * 게시판 테이블
 */

import java.sql.Date;

import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.internal.NotNull;

public class BoardDTO {

	private int NUM;			//게시글 번호, NUMBER(7)	NOT NULL, 시퀀스
	private String ISNOTICE;	//공지글 여부, CHAR(1)	1-공지글, 0-일반글
	private String ISBLOCK;		//블록 여부, CHAR(1)	1-블록, 0-일반글
	@NotBlank(message="제목을 입력해주세요")
	private String TITLE;		//제목,	VARCHAR2(50)
	@NotBlank(message="작성자를 입력해주세요")
	private String WRITER;		//작성자, VARCHAR2(20)
	@NotBlank(message="비밀번호를 입력해주세요")
	private String PWD;			//비밀번호, VARCHAR2(20)
	@NotNull
	@Max(value=3000,message="1500자 이하")
	private String CONTENTS;	//글내용, VARCHAR2(3000)
	private String IMGNAME;		//이미지파일명, VARCHAR2(500)
	private int COUNT;			//조회수, NUMBER(4)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date REGTIME;		//작성일, DATE
	
	
	public int getNUM() {
		return NUM;
	}
	public void setNUM(int nUM) {
		NUM = nUM;
	}
	public String getISNOTICE() {
		return ISNOTICE;
	}
	public void setISNOTICE(String iSNOTICE) {
		ISNOTICE = iSNOTICE;
	}
	public String getISBLOCK() {
		return ISBLOCK;
	}
	public void setISBLOCK(String iSBLOCK) {
		ISBLOCK = iSBLOCK;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getWRITER() {
		return WRITER;
	}
	public void setWRITER(String wRITER) {
		WRITER = wRITER;
	}
	public String getPWD() {
		return PWD;
	}
	public void setPWD(String pWD) {
		PWD = pWD;
	}
	public String getCONTENTS() {
		return CONTENTS;
	}
	public void setCONTENTS(String cONTENTS) {
		CONTENTS = cONTENTS;
	}
	public String getIMGNAME() {
		return IMGNAME;
	}
	public void setIMGNAME(String iMGNAME) {
		IMGNAME = iMGNAME;
	}
	public int getCOUNT() {
		return COUNT;
	}
	public void setCOUNT(int cOUNT) {
		COUNT = cOUNT;
	}
	public Date getREGTIME() {
		return REGTIME;
	}
	public void setREGTIME(Date rEGTIME) {
		REGTIME = rEGTIME;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [NUM=" + NUM + ", ISNOTICE=" + ISNOTICE + ", ISBLOCK=" + ISBLOCK + ", TITLE=" + TITLE
				+ ", WRITER=" + WRITER + ", PWD=" + PWD + ", CONTENTS=" + CONTENTS + ", IMGNAME=" + IMGNAME + ", COUNT="
				+ COUNT + ", REGTIME=" + REGTIME + "]";
	}
	
}
