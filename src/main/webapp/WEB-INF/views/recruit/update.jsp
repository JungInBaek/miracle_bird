<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${recruitPartyVO.name} 모집글 수정</title>
</head>
<body>
<form action="/miraclebird/recruit/${recruitPartyVO.recruitId}/update" method="post">
미라클 타임 : <input type="time" value="${recruitPartyVO.miracleStartTime}" disabled /> ~ <input type="time" value="${recruitPartyVO.miracleEndTime}" disabled /> <br/>
미라클 활동 : <input type="text" value="${recruitPartyVO.activity}" disabled /> <br/>
<br/>
<textarea rows="25" cols="50" name="content">${recruitPartyVO.content}</textarea> <br/>
<button type="submit">저장</button>
</form>
</body>
</html>