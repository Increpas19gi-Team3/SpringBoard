/* 댓글 컬럼 추가 _ 2017.11.15 */
ALTER TABLE  SB_BOARD ADD (BREF NUMBER , BSTEP NUMBER, BLEVEL NUMBER);


/* SB_관리자 */
CREATE TABLE SB_Admin (
	id VARCHAR2(20) NOT NULL, /* 아이디 */
	name VARCHAR2(20), /* 이름 */
	pwd VARCHAR2(20) /* 비밀번호 */
);

COMMENT ON TABLE SB_Admin IS 'SB_관리자';

COMMENT ON COLUMN SB_Admin.id IS '아이디';

COMMENT ON COLUMN SB_Admin.name IS '이름';

COMMENT ON COLUMN SB_Admin.pwd IS '비밀번호';

CREATE UNIQUE INDEX PK_SB_Admin
	ON SB_Admin (
		id ASC
	);

ALTER TABLE SB_Admin
	ADD
		CONSTRAINT PK_SB_Admin
		PRIMARY KEY (
			id
		);

/* SB_게시판 */
CREATE TABLE SB_Board (
	num NUMBER(7) NOT NULL, /* 게시판 번호 */
	isNotice CHAR(1), /* 공지사항여부 1:공지사항, 0:일반글*/
	isBlock CHAR(1), /* 블락여부 1:블락, 0:일반글*/
	title VARCHAR2(50), /* 제목 */
	writer VARCHAR2(20), /* 작성자 */
	pwd VARCHAR2(20), /* 비밀번호 */
	contents VARCHAR2(3000), /* 내용 */
	imgName VARCHAR2(500), /* 이미지파일명 */
	count NUMBER(4), /* 조회수 */
	regTime DATE /* 작성시간 */
);

COMMENT ON TABLE SB_Board IS 'SB_게시판';

COMMENT ON COLUMN SB_Board.num IS '게시판 번호';

COMMENT ON COLUMN SB_Board.isNotice IS '공지사항여부';

COMMENT ON COLUMN SB_Board.isBlock IS '블락여부';

COMMENT ON COLUMN SB_Board.title IS '제목';

COMMENT ON COLUMN SB_Board.writer IS '작성자';

COMMENT ON COLUMN SB_Board.pwd IS '비밀번호';

COMMENT ON COLUMN SB_Board.contents IS '내용';

COMMENT ON COLUMN SB_Board.imgName IS '이미지파일명';

COMMENT ON COLUMN SB_Board.count IS '조회수';

COMMENT ON COLUMN SB_Board.regTime IS '작성시간';

CREATE UNIQUE INDEX PK_SB_Board
	ON SB_Board (
		num ASC
	);

ALTER TABLE SB_Board
	ADD
		CONSTRAINT PK_SB_Board
		PRIMARY KEY (
			num
		);


-- 시퀀스 생성
CREATE SEQUENCE SB_BOARD_SEQ
  START WITH 1
  INCREMENT BY 1
  MAXVALUE 10000;


-- 데이터 삽입
insert into SB_ADMIN values('admin', '관리자', '1234');


INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '1', '1', '공지사항 제목 블락', '관리자', '1234', '공지사항공지사항공지사항', 'Penguins.jpg', 0, sysdate);

INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글 제목1', '한범석', '1234', '일반글일반글', 'Penguins.jpg', 0, sysdate);

INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '1', '일반글 제목2 블락블락', '한범석', '1234', '나쁜글나쁜글', 'Penguins.jpg', 0, sysdate);

INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글 제목3', '손가연', '1234', '일반글일반글', 'Penguins.jpg', 0, sysdate);

INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글 제목4', 'han', '1234', '일반글일반글4', 'Penguins.jpg', 0, sysdate);

INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글 제목5', 'han', '1234', '일반글일반글5', 'Penguins.jpg', 0, sysdate);

INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '공지사항글 제목6', 'han', '1234', '공지사항내용5', 'Penguins.jpg', 0, sysdate);

INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '답글0', 'son', '1234', 'bref:0_bstep:0_blevel:0', 'Penguins.jpg', 0, sysdate, 0, 0, 0);

INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '답글1', 'son', '1234', 'bref:1_bstep:0_blevel:0', 'Penguins.jpg', 0, sysdate, 1, 0, 0);

INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '답글2', 'son', '1234', 'bref:1_bstep:1_blevel:0', 'Penguins.jpg', 0, sysdate, 1, 1, 0);

INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '답글3', 'son', '1234', 'bref:1_bstep:1_blevel:1', 'Penguins.jpg', 0, sysdate, 1, 1, 1);

INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '답글4', 'son', '1234', 'bref:2_bstep:1_blevel:1', 'Penguins.jpg', 0, sysdate, 2, 1, 1);

INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '답글5', 'son', '1234', 'bref:2_bstep:2_blevel:2', 'Penguins.jpg', 0, sysdate, 2, 2, 1);

INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '답글6', 'son', '1234', 'bref:2_bstep:2_blevel:2', 'Penguins.jpg', 0, sysdate, 2, 2, 2);

INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '답글7', 'son', '1234', 'bref:3_bstep:2_blevel:2', 'Penguins.jpg', 0, sysdate, 3, 2, 2);

INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '답글8', 'son', '1234', 'bref:3_bstep:3_blevel:2', 'Penguins.jpg', 0, sysdate, 3, 3, 2);

INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '답글9', 'son', '1234', 'bref:3_bstep:3_blevel:3', 'Penguins.jpg', 0, sysdate, 3, 3, 3);

