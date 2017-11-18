<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
	//브라우저 캐싱 X 
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.addHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 1L);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 스프링 게시판 </title>

	<script type="text/javascript">
		function change_whereColumn(){
			document.listForm.word.value = "";
		}
		
		function change_isBlock() {
			var isBlock = document.getElementById('isBlock').value;

			var sortColumn = '${sortColumn}';
			var orderby = '${orderby }';
						
			var whereColumn = '${whereColumn }';
			var word = '${word }';
			
			var pageCutCount = '${pageCutCount }';
			
			location.href='list.do?sortColumn='+sortColumn+'&orderby='+orderby+'&whereColumn='+whereColumn+'&word='+word+'&isBlock='+isBlock+'&pageCutCount='+pageCutCount;
		}
		
		function change_pageCutCount() {
			var pageCutCount = document.getElementById("pageCutCount").value;
			
			var sortColumn = '${sortColumn}';
			var orderby = '${orderby }';
						
			var whereColumn = '${whereColumn }';
			var word = '${word }';
			
			var isBlock = '${isBlock }';
			
			location.href='list.do?sortColumn='+sortColumn+'&orderby='+orderby+'&whereColumn='+whereColumn+'&word='+word+'&isBlock='+isBlock+'&pageCutCount='+pageCutCount;
		}
	</script>
	
