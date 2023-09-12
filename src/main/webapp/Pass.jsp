<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>비밀번호 검증</h2>
	<form action="./pass.do" method="post">
		<input type="hidden" name="mode" value=${param.mode} />
		<input type="hidden" name="idx" value=${param.idx} />
		<p>비밀번호 : <input type="password" name="pass" /></p>
		<p>
			<button type="submit">검증하기</button>
			<button type="reset">취소하기</button>
			<button type="button" onclick="location.href='./list.do'">목록보기</button>
		</p>
	</form>
</body>
</html>