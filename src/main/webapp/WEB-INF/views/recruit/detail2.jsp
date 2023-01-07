<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${recruitPartyVO.name}</title>
</head>
<body>
<h3>${recruitPartyVO.name}</h3>
미라클 타임 : <input type="time" value="${recruitPartyVO.miracleStartTime}" disabled /> ~ <input type="time" value="${recruitPartyVO.miracleEndTime}" disabled /> <br/>
미라클 활동 : <input type="text" value="${recruitPartyVO.activity}" disabled /> <br/>
<br/>
<textarea rows="25" cols="50" disabled>${recruitPartyVO.content}</textarea> <br/>
<c:if test="${partyId == null && partyApplicantVO == null}">
	<form action="/miraclebird/party/join" method="post">
		<input type="hidden" name="partyId" value="${recruitPartyVO.partyId}" />
		<button type="submit">가입신청</button>
	</form>
</c:if>
<c:if test="${partyId == null && partyApplicantVO.partyId == recruitPartyVO.partyId}">
	<a href="/miraclebird/party/join/cancel">
		<button type="button">신청취소</button>
	</a> 
</c:if>
<c:if test="${partyId == recruitPartyVO.partyId && isLeader}">
	<a href="/miraclebird/recruit/${recruitPartyVO.recruitId}/update">
		<button type="button">수정</button>
	</a>
	<a href="/miraclebird/recruit/${recruitPartyVO.recruitId}/delete">
		<button type="button">삭제</button>
	</a>
</c:if>
<a href="/miraclebird/recruit/list">
	<button type="button">뒤로</button>
</a>
</body>
</html>