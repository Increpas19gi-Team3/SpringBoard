<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
	
%>


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
			
		제목 / 날짜 <br />
	\${sortColumn }: ${sortColumn } <br />
	\${orderby }: ${orderby }<p /><p />
	
	
	<section>
		<table border="1" id="list">
			<tr>
				<th>No.</th>
				
				<th>
					<c:if test="${empty sortColumn }">
						<a href="list.do?sort='TITLE'&orderby='ASC'">제목 ▼</a>
					</c:if>
					<c:if test="${sortColumn eq 'TITLE'}">
					<c:choose>
						<c:when test="${orderby eq 'ASC' }">
							<a href="list.do?sort='TITLE'&orderby='DESC'">제목 ▲</a>		
						</c:when>
						<c:otherwise>
							<a href="list.do?sort='TITLE'&orderby='ASC'">제목 ▼</a>
						</c:otherwise>
					</c:choose>
					</c:if>
				</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>
					
					<c:if test="${empty sortColumn }">
						<a href="list.do?sort='REGTIME'&orderby='ASC'">작성일 ▼</a>
					</c:if>
					<c:if test="${sortColumn eq 'REGTIME'}">
					<c:choose>
						<c:when test="${orderby eq 'ASC' }">
							<a href="list.do?sort='REGTIME'&orderby='DESC'">작성일 ▲</a>		
						</c:when>
						<c:otherwise>
							<a href="list.do?sort='REGTIME'&orderby='ASC'">작성일 ▼</a>
						</c:otherwise>
					</c:choose>
					</c:if>
				</th>
			</tr>
			
			
			<c:forEach var="list" items="${list }">
				<tr>
					<td>${list.NUM }</td>
					
					<c:choose>
						<c:when test="${list.ISNOTICE eq '1' }"> <%-- 공지사항 처리 --%>
							<td id="notice" style="font: bold; color: red;">
								<strong> 
								
								<c:choose>
									<c:when test="${list.ISBLOCK eq '1' }"> <%-- 블록글 처리 --%>
										<div style="text-decoration: line-through; color: grey;">
											<img src="/image/notice.png">&nbsp;
												${list.TITLE }
										</div>
									</c:when>
									<c:otherwise>
										<img src="/image/notice.png">&nbsp;
										<a href="listView.do?no=${list.NUM }" > 
											${list.TITLE } 
										</a>		
									</c:otherwise>
								</c:choose>
								 
								
								</strong>
							</td>
						</c:when>
						<c:otherwise>
							<td>
								<c:choose>
									<c:when test="${list.ISBLOCK eq '1' }"> <%-- 블록글 처리 --%>
										<div style="text-decoration: line-through; color: grey;">${list.TITLE }</div>
									</c:when>
									<c:otherwise>
										<a href="listView.do?no=${list.NUM }" > ${list.TITLE } </a>		
									</c:otherwise>
								</c:choose>
							</td>	
						</c:otherwise>
					</c:choose>
					
					
					<td>${list.WRITER }</td>
					<td>${list.COUNT }</td>
					<td>
						<fmt:formatDate value="${list.REGTIME }" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
			</c:forEach>			
		</table>
	
	
		<p /><p /><p />
		<div id="search" style="text-align: center;">
			<form action="search.do" method="post">
				
				<input type="hidden" name="sortColumn" value="" />
				<input type="hidden" name="orderby" value="" />
			
			
				<select name="whereColumn">
					<option value="" >전체검색</option>
					<option value="TITLE" >제목</option>
					<option value="WRITER"> 작성자</option>
				</select>
				
				<input type="text" name="word">
				<input type="submit" value="검색">
			</form>
		</div>
	
	</section>
	
	
	
	
	
	<footer>
	<jsp:include page="footer.jsp" />
	</footer>