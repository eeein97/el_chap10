<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>목록보기(List)</h2>
		<form method="get">
			<div>
				<select name="searchField">
					<option value="title">제목</option>
					<option value="content">제목</option>
				</select>
				<input name="searchWord" type="text" />
				<input type="submit" value="검색" />
			</div>
		</form>
		<!-- 목록 테이블 -->
		<table border="1">
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>조회수</td>
				<td>작성이</td>
				<td>이미지</td>
			</tr>
			<c:choose>
				<c:when test="${empty boardlists}">
				<tr><td colspan="6">등록된 게시물이 없습니다.</td></tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${boardlists}" var="row" varStatus="loop">
						<tr>
							<td>${row.idx}</td>
							<td><a href="view.do?idx=${row.idx}">${row.title}</a>
							<td>${row.name}</td>
							<td>${row.visitcount}</td>
							<td>${row.postdate}</td>
							<td>${row.sfile}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<div>
			<button onclick="location.href='write.do'">글쓰기</button>
		</div>
</body>
</html>