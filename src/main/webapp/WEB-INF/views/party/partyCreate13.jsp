<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 파티 생성 -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/partyCreate13.css" rel="stylesheet" type="text/css">
    <link
        href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap”
        rel=“stylesheet”>
    <link rel=“stylesheet”
    href=“https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css”>
    <title>파티 생성</title>
</head>
<body>
    <header>
        <div class="head">
            <!-- 로고 -->
            <a href="/miraclebird">
                <img src="${pageContext.request.contextPath}/resources/img/logo.svg" alt="로고" class="logo">
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
    <form action="/miraclebird/party/create" method="post">
    <div class="top">
        <div class="title">Create <br> Your Party</div>
        <div class="name">
            Party Name <br>
            <input name="name" placeholder="파티 명을 입력해주세요" width="300px" style="font-size: 17px; border: none;">
        </div>
        <div class="wel">
            Welcome <br>
            <textarea name="intro" class="welTxt" placeholder="파티 소개글을 작성해주세요"></textarea>
        </div>
    </div>
    <div class="partyInfo">
        <div class="time">
            <img src="../resources/img/time.jpeg" width="330px">
            <div class="Info">
                <a style="float: left; margin-left: 20px; ">Time</a><br>
                    <a style="font-weight: normal; margin: auto;">Start</a> <input type="time" name="miracleStartTime" min="04:00:00" max="12:00:00" class="inputTime" />
                    <br>
                    <a style="font-weight: normal; margin-right: 9px;">End</a> <input type="time" name="miracleEndTime" min="04:00:00" max="12:00:00" class="inputTime" />
            </div>
        </div>
        <div class="activity">
            <img src="../resources/img/activity.jpeg" width="330px" height="220px">
            <div class="Info">
                <a style="float: left; margin-left: 20px;">Activity</a><br>
                <input name="activity" placeholder="활동을 입력해주세요" class="infoInput">
            </div>
        </div>
        <div class="people">
            <img src="../resources/img/people.jpeg" width="330px" height="220px" >
            <div class="Info">
                <a style="float: left; margin-left: 20px;">People</a><br>
                <a style="font-size: 15px;">파티 인원은 최소 5명입니다<br>파티 인원 추가 시 STORE를 이용해주세요!</a>
                <input name="maxMemberCount" class="inputBox" placeholder="파티 인원을 입력해주세요.">
            </div>
        </div>      
    </div>
    <div class="btnClass">
        <a href="/miraclebird/recruit/list"><button class="btnParty" type="button" style="background-color: white;">Cancel</button></a>
        <button class="btnParty" type="submit" style="background-color: #ffb100;">Create</button>
    </div>
    </form>
</body>
</html>