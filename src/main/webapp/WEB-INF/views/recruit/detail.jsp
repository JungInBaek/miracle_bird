<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${recruitPartyVO.name}</title>
</head>
<body>
<h3>${recruitPartyVO.name}</h3>
<form action="/miraclebird/party/join" method="post">
<input type="hidden" name="partyId" value="${recruitPartyVO.partyId}" />
미라클 타임 : <input type="time" value="${recruitPartyVO.miracleStartTime}" disabled /> ~ <input type="time" value="${recruitPartyVO.miracleEndTime}" disabled /> <br/>
미라클 활동 : <input type="text" value="${recruitPartyVO.activity}" disabled /> <br/>
<br/>
<textarea rows="25" cols="50" disabled>${recruitPartyVO.content}</textarea> <br/>
<button type="submit">가입하기</button>
<a href="/miraclebird/recruit/list">
	<button type="button">취소</button>
</a>
</form>
</body>
</html>