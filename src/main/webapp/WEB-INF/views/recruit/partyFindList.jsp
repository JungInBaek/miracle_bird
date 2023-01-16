<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/partyFindList99.css" />
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"/>
    <title>파티 목록 화면</title>
    <!-- <script type="text/javascript">
    	var msg = "<c:out value='${msg}' />"
    	var url = "<c:out value='${url}' />"
    	alert(msg);
    	location.href = url;
    </script> -->
</head>

<body>
    <!-- 헤더 -->
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

    <!-- 컨텐츠 -->
    <div class="contents">
    
    	<!-- 좌측 컨텐츠 섹션 -->
        <div class="left">
            <div class="page-title">Party List</div>
            <div class="page-info">늘 계획만 세우고 실천에 옮기는 데 실패하셨나요? 더이상 혼자 고민하지 마세요. 원하는 파티에 참여하여 미라클 모닝을 함께 실현하세요!</div>

            <div class="search">
                <span>Search</span>
                <span class="underline"><input type="text"></span>
                <button><img src="${pageContext.request.contextPath}/resources/img/search.svg" alt="search"></button>
            </div>

            <div class="btn-container">
                <a class="btn" style="text-decoration: none;">
                    <button>
                        <img src="${pageContext.request.contextPath}/resources/img/apply.svg" alt="apply">
                    </button>
                    <span>파티 신청 현황</span>
                </a>
                <a class="btn" href="/miraclebird/party/create" style="text-decoration: none;">
                    <button>
                        <img src="${pageContext.request.contextPath}/resources/img/create.svg" alt="create">
                    </button>
                    <span>파티 생성</span>
                </a>
                <a class="btn" href="/miraclebird/recruit/create" style="text-decoration: none;">
                    <button>
                        <img src="${pageContext.request.contextPath}/resources/img/write.svg" alt="write">
                    </button>
                    <span>파티 모집글 생성</span>
                </a>
            </div>
        </div>

		<!-- 우측 컨텐츠 섹션 -->
		<div class="right">
		<c:forEach var="vo" items="${list}">
			<a href="/miraclebird/recruit/${vo.recruitId}" class="info">
	                <div class="info-top">
	                    <span>Activity</span>
	                    <span>${vo.activity}</span>
	                </div>
	                <div class="info-middle">
	                    <div class="time">${vo.miracleStartTime} ~ ${vo.miracleEndTime}</div>
	                    <div class="title">${vo.name}</div>
	                </div>
	                <div class="info-bottom">
	                    <img src="${pageContext.request.contextPath}/resources/img/arrow.svg" alt="enter">
	                </div>
	        </a>
        </c:forEach>
        </div>
    </div>
</body>

</html>