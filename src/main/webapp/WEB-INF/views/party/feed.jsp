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
    <link href="${pageContext.request.contextPath}/resources/css/partyFeed5.css" rel="stylesheet" type="text/css">
    <link
        href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap”
        rel=“stylesheet”>
    <link rel=“stylesheet”
    href=“https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css”>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <title>Party Feed</title>
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
            	<c:choose>
                <c:when test="${pageVO.prev}">
            		<a href="/miraclebird/party/feed?page=${pageVO.pageParam.page - 1}" >
                		<button class="previous"><img src="../resources/img/arrow-circle-left1.png" alt="이전"></button>
            		</a>
                </c:when>
                <c:otherwise>
                		<button class="previous"><img src="../resources/img/arrow-circle-left.png" alt="이전"></button>
                </c:otherwise>
                </c:choose>
                <c:forEach var="vo" items="${list}">
                	<div class="content">
                    	<img src="${vo.mediaUrl}" class="contentImg">
                    	<div class="contentText">
                        	<h5 class="name">${vo.username}</h5>
                        	<h6 class="hash">${vo.caption}</h6>
                        	<fmt:parseDate value="${vo.feedTime}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" />
                            <h6 class="time"><fmt:formatDate value="${parsedDateTime}" type="both" /></h6>
                    	</div>
                	</div>
                </c:forEach>
                <c:choose>
	                <c:when test="${pageVO.next}">
	            		<a href="/miraclebird/party/feed?page=${pageVO.pageParam.page + 1}">
	                		<button class="next" type="submit"><img class="btn-img" src="../resources/img/arrow-circle-right1.png"></button>
	                	</a>
	                </c:when>
	                <c:otherwise>
	                		<button class="next"><img src="../resources/img/arrow-circle-right.png" alt="이전"></button>
	                </c:otherwise>
                </c:choose>
            </div>
            <div class="mainText">
                <a>${partyVO.intro}</a>
            </div>
        </div>
    </div>
    </div>
    <script lang="javascript">
    	let list;
    	$.ajax({
    		type: "get",
    		url: "/miraclebird/party/products",
    		async: false,
    		dataType: "json",
    		success: function(data) {
    			list = data;
    			console.log(data);
    		}
    	});
    	
    	function backChange(){
            // 데이터에 있는 색상 코드 입력
            // var Acolor = new Array('red', 'orange', 'green');
            var Acolor = list;
            var Bcolor = Math.floor(Math.random() * Acolor.length);
            var Ccolor = Acolor[Bcolor]; 
            document.getElementById('bg').style.background=Ccolor;
            document.getElementById('here').style.background=Ccolor;
        }
    	
        setInterval(backChange,8000);
    </script>
</body>
</html>