<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파티 생성 화면</title>
</head>
<body>
<form action="/miraclebird/party/create" method="post">
파티명 : <input type="text" name="name" /> <br/>
한줄소개 : <input type="text" name="info" /> <br/>
미라클활동 시간 : <input type="time" name="miracleStartTime" min="04:00:00" max="12:00:00" /> ~ <input type="time" name="miracleEndTime" min="04:00:00" max="12:00:00" /> <br />
미라클 활동 : <input type="text" name="activity" /> <br />
<button>생성</button>
</form>
<a href="/miraclebird/recruit/list">취소</a>
</body>
</html>