</head>
<body>
	
	<header>
		<nav>
		<jsp:include page="header.jsp" />
		</nav>
	</header>
	
	<c:if test="${empty pageCutCount }">
		<c:set var="pageCutCount" value="5" />
	</c:if>
	<c:if test="${empty isBlock }">
		<c:set var="isBlock" value="ALL" />
	</c:if>
	
	<%-- 디버그용 코드	
	\${pn } : ${pn }<br />
		
	\${sortColumn }: ${sortColumn } <br />
	\${orderby }: ${orderby } <br />
	
	\${isBlock }: ${isBlock } <br />
	\${pageCutCount }: ${pageCutCount } <br />
	
	\${whereColumn }: ${whereColumn } <br />
	\${word }: ${word } <br />
	<p /><p />
	 --%>
	
	
	<section>
	<div id="search" style="text-align: center;">
	<%-- <form action="search.do" method="post" name="listForm"> --%>
	<form action="list.do" method="post" name="listForm">
	
		<input type="hidden" name="sortColumn" value="${sortColumn }">
		<input type="hidden" name="orderby" value="${orderby }">
		<input type="hidden" name="isBlock" value="${isBlock }">
		<input type="hidden" name="pageCutCount" value="${pageCutCount }">
		
	
		<!-- 관리자 모드 메뉴 : 미구현 주석처리
		 -->
		<table id="listGubun" style="border: none;">
			<tr style="border: none;">
				<td style="text-align: left; border: none;">
					
					<c:if test="${not empty sessionScope.id }">
						<select name ="isBlock" id ="isBlock" onchange="change_isBlock();">
																
							<c:choose>
								<c:when test="${isBlock eq 'ALL' }"><option value="ALL" selected="selected">전체글</option></c:when>
								<c:otherwise><option value="ALL">전체글</option></c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${isBlock eq '1' }"><option value="1" selected="selected">블록글</option></c:when>
								<c:otherwise><option value="1">블록글</option></c:otherwise>
							</c:choose>
							<c:choose>	
								<c:when test="${isBlock eq '0' }"><option value="0" selected="selected">일반글</option></c:when>
								<c:otherwise><option value="0">일반글</option></c:otherwise>
							</c:choose>
							
						</select>			
					</c:if>			
				</td>
				<td style="text-align: right; border: none;">
				
					<%-- ${listModel.startRow}-${listModel.endRow} --%>
					[${listModel.requestPage}/${listModel.totalPageCount}]
					
					<select name = "pageCutCount" id = "pageCutCount" onchange="change_pageCutCount();">
					
						<c:choose>
							<c:when test="${pageCutCount eq '5' }"><option value="5" selected="selected">5줄</option></c:when>
							<c:otherwise><option value="5">5줄</option></c:otherwise>
						</c:choose>
						<c:choose>		
							<c:when test="${pageCutCount eq '10' }"><option value="10" selected="selected">10줄</option></c:when>
							<c:otherwise><option value="10">10줄</option></c:otherwise>
						</c:choose>
						<c:choose>		
							<c:when test="${pageCutCount eq '20' }"><option value="20" selected="selected">20줄</option></c:when>
							<c:otherwise><option value="20">20줄</option></c:otherwise>
						</c:choose>
						
					</select>				
				</td>
			</tr>
		</table>
	
		<table border="1" id="list">
			<tr>
				<th>No.</th>
				<th>
					<c:choose>
						<c:when test="${sortColumn eq 'TITLE'}"><!-- 제목 정렬일때 -->
							<c:choose>
								<c:when test="${orderby eq 'ASC' }">
									<a href="list.do?sortColumn=TITLE&orderby=DESC&whereColumn=${whereColumn }&word=${word }&isBlock=${isBlock }&pageCutCount=${pageCutCount }">제목 ▲</a>
								</c:when>
								<c:otherwise>
									<a href="list.do?sortColumn=TITLE&orderby=ASC&whereColumn=${whereColumn }&word=${word }&isBlock=${isBlock }&pageCutCount=${pageCutCount }">제목 ▼</a>									
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise><!-- 제목 정렬이 아닐 때 -->
							<a href="list.do?sortColumn=TITLE&orderby=ASC&whereColumn=${whereColumn }&word=${word }&isBlock=${isBlock }&pageCutCount=${pageCutCount }">제목 ▼</a>													
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
									<a href="list.do?sortColumn=REGTIME&orderby=DESC&whereColumn=${whereColumn }&word=${word }&isBlock=${isBlock }&pageCutCount=${pageCutCount }">작성일 ▲</a>		
								</c:when>
								<c:otherwise>
									<a href="list.do?sortColumn=REGTIME&orderby=ASC&whereColumn=${whereColumn }&word=${word }&isBlock=${isBlock }&pageCutCount=${pageCutCount }">작성일 ▼</a>
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise><!-- 작성일 정렬이 아닐 때 -->
							<a href="list.do?sortColumn=REGTIME&orderby=ASC&whereColumn=${whereColumn }&word=${word }&isBlock=${isBlock }&pageCutCount=${pageCutCount }">작성일 ▼</a>
						</c:otherwise>
					</c:choose>
					
					
				</th>
			</tr>
			
			
			<c:forEach var="list" items="${listModel.boardDTOList }">
				<tr>
					<td>${list.NUM }</td>
					
					<c:choose>
						<c:when test="${list.ISNOTICE eq '1' }"> <%-- 공지사항 처리 --%>
							<td id="notice">
								<strong> 
								<c:choose>
									<c:when test="${list.ISBLOCK eq '1' }"> <%-- 블록글 처리 --%>
										<div style="text-decoration:line-through; color: red;"> 
											<img src="/image/notice.png">&nbsp;
											<c:choose> <%-- 관리자는 블록글 내용보기 가능 --%>
												<c:when test="${not empty sessionScope.id }">
													<a href="listView.do?no=${list.NUM }" style="text-decoration:line-through; color: red;"> 
														${list.TITLE } 
													</a>
												</c:when>
												<c:otherwise> ${list.TITLE } </c:otherwise>
											</c:choose>
										</div>
									</c:when>
									<c:otherwise>
										<div>
											<img src="/image/notice.png">&nbsp;
											<a href="listView.do?no=${list.NUM }" style="text-decoration:none; color: red;" > 
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
													<a href="listView.do?no=${list.NUM }" style="text-decoration: line-through; color: grey;"> 
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
						<fmt:formatDate value="${list.REGTIME }" pattern="yyyy-MM-dd hh:mm:ss"/>
					</td>
				</tr>
			</c:forEach>			
		</table>	
	
		<!-- 양 끝에 글등록 링크 위치 -->
		<table style="border: none;">
			<tr style="border: none;">
				<td style="text-align: left; border: none;">
					<input type="button" value="글 쓰기" onclick="location.href='reg.do'" />
				</td>
				<td style="text-align: right; border: none;">
					<input type="button" value="글 쓰기" onclick="location.href='reg.do'" />	
				</td>
			</tr>
		</table>
	
	
	
		<p /><p /><p />
		
		
		<!-- 페이징 처리 -->		
		<c:if test="${beginPage > 10 }">
			<div style="display: inline; color: black;" >
				<a href='<c:url value="list.do?sortColumn=${sortColumn }&orderby=${orderby }&whereColumn=${whereColumn }&word=${word }&isBlock=${isBlock }&pageCutCount=${pageCutCount }&pn=${beginPage-1}"/>'>◀ 이전 </a>&nbsp;
			</div>
		</c:if> 
		
		<c:forEach var="pno" begin="${beginPage}" end="${endPage}">
			
			<c:choose>
				<c:when test="${pno == pn}">
					<div style="display: inline; color: red;" ><strong>${pno}</strong></div>&nbsp;
				</c:when>
				<c:otherwise>
					<div style="display: inline; color: black;" >
						<a href='<c:url value="list.do?sortColumn=${sortColumn }&orderby=${orderby }&whereColumn=${whereColumn }&word=${word }&isBlock=${isBlock }&pageCutCount=${pageCutCount }&pn=${pno}" />'>${pno}</a>&nbsp;
					</div>	
				</c:otherwise>
			</c:choose>
		</c:forEach>
		 
		<c:if test="${endPage < listModel.totalPageCount}">
			<div style="display: inline; color: black;" >
				&nbsp; <a href='<c:url value="list.do?sortColumn=${sortColumn }&orderby=${orderby }&whereColumn=${whereColumn }&word=${word }&isBlock=${isBlock }&pageCutCount=${pageCutCount }&pn=${endPage + 1}"/>'> 다음 ▶ </a>
			</div>
		</c:if>
		
		
		<p /><p />	
		
		<!-- 검색 처리 -->		
		<select name="whereColumn" onchange="change_whereColumn()">
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