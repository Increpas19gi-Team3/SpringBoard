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
<title> 스프링 게시판 </title>

	<script type="text/javascript">
		function click_whereColumn(){
			document.listForm.word.value = "";
		}
	</script>
	
</head>
<body>
	
	<header>
		<nav>
		<jsp:include page="header.jsp" />
		</nav>
	</header>
			
	<%-- 미구현 작업용 주석처리
	onclick="location.href='delete.do?NUM=${number}'"
	
		1. 검색조건 유지 -  관리자모드: 일반글, 블록글 <br />
		2. 페이징 처리  <br />
	\${sortColumn }: ${sortColumn } <br />
	\${orderby }: ${orderby } <br />
	
	\${listGubun }: ${listGubun } <br />
	
	\${whereColumn }: ${whereColumn } <br />
	\${word }: ${word } <br />
	<p /><p />
	 --%>
	
	<section>
	<div id="search" style="text-align: center;">
	<form action="search.do" method="post" name="listForm">
	
		<input type="hidden" name="sortColumn" value="${sortColumn }">
		<input type="hidden" name="orderby" value="${orderby }">
	
		<!-- 관리자 모드 메뉴 : 미구현 주석처리
		<table id="listGubun" style="">
			<tr >
				<td style="text-align: left;">
					
					<c:if test="${not empty sessionScope.id }">
						<select name = "listGubun">
							<option value="ALL">전체글</option>
							<option value="1">블록글</option>
							<option value="0">일반글</option>
						</select>			
					</c:if>			
				</td>
				<td style="text-align: right;">
				
					<select name = "listCnt">
						<option>5줄</option>
						<option>10줄</option>
						<option>20줄</option>
					</select>				
				</td>
			</tr>
		</table>
		 -->
	
		<table border="1" id="list">
			<tr>
				<th>No.</th>
				<th>
					<c:choose>
						<c:when test="${sortColumn eq 'TITLE'}"><!-- 제목 정렬일때 -->
							<c:choose>
								<c:when test="${orderby eq 'ASC' }">
									<a href="list.do?sortColumn=TITLE&orderby=DESC&whereColumn=${whereColumn }&word=${word }">제목 ▲</a>		
								</c:when>
								<c:otherwise>
									<a href="list.do?sortColumn=TITLE&orderby=ASC&whereColumn=${whereColumn }&word=${word }">제목 ▼</a>
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise><!-- 제목 정렬이 아닐 때 -->
							<a href="list.do?sortColumn=TITLE&orderby=ASC&whereColumn=${whereColumn }&word=${word }">제목 ▼</a>
						</c:otherwise>
					</c:choose>
					
					
					
				</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>
					<c:choose>
						<c:when test="${sortColumn eq 'REGTIME'}"><!-- 작성일 일때 -->
							<c:choose>
								<c:when test="${orderby eq 'ASC' }">
									<a href="list.do?sortColumn=REGTIME&orderby=DESC&whereColumn=${whereColumn }&word=${word }">작성일 ▲</a>		
								</c:when>
								<c:otherwise>
									<a href="list.do?sortColumn=REGTIME&orderby=ASC&whereColumn=${whereColumn }&word=${word }">작성일 ▼</a>
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise><!-- 작성일 정렬이 아닐 때 -->
							<a href="list.do?sortColumn=REGTIME&orderby=ASC&whereColumn=${whereColumn }&word=${word }">작성일 ▼</a>
						</c:otherwise>
					</c:choose>
					
					
				</th>
			</tr>
			
			
			<c:forEach var="list" items="${list }">
				<tr>
					<td>${list.NUM }</td>
					
					<c:choose>
						<c:when test="${list.ISNOTICE eq '1' }"> <%-- 공지사항 처리 --%>
							<td id="notice">
								<strong> 
								<c:choose>
									<c:when test="${list.ISBLOCK eq '1' }"> <%-- 블록글 처리 --%>
										<div style="text-decoration: line-through; color: gray;">
											<img src="/image/notice.png">&nbsp;
											<c:choose> <%-- 관리자는 블록글 내용보기 가능 --%>
												<c:when test="${not empty sessionScope.id }">
													<a href="listView.do?no=${list.NUM }" > 
														${list.TITLE } 
													</a>
												</c:when>
												<c:otherwise> ${list.TITLE } </c:otherwise>
											</c:choose>
										</div>
									</c:when>
									<c:otherwise>
										<div style="color: red;">
											<img src="/image/notice.png">&nbsp;
											<a href="listView.do?no=${list.NUM }" > 
												${list.TITLE } 
											</a>		
										</div>
									</c:otherwise>
								</c:choose>
								</strong>
							</td>
						</c:when>
						<c:otherwise>
							<td>
								<c:choose>
									<c:when test="${list.ISBLOCK eq '1' }"> <%-- 블록글 처리 --%>
										<div style="text-decoration: line-through; color: grey;">
										
											<c:choose><%-- 관리자는 블록글 내용보기 가능 --%>
												<c:when test="${not empty sessionScope.id }">
													<a href="listView.do?no=${list.NUM }" > 
														${list.TITLE } 
													</a>
												</c:when>
												<c:otherwise> ${list.TITLE } </c:otherwise>
											</c:choose>
											
										</div>										
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
						<fmt:formatDate value="${list.REGTIME }" pattern="yyyy-MM-dd hh:mm"/>
					</td>
				</tr>
			</c:forEach>			
		</table>
	
	
		<p /><p /><p />
		
				
				<select name="whereColumn" onclick="click_whereColumn()">
					<c:choose>
						<c:when test="${not empty whereColumn }">
							
							<c:choose>
								<c:when test="${whereColumn eq 'ALL'}">
									<option value="ALL" selected="selected">전체검색</option>
									<option value="TITLE" >제목</option>
									<option value="WRITER"> 작성자</option>
								</c:when>
								<c:when test="${whereColumn eq 'TITLE'}">
									<option value="ALL">전체검색</option>
									<option value="TITLE" selected="selected">제목</option>
									<option value="WRITER"> 작성자</option>
								</c:when>
								<c:when test="${whereColumn eq 'WRITER'}">
									<option value="ALL">전체검색</option>
									<option value="TITLE" >제목</option>
									<option value="WRITER" selected="selected"> 작성자</option>
								</c:when>
							</c:choose>
						
						</c:when>
						<c:otherwise>
							<option value="ALL">전체검색</option>
							<option value="TITLE" >제목</option>
							<option value="WRITER"> 작성자</option>
						</c:otherwise>
					</c:choose>
				</select>
				
				<input type="text" name="word" value="${word }">
				<input type="submit" value="검색">
	</form>	
	</div>
		
	</section>
	
	
	
	
	
	<footer>
	<jsp:include page="footer.jsp" />
	</footer>