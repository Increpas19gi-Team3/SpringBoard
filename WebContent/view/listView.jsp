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
<title>LIST_VIEW</title>
</head>
<body>

	<header>
		<nav>
			<jsp:include page="header.jsp" />
		</nav>
	</header>

	<hr>
	
	<section>		
			<table>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="WRITER"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="PWD"></td>
				</tr>
				<tr>
					<th>글종류</th>
					<td>
						<input type="radio" name="ISNOTICE" value="0" checked="checked">일반글
						<c:if test="${not empty sessionScope.id }">
							<input type="radio" name="ISNOTICE" value="1" >공지글
						</c:if>						
					</td>
				</tr>

				<tr>
					<th>제목</th>
					<td><input type="text" size="70" name="TITLE"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="70" rows="15" name="CONTENTS"></textarea></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="upfile"></td>
				</tr>
				
			</table>
			<br>
			<br> <input type="submit" value="등록"> 
			<input type="reset" value="다시 작성"> 
		

	</section>
	
	
	
	
	
	
		<tr>
			<td><fmt:formatDate value="${list.REGTIME }" pattern="yyyy-MM-dd" /></td>
		</tr>
	<hr>

	<footer>
		<jsp:include page="footer.jsp" />
	</footer>