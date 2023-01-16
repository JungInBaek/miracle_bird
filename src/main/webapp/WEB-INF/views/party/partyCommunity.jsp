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
     <link href="${pageContext.request.contextPath}/resources/css/partyCommunity.css" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <link
        href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap”
        rel=“stylesheet”>
    <link rel=“stylesheet”
    href=“https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css”>
    <title>Party Feed</title>
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
    <div >
        <div class="cate">
            <a href="/miraclebird/party/main">
            	<button class="btn">Main</button>
            </a>
            <a href="/miraclebird/party/feed">
            	<button class="btn">Feed</button>
            </a>
            <button class="btn">Community</button>
            <a href="/miraclebird/party/members">
            	<button class="btn">People</button>
            </a>
            <c:if test="${isLeader}">
            	<a href="/miraclebird/party/applicants">
            		<button class="btn">Applicants</button>
            	</a>
            </c:if>
            <c:if test="${isLeader}">
            	<a href="/miraclebird/party/applicants">
            		<button class="btn">Style</button>
            	</a>
            </c:if>
        </div>
    <div class="mainInfo">
        <div class="main">
            <div class="mainContent">
                <div class="contentMain">
                    <div class="content">
                        <p style="text-align: right;">날짜</p><br>
                        <p style="text-align: center;">제목</p><br>
                        <p>이름</p>
                    </div>
                    <div class="content">
                        <p style="text-align: right;">날짜</p><br>
                        <p style="text-align: center;">제목</p><br>
                        <p>이름</p>
                    </div>
                    <div class="content">
                        <p style="text-align: right;">날짜</p><br>
                        <p style="text-align: center;">제목</p><br>
                        <p>이름</p>
                    </div>
                    <div class="content">
                        <p style="text-align: right;">날짜</p><br>
                        <p style="text-align: center;">제목</p><br>
                        <p>이름</p>
                    </div>
                </div>
                <!-- 모달창 -->
                <div id="wrap">
                <section class="contentModal">
                    <div class="containerModal">
                    <div>
                        <button class="create" onClick="javascript:popOpen();">글쓰기</button>
                    </div>
                    </div>
                </section>   
                </div>
                <form action="">
                    <div class="modal-bg" onClick="javascript:popClose();"></div>
                    <div class="modal-wrap">
                        <button class="modal-close" onClick="javascript:popClose();">&times;</button>
                    </div>
        <!-- //modal 영역 -->
                    <div class="modal-bg" onClick="javascript:popClose();"></div>
                    <div class="modal-wrap">
                        <span>
                            <h4 style=" margin: 20px; display: inline;">글쓰기</h4>
                            <button class="modal-close" onClick="javascript:popClose();">&times;</button>
                        </span>
                        <textarea placeholder="새로운 내용을 남겨주세요!"></textarea>
                        <button type="submit" class="complete">작성하기</button>
                    </div>
                </form>
            </div>
            <div class="mainText">
                <a>환영합니다. 지옥에서 돌아온 닭 파티룸입니다.</a>
            </div>
        </div>
        
    </div>
    </div>
    <script lang="javascript">
        function popOpen() {
            var modalPop = $('.modal-wrap');
            var modalBg = $('.modal-bg'); 
            
            $(modalPop).show();
            $(modalBg).show();
        }
        
        function popClose() {
            var modalPop = $('.modal-wrap');
            var modalBg = $('.modal-bg');
            
            $(modalPop).hide();
            $(modalBg).hide();
        }
    </script>
    <script lang="javascript">
        function popOpen1() {
            var modalPop1 = $('.modal-wrap1');
            var modalBg1 = $('.modal-bg1'); 
            
            $(modalPop1).show();
            $(modalBg1).show();
        }
        
        function popClose1() {
            var modalPop1 = $('.modal-wrap1');
            var modalBg1 = $('.modal-bg1');
            
            $(modalPop1).hide();
            $(modalBg1).hide();
        }
    </script>


</body>
</html>