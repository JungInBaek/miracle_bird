<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내 피드</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/myFeed.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css">
    <link
        href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap"
        rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
	$.ajax({
		url : "feed/oneProfile",
		success : function(profileResult) {
			$("#profileResult").html(profileResult);
		}
	})
	$.ajax({
		url : "feed/all",
		success : function(feedResult) {
			$('#feedResult').html(feedResult);
		}
	})
	</script>
</head>

<body>
    <!-- 프로필 -->
    <div class="profile" id="profileResult">
    </div>
    <!-- 메인 -->
    <div class="main">
        <!-- 헤더 -->
        <header>
            <div class="head">
                <!-- 네비게이션바 -->
                <nav>
                    <ul class="nav-container">
                        <li class="nav-item"><a href="#">COMMUNITY</a></li>
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
        <!-- 피드 -->
        <div class="feed-title">My Feed</div>
        <div class="feeds" id="feedResult">
        </div>
    </div>
</body>

</html>