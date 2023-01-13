<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="../resources/css/partyApplicants.css" rel="stylesheet" type="text/css">
    <link
        href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap”
        rel=“stylesheet”>
    <link rel=“stylesheet”
    href=“https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css”>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <title>Party 신청 목록</title>
    <style type="text/css">
    	.partyApBtn {
    		display: flex;
    	}
    	.btnA {
    		margin: 5px;
    	}
    	.btnB {
    		margin: 5px;
    	}
    </style>
</head>
<body>
<header>
        <div class="head">
            <!-- 로고 -->
            <a href="/miraclebird">
                <img src="../resources/img/logo.svg" alt="로고" class="logo">
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
    <div >
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
            <div class="mainContent">
                <div class="content">
                	<c:forEach var="vo" items="${list}">
                		<div class="people">
                        	<img src="../resources/img/profile-circle.png" class="icon">
                            <ul>
                                <li>
                                    ${vo.username}
                                </li>
                                <li>
                                    ${vo.partyName}
                                </li>
                                <li>
                                	<fmt:parseDate value="${vo.applicantDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" />
                                	<fmt:formatDate value="${parsedDateTime}" type="both" />
                                </li>
                            </ul>
                            <div class="partyApBtn">
                            	<form action="/miraclebird/party/accept" method="post">
                            		<input type="hidden" name="partyApplicantId" value="${vo.partyApplicantId}" />
                            		<input type="hidden" name="partyId" value="${vo.partyId}" />
                            		<input type="hidden" name="userId" value="${vo.userId}" />
                                	<button class="btnA">수락</button>
                            	</form>
                            	<form action="/miraclebird/party/reject" method="post">
                            		<input type="hidden" name="partyApplicantId" value="${vo.partyApplicantId}" />
                            		<input type="hidden" name="partyId" value="${vo.partyId}" />
                            		<input type="hidden" name="userId" value="${vo.userId}" />
                                	<button class="btnB">거절</button>
                            	</form>
                            </div>
                    	</div>
                	</c:forEach>
                </div>
            </div>
            <div class="mainText">
                <a>${partyVO.intro}</a>
            </div>
        </div>
    </div>
    </div>

</body>
</html>