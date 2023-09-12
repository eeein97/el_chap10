<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상세보기</h2>
	<table>
		<tr>
			<td>번호</td>
			<td>${dto.idx}</td>
			<td>작성자</td>
			<td>${dto.name}</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td>${dto.postdate}</td>
			<td>조회수</td>
			<td>${dto.visitcount}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="3">${dto.title}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td colspan="3">${dto.content}</td>
		</tr>
		<tr>
			<td colspan="4">
				<button onclick="location.href='./pass.do?mode=edit&idx=${dto.idx}'">수정하기</button>
				<button onclick="location.href='./pass.do?mode=delete&idx=${dto.idx}'">삭제하기</button>
				<button onclick="location.href='./list.do'">목록보기</button>
			</td>
		</tr>
	</table>
</body>
</html>