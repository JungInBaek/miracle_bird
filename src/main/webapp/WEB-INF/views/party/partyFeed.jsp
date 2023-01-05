<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="resources/css/partyFeed.css" rel="stylesheet" type="text/css">
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
            <a href="#">
                <img src="resources/img/logo.svg" alt="로고" class="logo">
            </a>
            <!-- 네비게이션바 -->
            <nav>
                <ul class="nav-container">
                    <li class="nav-item"><a href="#">COMMUNITY</a></li>
                    <li class="nav-item"><a href="#">JOIN</a></li>
                    <li class="nav-item"><a href="#">MY PARTY</a></li>
                    <li class="nav-item"><a href="#">PROFILE</a></li>
                    <li class="nav-item"><a href="#">STORE</a></li>
                    <li class="nav-item"><button>LOGIN</button></li>
                </ul>
            </nav>
        </div>
    </header>
    <div >
        <div class="cate">
            <button class="btn">Main</button>
            <button class="btn">Feed</button>
            <button class="btn">Community</button>
            <button class="btn">Style</button>
            <button class="btn">People</button>
        </div>
    <div class="mainInfo">
        <div class="main">
            <div class="mainContent">
                <button class="previous"><img src="resources/img/arrow-circle-left1.png" alt="이전"></button>
                <div class="content">
                    <img src="resources/img/activity.png" class="contentImg">
                    <div class="contentText">
                        <h5 class="name">이름</h5>
                        <h6 class="hash">태그</h6>
                        <h6 class="time">시간</h6>
                    </div>
                </div>
                <div class="content">
                    <img src="resources/img/activity.png" class="contentImg">
                    <div class="contentText">
                        <h5 class="name">이름</h5>
                        <h6 class="hash">태그</h6>
                        <h6 class="time">시간</h6>
                    </div>
                </div>
                <div class="content">
                    <img src="resources/img/activity.png" class="contentImg">
                    <div class="contentText">
                        <h5 class="name">이름</h5>
                        <h6 class="hash">태그</h6>
                        <h6 class="time">시간</h6>
                    </div>
                </div>
                <button class="next" type="submit"><img class="btn-img" src="resources/img/arrow-circle-right1.png"></button>
            </div>
            <div class="mainText">
                <a>환영합니다. 지옥에서 돌아온 닭 파티룸입니다.</a>
            </div>
        </div>
        
    </div>
    </div>
</body>
</html>