<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 스프링 리스트 </title>
</head>
<body>
	
	<header>
		<nav>
		<jsp:include page="header.jsp" />
		</nav>
	</header>
	
	
	<section>
	
		<table border="1">
			<tr>
				<th>No.</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
			
			
			<c:forEach var="list" items="${list }">
				<tr>
					<td>${list.NUM }</td>
					<td>${list.TITLE }</td>
					<td>${list.WRITER }</td>
					<td>${list.COUNT }</td>
					<td>
						<fmt:formatDate value="${list.REGTIME }" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
			</c:forEach>			
		</table>
	
	</section>
	
	
	
	
	
	<footer>
	<jsp:include page="footer.jsp" />
	</footer>