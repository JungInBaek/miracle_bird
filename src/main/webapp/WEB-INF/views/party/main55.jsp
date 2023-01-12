<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="resources/css/partyMain5.css" rel="stylesheet" type="text/css">
    <link
        href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap”
        rel=“stylesheet”>
    <link rel=“stylesheet”
    href=“https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css”>
    <title>Party Main</title>
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
                    <li class="nav-item"><a href="/miraclebird">COMMUNITY</a></li>
                    <li class="nav-item"><a href="/miraclebird/recruit/list">JOIN</a></li>
                    <c:if test="${partyId != null}">
                    	<li class="nav-item"><a href="/miraclebird/party/main">MY PARTY</a></li>
                    </c:if>
                    <li class="nav-item"><a href="/miraclebird/myFeed">MY FEED</a></li>
                    <li class="nav-item"><a href="/miraclebird/profile">PROFILE</a></li>
                    <li class="nav-item"><a href="/miraclebird/store/productList?page=1&categoryId=1">STORE</a></li>
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
    <div>
        <div class="cate">
            <a href="/miraclebird/party/main">
            	<button class="btn">Main</button>
            </a>
            <a href="/miraclebird/party/feed?page=1">
            	<button class="btn">Feed</button>
            </a>
            <button class="btn">Community</button>
            <c:if test="${isLeader}">
            	<a href="/miraclebird/party/style">
            		<button class="btn">Style</button>
            	</a>
            </c:if>
            <a href="/miraclebird/party/members">
            	<button class="btn">People</button>
            </a>
            <c:if test="${isLeader}">
            	<a href="/miraclebird/party/applicants">
            		<button class="btn">Applicants</button>
            	</a>
            </c:if>
        </div>
    <div class="mainInfo">
        <div class="main">
            <div class="mainImg">
            	<c:if test='${partyImgVO == null}'>
            	<div style="text-align:center; line-height:400px">
                	<img src="${pageContext.request.contextPath}/resources/img/logo.svg" width="300px" />
                	<a>파티 대표 이미지를 등록해주세요!</a>
            	</div>
            	</c:if>
            	<c:if test='${partyImgVO != null}'>
                	<img src="${pageContext.request.contextPath}/resources/partyImg/${partyImgVO.imgName}" width="950px" height="400px" />
            	</c:if>
            </div>
            <div class="mainText">
                <a>${partyVO.intro}</a>
            </div>
        </div>
        <div class="partyInfo">
            <div class="stati">
                <a>statistics</a><br>
                <h4>그래프 넣어야함</h4>
            </div>
            <div class="time">
                <a>Time</a><br>
                <h4>${partyVO.miracleStartTime} ~ ${partyVO.miracleEndTime}</h4>
            </div>
            <div class="activity">
                <a>Activity</a><br>
                <h4>${partyVO.activity}</h4>
            </div>
            <div class="member">
                <a>Members</a><br>
                <h4>${partyMemberCount}/${partyVO.maxMemberCount}</h4>
            </div>
        </div>
    </div>
    </div>
</body>
</html>