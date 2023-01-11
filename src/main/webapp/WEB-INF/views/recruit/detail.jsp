<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="../resources/css/partyPostDetail.css" rel="stylesheet" type="text/css">
    <link
    href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap”
    rel=“stylesheet”> <link rel=“stylesheet”
    href=“https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css”>
    <title>파티 모집글 상세보기</title>
  </head>
</head>
<body>
<header>
      <div class="head">
        <!-- 로고 -->
        <a href="/miraclebird">
          <img src="../resources/img/logo.svg" alt="로고" class="logo" />
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
    <div class="box">
      <h2 class="partyName">${recruitPartyVO.name}</h2>
      <div class="partyInfo">
        <div class="left">
          <div class="time">
            <img src="../resources/img/time.png" class="time-img" />
            <h5 class="time-text">TIME</h5>
            <h4>${recruitPartyVO.miracleStartTime} ~ ${recruitPartyVO.miracleEndTime}</h4>
          </div>
          <div class="activity">
            <img src="../resources/img/activity.png" class="activity-img" />
            <h5 class="activity-text">ACTIVITY</h5>
            <h4>${recruitPartyVO.activity}</h4>
          </div>
          <div class="people">
            <img src="../resources/img/profile-2user.png" class="people-img" />
            <h5 class="people-text">PEOPLE</h5>
            <h4>${recruitPartyVO.memberCount}/${recruitPartyVO.maxMemberCount}</h4>
          </div>
          <div class="welcome">
            <img src="../resources/img/medal.png" class="welcome-img" />
            <h5 class="welcome-text">WELCOME</h5>
            <div class="welcomeText">${recruitPartyVO.content}</div>
          </div>
        </div>
        <div class="right">
          <div class="percent">
            <img src="../resources/img/chart.png" class="percent-img" />
            <h5 class="percent-text">참여율</h5>
            <div class="chartResult">구글차트</div>
          </div>
        </div>
      </div>
      <div class="partyBtn">
        <c:if test="${partyId == null && partyApplicantVO == null}">
		<form action="/miraclebird/party/join" method="post">
			<input type="hidden" name="partyId" value="${recruitPartyVO.partyId}" />
			<button class="join" type="submit">가입신청</button>
		</form>
		</c:if>
		<c:if test="${partyId == null && partyApplicantVO.partyId == recruitPartyVO.partyId}">
			<a href="/miraclebird/party/join/cancel">
				<button class="join" type="button">신청 취소</button>
			</a>
		</c:if>
		<c:if test="${partyId == recruitPartyVO.partyId && isLeader}">
			<a href="/miraclebird/recruit/${recruitPartyVO.recruitId}/update">
				<button class="join" type="button">수정</button>
			</a>
			<a href="/miraclebird/recruit/${recruitPartyVO.recruitId}/delete">
				<button class="join" type="button">삭제</button>
			</a>
		</c:if>
        <a href="/miraclebird/recruit/list">
        	<button class="back" type="button">BACK</button>
        </a>
      </div>
    </div>

</body>
</html>