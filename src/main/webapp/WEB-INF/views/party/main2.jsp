<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파티룸 메인</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap">
<style type="text/css">
li {
	float: left;
	margin-left: 10px;
}
</style>
</head>
<body>
<!-- 헤더 -->
    <header>
        <div class="head">
            <!-- 로고 -->
            <a href="/miraclebird">
                <img src="${pageContext.request.contextPath}/resources/img/logo.svg" alt="로고" class="logo animate__animated animate__fadeInLeft">
            </a>
            <!-- 네비게이션바 -->
            <nav>
                <ul class="nav-container animate__animated animate__fadeIn">
                    <li class="nav-item"><a href="/miraclebird/recruit/list">FIND</a></li>
                    <c:if test="${partyId != null}">
                    	<li class="nav-item"><a href="/miraclebird/party/main">MY PARTY</a></li>
                    </c:if>
                    <li class="nav-item"><a href="/miraclebird/myFeed">MY FEED</a></li>
                    <li class="nav-item"><a href="/miraclebird/profile">PROFILE</a></li>
                    <li class="nav-item"><a href="/miraclebird/store/productList?page=1&categoryId=1">STORE</a></li>
                    <li class="nav-item"><a href="/miraclebird/recommend">RECOMMEND</a></li>
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
    <hr>
    <ul>
    	<li>
    		<a href="/miraclebird/party/main">
    			Main
    		</a>
    	</li>
    	<li>
    		<a href="/miraclebird/party/applicants">
    			applicants
    		</a>
    	</li>
    </ul> <br/>
    <hr>
    미라클 타임 : <input type="time" value="${partyVO.miracleStartTime}" disabled /> ~ <input type="time" value="${partyVO.miracleEndTime}" disabled /> <br/>
	미라클 활동 : <input type="text" value="${partyVO.activity}" disabled /> <br/>
</body>
</html>