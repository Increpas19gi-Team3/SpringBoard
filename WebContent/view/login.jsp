<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 스프링  태그 라이브러리 사용 -->
<%-- <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> --%>
<%-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>

<style type="text/css">
.error {
	color: red;
}
</style>
</head>

<body>
	<header>
		<nav>
			<jsp:include page="header.jsp" />
		</nav>
	</header>

	<section>
		<form:form commandName="login" action="login.do" method="post">
			<h2>로그인</h2>
			<br><br>

			<div class="log">
				<input type="text" style="margin-top: 10px" name="id"
					placeholder="아이디" maxlength="20" value="${icmd.id}">
			</div>

			<div class="row">
				<input type="password" style="margin-top: 10px" name="pwd"
					placeholder="비밀번호" maxlength="20" value="${icmd.pwd}">
			</div>
		</form:form>
	</section>

	<footer>
		<jsp:include page="footer.jsp" />
	</footer>













