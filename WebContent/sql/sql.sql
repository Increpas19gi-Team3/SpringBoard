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
  

  
/* 댓글 컬럼 추가 _ 2017.11.15 */
ALTER TABLE  SB_BOARD ADD (BREF NUMBER , BSTEP NUMBER, BLEVEL NUMBER);  



-- 데이터 삽입
insert into SB_ADMIN values('admin', '관리자', '1234');



INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '1', '1', '공지사항 제목 블락', '관리자', '1234', '공지사항공지사항공지사항', 'Penguins.jpg', 0, sysdate, 1, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글 제목1', '한범석', '1234', '일반글일반글', 'Penguins.jpg', 0, sysdate, 2, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '1', '일반글 제목2 블락블락', '한범석', '1234', '나쁜글나쁜글', 'Penguins.jpg', 0, sysdate, 3, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글 제목3', '손가연', '1234', '일반글일반글', 'Penguins.jpg', 0, sysdate, 4, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글 제목4', 'han', '1234', '일반글일반글4', 'Penguins.jpg', 0, sysdate, 5, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글 제목5', 'han', '1234', '일반글일반글5', 'Penguins.jpg', 0, sysdate, 6, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '공지사항글 제목6', 'han', '1234', '공지사항내용5', 'Penguins.jpg', 0, sysdate, 7, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '답글1', 'son', '1234', 'bref:1_bstep:0_blevel:0', 'Penguins.jpg', 0, sysdate, 1, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '답글2', 'son', '1234', 'bref:1_bstep:1_blevel:0', 'Penguins.jpg', 0, sysdate, 1, 1, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '답글3', 'son', '1234', 'bref:1_bstep:1_blevel:1', 'Penguins.jpg', 0, sysdate, 1, 1, 1);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '답글4', 'son', '1234', 'bref:2_bstep:1_blevel:1', 'Penguins.jpg', 0, sysdate, 2, 1, 1);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '답글5', 'son', '1234', 'bref:2_bstep:2_blevel:2', 'Penguins.jpg', 0, sysdate, 2, 2, 1);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '답글6', 'son', '1234', 'bref:2_bstep:2_blevel:2', 'Penguins.jpg', 0, sysdate, 2, 2, 2);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '답글7', 'son', '1234', 'bref:3_bstep:2_blevel:2', 'Penguins.jpg', 0, sysdate, 3, 2, 2);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '답글8', 'son', '1234', 'bref:3_bstep:3_blevel:2', 'Penguins.jpg', 0, sysdate, 3, 3, 2);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '답글9', 'son', '1234', 'bref:3_bstep:3_blevel:3', 'Penguins.jpg', 0, sysdate, 3, 3, 3);


-- 페이징 처리용 더미파일 

INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글41', 'han', '1234', '일반글일반글41', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글42', 'han', '1234', '일반글일반글42', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글43', 'han', '1234', '일반글일반글43', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글44', 'han', '1234', '일반글일반글44', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글45', 'han', '1234', '일반글일반글45', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글46', 'han', '1234', '일반글일반글46', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글47', 'han', '1234', '일반글일반글47', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글48', 'han', '1234', '일반글일반글48', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글49', 'han', '1234', '일반글일반글49', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글50', 'han', '1234', '일반글일반글50', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글51', 'han', '1234', '일반글일반글51', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글52', 'han', '1234', '일반글일반글52', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글53', 'han', '1234', '일반글일반글53', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글54', 'han', '1234', '일반글일반글54', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글55', 'han', '1234', '일반글일반글55', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글56', 'han', '1234', '일반글일반글56', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글57', 'han', '1234', '일반글일반글57', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글58', 'han', '1234', '일반글일반글58', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글59', 'han', '1234', '일반글일반글59', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글60', 'han', '1234', '일반글일반글60', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글61', 'han', '1234', '일반글일반글61', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글62', 'han', '1234', '일반글일반글62', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글63', 'han', '1234', '일반글일반글63', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글64', 'han', '1234', '일반글일반글64', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글65', 'han', '1234', '일반글일반글65', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글66', 'han', '1234', '일반글일반글66', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글67', 'han', '1234', '일반글일반글67', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글68', 'han', '1234', '일반글일반글68', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글69', 'han', '1234', '일반글일반글69', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글70', 'han', '1234', '일반글일반글70', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글71', 'han', '1234', '일반글일반글71', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글72', 'han', '1234', '일반글일반글72', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글73', 'han', '1234', '일반글일반글73', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글74', 'han', '1234', '일반글일반글74', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글75', 'han', '1234', '일반글일반글75', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글76', 'han', '1234', '일반글일반글76', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글77', 'han', '1234', '일반글일반글77', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글78', 'han', '1234', '일반글일반글78', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글79', 'han', '1234', '일반글일반글79', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글80', 'han', '1234', '일반글일반글80', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글81', 'han', '1234', '일반글일반글81', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글82', 'han', '1234', '일반글일반글82', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글83', 'han', '1234', '일반글일반글83', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글84', 'han', '1234', '일반글일반글84', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글85', 'han', '1234', '일반글일반글85', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글86', 'han', '1234', '일반글일반글86', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글87', 'han', '1234', '일반글일반글87', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글88', 'han', '1234', '일반글일반글88', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글89', 'han', '1234', '일반글일반글89', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글90', 'han', '1234', '일반글일반글90', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글91', 'han', '1234', '일반글일반글91', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글92', 'han', '1234', '일반글일반글92', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글93', 'han', '1234', '일반글일반글93', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글94', 'han', '1234', '일반글일반글94', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글95', 'han', '1234', '일반글일반글95', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글96', 'han', '1234', '일반글일반글96', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글97', 'han', '1234', '일반글일반글97', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글98', 'han', '1234', '일반글일반글98', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글99', 'han', '1234', '일반글일반글99', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글100', 'han', '1234', '일반글일반글100', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글101', 'han', '1234', '일반글일반글101', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글102', 'han', '1234', '일반글일반글102', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글103', 'han', '1234', '일반글일반글103', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글104', 'han', '1234', '일반글일반글104', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글105', 'han', '1234', '일반글일반글105', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글106', 'han', '1234', '일반글일반글106', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글107', 'han', '1234', '일반글일반글107', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글108', 'han', '1234', '일반글일반글108', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글109', 'han', '1234', '일반글일반글109', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글110', 'han', '1234', '일반글일반글110', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글111', 'han', '1234', '일반글일반글111', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글112', 'han', '1234', '일반글일반글112', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글113', 'han', '1234', '일반글일반글113', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글114', 'han', '1234', '일반글일반글114', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글115', 'han', '1234', '일반글일반글115', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글116', 'han', '1234', '일반글일반글116', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글117', 'han', '1234', '일반글일반글117', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글118', 'han', '1234', '일반글일반글118', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글119', 'han', '1234', '일반글일반글119', 'Penguins.jpg', 0, sysdate, 0, 0, 0);

INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글120', 'han', '1234', '일반글일반글120', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글121', 'han', '1234', '일반글일반글121', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글122', 'han', '1234', '일반글일반글122', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글123', 'han', '1234', '일반글일반글123', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글124', 'han', '1234', '일반글일반글124', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글125', 'han', '1234', '일반글일반글125', 'Penguins.jpg', 0, sysdate, 0, 0, 0);
INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, '0', '0', '일반글126', 'han', '1234', '일반글일반글126', 'Penguins.jpg', 0, sysdate, 0, 0, 0);