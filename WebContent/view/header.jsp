<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel= "stylesheet" type="text/css" href="css/shopping.css">


<div id="adminLogin" style="text-align: right;">
	
	<a href="reg.do">글등록</a>
	<c:choose>
		<c:when test="${not empty sessionScope.id }">
			<a href="#">관리자 로그아웃</a>
		</c:when>
		<c:otherwise>
			<a href="#">관리자 로그인</a>
		</c:otherwise>
	</c:choose>
</div>

<hr>
<p /><p /><p />