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
		<form >
			<p>잘못입력했습니다.
			<p><input type="button" value="확인" onclick="location.href='list.do'">

		</form>

	</section>

	<footer>
		<jsp:include page="footer.jsp" />
	</footer>