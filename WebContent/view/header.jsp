<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel= "stylesheet" type="text/css" href="css/shopping.css">


<div style="text-align: center; padding: 50px 100px;">
	<p /><p /><p />
	<h1><a href="list.do" style="text-decoration:none; color: blue;" >Spring Board</a></h1>
	<p /><p /><p />
</div>


<div id="adminLogin" style="text-align: right;">
	<c:choose>
		<c:when test="${not empty sessionScope.id }">
			<a href="logout.do">관리자 로그아웃</a>
		</c:when>
		<c:otherwise>
			<a href="login.do">관리자 로그인</a>
		</c:otherwise>
	</c:choose>
</div>

<hr>
<p /><p /><p />