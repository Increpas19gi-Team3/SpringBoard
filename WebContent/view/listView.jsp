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


	<form action="view/boardChk.jsp" method="post">
		<input type="hidden" name="NUM" value="${bDTO.NUM}">

		<section>
			<div id="#" align="center">
				<h1>게시판 상세보기</h1>
				<br>
				<table class="#">
					<tr>
						<th>게시판 번호</th>
						<td>${bDTO.NUM}</td>
					</tr>

					<tr>
						<th>공지사항여부</th>
						<td>${bDTO.ISNOTICE}</td>
					</tr>

					<tr>
						<th>블락여부</th>
						<td>${bDTO.ISBLOCK}</td>
					</tr>

					<tr>
						<th>제&nbsp;목</th>
						<td>${bDTO.TITLE}</td>
					</tr>

					<tr>
						<th>작성자</th>
						<td>${bDTO.WRITER}</td>
					</tr>

					<tr>
						<th>이미지파일명</th>
						<td><img src="../image/${bDTO.IMGNAME}" width="400"
							height="400"></td>
					</tr>

					<tr>
						<th>내용</th>
						<td>${bDTO.CONTENTS}</td>
					</tr>

					<tr>
						<th>조회수</th>
						<td>${bDTO.COUNT}</td>
					</tr>

					<tr>
						<th>작성시간</th>
						<td><fmt:formatDate value="${bDTO.REGTIME}"
								pattern="yyyy-MM-dd" /></td>
					</tr>
				</table>

				<hr>
				<br> <br> 
				<input type="submit" value="수정/삭제"> 

				<c:choose>
					<c:when test="${not empty sessionScope.id}">
						<c:choose>
							<c:when test="${bDTO.ISBLOCK eq'0'}">
								<input type="button" value="블락" onclick="location.href='block.do?NUM=${bDTO.NUM}'">
							</c:when>
							<c:otherwise>
								<input type="button" value="블락취소" onclick="location.href='unblock.do?NUM=${bDTO.NUM}'">
							</c:otherwise>
						</c:choose>
					</c:when>

					<c:otherwise>
						<input type="button" value="목록" onclick="location.href='list.do'">
					</c:otherwise>
				</c:choose>

			</div>
		</section>
	</form>
	<footer>
		<jsp:include page="footer.jsp" />
	</footer>