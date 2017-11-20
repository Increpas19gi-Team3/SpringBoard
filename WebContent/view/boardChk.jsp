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
<title>글수정</title>
</head>
<body>

	<header>
		<nav>
			<jsp:include page="header.jsp" />
		</nav>
	</header>
	
	<section>
		<form action="../pwdCheck.do" method="post">
			<input type="hidden" name="NUMBER" value="<%=request.getParameter("NUM")%>">
			<% System.out.println("NUM : ▶▶▶▶▶ "+ request.getParameter("NUM")); %>
			
			<!-- 수정부분:손대성 -->
			<input type="hidden" name="BLEVEL" value="<%=request.getParameter("BLEV")%>">
			<% System.out.println("BLEVEL : ▶▶▶▶▶ "+ request.getParameter("BLEV")); %>
						
			<p>비밀번호를 입력하시오!
			<p><input type="text" name="pass">
			<p><input type="submit" value="확인">
			<input type="button" value="취소" onclick="location.href='../list.do'">
		</form>

	</section>

	<footer>
		<jsp:include page="footer.jsp" />
	</footer>