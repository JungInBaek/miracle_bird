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
    <link href="resources/css/partyPostDetail.css" rel="stylesheet" type="text/css">
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
        <a href="#">
          <img src="resources/img/logo_blue.svg" alt="로고" class="logo" />
        </a>
        <!-- 네비게이션바 -->
        <div class="cate">
            <a href="/miraclebird/party/main">
            	<button class="btn">Main</button>
            </a>
            <button class="btn">Feed</button>
            <button class="btn">Community</button>
            <c:if test="${isLeader}">
            	<a href="/miraclebird/party/applicants">
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
      </div>
    </header>
    <div class="box">
      <h2 class="partyName">지옥에서 돌아온 닭</h2>
      <div class="partyInfo">
        <div class="left">
          <div class="time">
            <img src="resources/img/time.png" class="time-img" />
            <h5 class="time-text">TIME</h5>
            <h4>시간</h4>
          </div>
          <div class="activity">
            <img src="resources/img/activity.png" class="activity-img" />
            <h5 class="activity-text">ACTIVITY</h5>
            <h4>활동</h4>
          </div>
          <div class="people">
            <img src="resources/img/profile-2user.png" class="people-img" />
            <h5 class="people-text">PEOPLE</h5>
            <h4>인원수</h4>
          </div>
          <div class="welcome">
            <img src="resources/img/medal.png" class="welcome-img" />
            <h5 class="welcome-text">WELCOME</h5>
            <div class="welcomeText">안녕하세요</div>
          </div>
        </div>
        <div class="right">
          <div class="percent">
            <img src="resources/img/chart.png" class="percent-img" />
            <h5 class="percent-text">참여율</h5>
            <div class="chartResult">구글차트</div>
          </div>
        </div>
      </div>
      <div class="partyBtn">
        <button class="join" type="submit">JOIN</button>
        <button class="back" type="button">BACK</button>
      </div>
    </div>

</body>
</html>