<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:forEach var="vo" items="${list }">
<div class="feed">
	<img src="${vo.mediaUrl}" height=190 width=200><br>
	캡션 : ${vo.caption }<br>
	<%-- 업로드 시간 : ${vo.feedTime }<br> --%>
	<fmt:parseDate value="${vo.feedTime }" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both"/>
	업로드 시간 : <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${parsedDateTime }"/><br>
</div>
</c:forEach>