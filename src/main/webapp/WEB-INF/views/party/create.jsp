<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/create.css" rel="stylesheet" type="text/css">
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
                <img src="../resources/img/logo.svg" alt="로고" class="logo">
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
        <div class="partyInfo">
            <!-- form action 넣기 -->
            <form action="/miraclebird/party/create" method="post">
                <table class="party">
                    <tbody>
                        <tr>
                            <td><img src="../resources/img/activity.png" class="img" /></td>
                            <td><a>Party</a></td>
                            <td><input class="inputBox" name="name" placeholder="파티 명을 입력해주세요."></td>
                        </tr>
                        <div class="dropdownP">
                            <tr>
                                <td><img src="../resources/img/time.png" class = "img" /></td>
                                <td><a>TIME</a></td>
                                <td>
                                    <input type="time" name="miracleStartTime" min="04:00:00" max="12:00:00" class="inputTime" />
                                    <a>-</a>
                                    <input type="time" name="miracleEndTime" min="04:00:00" max="12:00:00" class="inputTime" />
                                </td>
                            </tr>
                        </div>
                            <tr>
                            <td><img src="../resources/img/activity.png" class="img" /></td>
                            <td><a>ACTIVITY</a></td>
                            <td><input class="inputBox" placeholder="파티 활동을 입력해주세요." name="activity"></td>
                        </tr>
                        <tr>
                            <td><img src="../resources/img/profile-2user.png" class="img" /></td>
                            <td><a>PEOPLE</a></td>
                            <td><input name="maxMemberCount" class="inputBox" placeholder="파티 인원을 입력해주세요."></td>
                        </tr>
                        <tr>
                            <td><img src="../resources/img/medal.png" class="img" /></td>
                            <td><a>WELCOME</a></td>
                            <td><textarea class="partyT" placeholder="파티를 간단하게 소개해주세요." name="info"></textarea></td>
                        </tr>
                    </tbody>
                </table>
                <div class="partyBtn">
            		<button type="submit" class="create">CREATE</button>
            		<a href="/miraclebird/recruit/list">
            			<button type="button" class="cancle">CANCEL</button>
            		</a>
        		</div>
             </form>
        </div>
</div>
<!-- <hr>
<form action="/miraclebird/party/create" method="post">
파티명 : <input type="text" name="name" /> <br/>
한줄소개 : <input type="text" name="info" /> <br/>
미라클활동 시간 : <input type="time" name="miracleStartTime" min="04:00:00" max="12:00:00" /> ~ <input type="time" name="miracleEndTime" min="04:00:00" max="12:00:00" /> <br />
미라클 활동 : <input type="text" name="activity" /> <br />
<button>생성</button>
</form>
<a href="/miraclebird/recruit/list">취소</a> -->

</body>
</html>