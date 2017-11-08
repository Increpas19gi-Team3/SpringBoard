<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel= "stylesheet" type="text/css" href="css/shopping.css">
<title>글등록</title>
</head>
<body>

<%-- 	<header>
		<nav>
			<jsp:include page="header.jsp" />
		</nav>
	</header> --%>


	<section>
		<form name="frm" method="post" action="reg.do"  enctype="multipart/form-data">
			<table>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="user"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<th>글종류</th>
					<td>
						<input type="radio" name="write_kind" value="0" checked="checked">일반글
						<input type="radio" name="write_kind" value="1">공지글
					</td>
				</tr>
				<tr>
					<th>글제목</th>
					<td><input type="text" name="title"></td>
				</tr>

				<tr>
					<th>제목</th>
					<td><input type="text" size="70" name="title"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="70" rows="15" name="content"></textarea></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>상품그림파일 <input type="file" name="upfile"></td>
				</tr>
				
			</table>
			<br>
			<br> <input type="submit" value="등록"> 
			<input type="reset" value="다시 작성"> 
		</form>

	</section>

	<footer>
		<jsp:include page="footer.jsp" />
	</footer>