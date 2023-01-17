<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>파티 모집글 상세보기</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/partyFindDetail88.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css">
    <link href="https://fonts.googleapis.com/css2 family=Noto+Sans+KR:wght@100;300;400;500;700;900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
</head>
<body>
    <!-- 헤더 -->
    <header>
        <div class="head">
            <!-- 로고 -->
            <a href="/miraclebird">
          		<img src="resources/img/logo.svg" alt="로고" class="logo" />
        	</a>
            <!-- 네비게이션바 -->
            <nav>
                <ul class="nav-container animate__animated animate__fadeIn">
                    <li class="nav-item"><a href="/miraclebird">COMMUNITY</a></li>
                    <li class="nav-item"><a href="/miraclebird/recruit/list">FIND</a></li>
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

    <!-- 명언 -->
    <div class="saying">
        <div class="saying-content">오늘 하루는 미래의 이틀을 합친 것보다 더 가치가 있다. 지금의 내가 미래의 나를 만든다.</div>
        <div class="saying-title">Benjamin Franklin</div>
    </div>

    <!-- 배경 이미지 -->
    <div class="img-bg"></div>

    <!-- 내용 -->
    <div class="title">View Details</div>

    <div class="party-contents">
        <div class="party-contents-main">
            <div class="party-title">${recruitPartyVO.name}</div>
            <div class="party-info">${recruitPartyVO.content}</div>
			<div class="btn-box">
	            <c:if test="${partyId == null && partyApplicantVO == null}">
					<form action="/miraclebird/party/join" method="post">
						<input type="hidden" name="partyId" value="${recruitPartyVO.partyId}" />
							<button>JOIN</button>
					</form>
				</c:if>
				<c:if test="${partyId == null && partyApplicantVO.partyId == recruitPartyVO.partyId}">
					<a href="/miraclebird/party/join/cancel">
							<button>CANCEL</button>
					</a>
				</c:if>
				<c:if test="${partyId == recruitPartyVO.partyId && isLeader}">
					<a href="/miraclebird/recruit/${recruitPartyVO.recruitId}/update">
						<button>EDIT</button>
					</a>
					<a href="/miraclebird/recruit/${recruitPartyVO.recruitId}/delete">
						<button>DELETE</button>
					</a>
				</c:if>
				<a href="/miraclebird/recruit/list">
					<button>BACK</button>
				</a>
			</div>
			<div class="guide">⚠️ 하나의 파티에만 가입이 가능합니다. 신중히 결정하여 가입하시길 바랍니다!</div>
        </div>

        <div class="party-details">
            <div class="activity detail">Activity
                <div>${recruitPartyVO.activity}</div>
            </div>
            <div class="time detail">Time
                <div>${recruitPartyVO.miracleStartTime} ~ ${recruitPartyVO.miracleEndTime}</div>
            </div>
            <div class="people detail">People
                <div>${recruitPartyVO.memberCount}/${recruitPartyVO.maxMemberCount}</div>
            </div>
        </div>
    </div>

    <img src="${pageContext.request.contextPath}/resources/img/bird.png" alt="새" class="bird">
</body>
</html>