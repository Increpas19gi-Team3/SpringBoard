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
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<title>답글_글등록</title>
</head>
<body>

	<section>
		<form:form commandName="icmd" action="reply.do" method="post">
		
		<!-- 4개 정보 컨츠롤러 전달 -->
		<input type=hidden name="NUM" value="${bDTO.NUM}"> 
		<input type=hidden name="BREF" value="${bDTO.BREF}"> 
		<input type=hidden name="BSTEP" value="${bDTO.BSTEP}"> 
		<input type=hidden name="BLEVEL" value="${bDTO.BLEVEL}">	
		
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
					<c:if test="${not empty sessionScope.id}">
							<input type="radio" name="ISNOTICE" value="1">공지글
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
			</table>
			<br>
			<br>
			<input type="submit" value="등록">
			<input type="reset" value="다시 작성">
		</form:form>

	</section>

	<footer>
		<jsp:include page="footer.jsp" />
	</footer>