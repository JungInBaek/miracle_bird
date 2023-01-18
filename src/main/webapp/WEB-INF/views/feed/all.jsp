<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:forEach var="vo" items="${list }">
	<div class="feed">
		<div class="feed-img">
			<img src="${vo.mediaUrl}" alt="image">
		</div>
		<h5 class="feed-user">${vo.username }</h5>
		<fmt:parseDate value="${vo.feedTime }" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime"/>
		<div class="feed-time"><fmt:formatDate pattern="HH:mm:ss (yyyy-MM-dd)" value="${parsedDateTime }" /></div>
		<p class="feed-tag">${vo.caption }</p>
	</div>
</c:forEach>