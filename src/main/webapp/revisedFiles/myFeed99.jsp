<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>

<body>
    <!-- 프로필 -->
    <div class="profile">
        <div class="profile-inner">
            <div class="circle-container">
                <img src="../resources/img/profile.png" alt="">
            </div>
            <div class="account">@hongildong</div>
            <div class="edit-profile">
                <a href="#">
                    <div>프로필 수정</div>
                </a>
            </div>

            <div class="number">
                <div class="post">
                    <span class="content">32</span>
                    <span class="sub-title">Posts</span>
                </div>
                <div class="time">
                    <span class="content">05:00 ~ 07:00</span>
                    <span class="sub-title">Time</span>
                </div>
            </div>

            <div class="text-box">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dignissimos id
                repellat, impedit ad reprehenderit maiores ut quia. Modi sunt officia
                quibusdam, aperiam,
            </div>
        </div>
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
                        <li class="nav-item"><a href="#">FIND</a></li>
                        <li class="nav-item"><a href="#">MY PARTY</a></li>
                        <li class="nav-item"><a href="#">MY FEED</a></li>
                        <li class="nav-item"><a href="#">PROFILE</a></li>
                        <li class="nav-item"><a href="#">STORE</a></li>
                        <li class="nav-item"><a href="#"><button>LOGIN</button></a></li>
                    </ul>
                </nav>
            </div>
        </header>
        <!-- 피드 -->
        <div class="feed-title">My Feed</div>
        <div class="feeds">
            <div class="feed">
                <div class="feed-img"><img src="../resources/img/50000.png" alt="image"></div>
                <h5 class="feed-user">User</h5>
                <div class="feed-time">06:05:07 (2023-01-09)</div>
                <p class="feed-tag">#미라클버드</p>
            </div>
        </div>
    </div>
</body>

</html>