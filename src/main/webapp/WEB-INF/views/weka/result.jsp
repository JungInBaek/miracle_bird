<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	추천 활동 : ${activity}
	<hr />
	<c:forEach var="vo" items="${list}">
		<div class="party"
			onclick="location.href='/miraclebird/recruit/${vo.recruitId}'"
			style="cursor: pointer">
			<div>
				<img src="../resources/img/profile-circle.png" class="profile" />
			</div>
			<table>
				<tbody>
					<tr>
						<td>파티 이름</td>
						<td>${vo.name}</td>
					</tr>
					<tr>
						<td>파티 시간</td>
						<td>${vo.miracleStartTime}~ ${vo.miracleEndTime}</td>
					</tr>
					<tr>
						<td>파티 활동</td>
						<td>${vo.activity}</td>
					</tr>
					<tr>
						<td><img src="../resources/img/profile-2user.png"
							class="people"></td>
						<td>${vo.memberCount}/${vo.maxMemberCount}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</c:forEach>
</body>
</html>