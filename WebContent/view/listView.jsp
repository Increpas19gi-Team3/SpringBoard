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

		<input type="hidden" name="NUM" value="${bDTO.NUM}"> <input
			type="hidden" name="BLEV" value="${bDTO.BLEVEL}">

		<section>
			<div id="#" align="center">
				<h1>게시판 상세보기</h1>
				<br>
				<table class="#">
					<tr>
						<th>게시판 번호</th>
						<td>
							<%-- 수정 못 하도록 처리 <input type="text" name="NUM" value=""> --%>
							${bDTO.NUM}
						</td>
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
							height="400"> <input type="button" name="download"
							value="첨부파일 다운로드"
							onclick="location.href='file_download.do?filename=${bDTO.IMGNAME}'">
						</td>
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


				<div class="inputView">
					<input type="button" value="목록" onclick="location.href='list.do'">
					<input type="submit" value="수정/삭제">

					<c:choose>
						<c:when test="${not empty sessionScope.id}">

							<c:choose>
								<c:when test="${bDTO.ISBLOCK eq'0'}">
									<input type="button" value="블락"
										onclick="location.href='block.do?NUM=${bDTO.NUM}'">
								</c:when>
								<c:otherwise>
									<input type="button" value="블락취소"
										onclick="location.href='unblock.do?NUM=${bDTO.NUM}'">
								</c:otherwise>
							</c:choose>
						</c:when>
					</c:choose>
				</div>
			</div>
		</section>

		<hr>

		<p />
		<p />
		<div class="inputView">
			<input type="button" value="답글쓰기"
				onclick="location.href='reply.do?NUM=${bDTO.NUM}'">
		</div>
	


		<table>
			<tr>
				<th>No.</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
				<th>수정/삭제</th>
			</tr>

			<c:choose>
				<c:when test="${bDTO.BREF == 0}">
					<tr>
						<td colspan="6">답글이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<!-- 글을 boardVO에 저장 -->
					<c:forEach var="reply" items="${replylistBDTO}">
						<tr>
							<td>${reply.NUM}</td>
							<!-- 글들여쓰기 검사 -->
							<td><c:if test="${reply.BLEVEL > 0}">
									<!-- 답글이면 '▶→' 을 추가 -->
									<c:forEach begin="1" end="${reply.BLEVEL}"> ▶→ </c:forEach> &nbsp;
							</c:if> <!-- 글상세보기 제목링크 --> <a href="listView.do?no=${reply.NUM}">
									${reply.TITLE} </td>

							<td>${reply.CONTENTS}</td>
							<td>${reply.WRITER}</td>
							<td>${reply.COUNT}</td>
							<td><fmt:formatDate value="${reply.REGTIME}"
									pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td>							
							<input type="button" value="수정/삭제" onclick="location.href='view/boardChk.jsp?NUM=${reply.NUM}&BLEV=${reply.BLEVEL}'">
							</td>
						</tr>
						<p />
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<!-- 답글 보여주기 끝 -->
	</form>

	<footer>
		<jsp:include page="footer.jsp" />
	</footer>