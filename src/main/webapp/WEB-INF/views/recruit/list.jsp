<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모집 파티 목록 화면</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap">
</head>
<body>
	<!-- 헤더 -->
    <header>
        <div class="head">
            <!-- 로고 -->
            <a href="/miraclebird">
                <img src="${pageContext.request.contextPath}/resources/img/logo_white.svg" alt="로고" class="logo animate__animated animate__fadeInLeft">
            </a>
            <!-- 네비게이션바 -->
            <nav>
                <ul class="nav-container animate__animated animate__fadeIn">
                    <li class="nav-item"><a href="#">COMMUNITY</a></li>
                    <li class="nav-item"><a href="/miraclebird/recruit/list">JOIN</a></li>
                    <c:if test="${partyId != null}">
                    	<li class="nav-item"><a href="/miraclebird/party/main">MY PARTY</a></li>
                    </c:if>
                    <li class="nav-item"><a href="/miraclebird/store/productList?page=1&categoryId=1">STORE</a></li>
                    <li class="nav-item"><a href="my-profile.jsp">PROFILE</a></li>
                    <li class="nav-item">
                    	<c:choose>
                    		<c:when test="${userId == null}">
                    			<a href="/miraclebird/loginPage"><button>LOGIN</button></a>
                    		</c:when>
                    		<c:otherwise>
                    			<a href="/miraclebird/logout"><button>LOGOUT</button></a>
                    		</c:otherwise>
                    	</c:choose>
                    </li>
                </ul>
            </nav>
        </div>
    </header>
    <hr/>
<c:if test="${partyId == null && partyApplicantVO == null}">
<a href="/miraclebird/party/create">파티 생성</a>
</c:if>
<c:if test="${isLeader && !isCreated}">
<a href="/miraclebird/recruit/create">파티 모집글 등록</a>
</c:if>
<hr/>
<h1>모집 파티 목록</h1>
<hr/>
<table border="1">
<thead align="center">
	<tr>
		<th>파티 아이디</th>
		<th>파티 이름</th>
		<th>미라클 활동 시작 시간</th>
		<th>미라클 활동 종료 시간</th>
		<th>파티 활동</th>
	</tr>
</thead>
<tbody align="center">
<c:forEach var="vo" items="${list}">
	<tr>
		<td>${vo.partyId}</td>
		<td><a href="/miraclebird/recruit/${vo.recruitId}">${vo.name}</a></td>
		<td>${vo.miracleStartTime}</td>
		<td>${vo.miracleEndTime}</td>
		<td>${vo.activity}</td>
	</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>