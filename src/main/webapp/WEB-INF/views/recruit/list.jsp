<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모집 파티 목록 화면</title>
</head>
<body>
<a href="/miraclebird/party/create">파티 생성</a>
<a href="/miraclebird/recruit/create">파티 모집글 등록</a>
<hr/>
<h1>모집 파티 목록</h1>
<table>
<thead>
	<tr>
		<th>파티 아이디</th>
		<th>파티 이름</th>
		<th>미라클 활동 시작 시간</th>
		<th>미라클 활동 종료 시간</th>
		<th>파티 활동</th>
	</tr>
</thead>
<tbody>
<c:forEach var="vo" items="${list}">
	<tr>
		<td>${vo.partyId}</td>
		<td>${vo.name}</td>
		<td>${vo.miracleStartTime}</td>
		<td>${vo.miracleEndTime}</td>
		<td>${vo.activity}</td>
	</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>