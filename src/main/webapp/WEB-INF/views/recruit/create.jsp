<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모집글 등록 화면</title>
</head>
<body>
<h1>모집글 등록 화면</h1>
<form action="/miraclebird/recruit/create" method="post">
	<h3>${partyVO.name}</h3>
	미라클 타임 : <input type="time" value="${partyVO.miracleStartTime}" disabled /> ~ <input type="time" value="${partyVO.miracleEndTime}" disabled /> <br/>
	미라클 활동 : <input type="text" value="${partyVO.activity}" disabled /> <br/>
	<br/>
	<textarea rows="25" cols="50" name="content"></textarea> <br/>
	<button type="submit">등록하기</button>
	<a href="/miraclebird/recruit/list">
		<button type="button">취소</button>
	</a>
</form>
</body>
</html>