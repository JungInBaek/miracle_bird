<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="vo" items="${list }">
유저네임(인스타아이디) : ${vo.username }<br>
미디어 타입 : ${vo.mediaType }<br>
미디어 : <br> <img src="${vo.mediaUrl}" height=100 width=100>
<%-- <c:if test="${vo.meidaType.equals("IMAGE") }">
	<p>미디어 : <br> <img src="${vo.mediaUrl}" height=100 width=100><br></p>
</c:if>
<c:if test="${vo.meidaType.equals("VIDEO") }">
	<p>미디어 : <br> <video src="${vo.mediaUrl}" height=100 width=100></video><br></p>
</c:if> --%>
캡션 : ${vo.caption }<br>
업로드 시간 : ${vo.feedTime }<br>
<hr>
</c:forEach>