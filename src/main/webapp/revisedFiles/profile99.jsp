<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내 프로필</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/profile99.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css">
    <link
        href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap"
        rel="stylesheet">
</head>

<body>
    <!-- 헤더 -->
    <header>
        <div class="head">
            <!-- 로고 -->
            <a href="#">
                <img src="../resources/img/logo.svg" alt="로고" class="logo">
            </a>
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

    <!-- 나의 정보 -->
    <div class="info">
        <form action="">
            <!-- 좌측 정보 -->
            <div class="info-left">
                <div class="image-resizing">
                    <img src="../resources/img/profile.png" alt="프로필 사진">
                </div>
                <input type="file" name="file" id="file" accept="image/*">
                <label for="file">
                    <div class="btn-upload">사진 업로드</div>
                </label>
            </div>

            <!-- 우측 정보 -->
            <div class="info-right">
                <div class="title">나의 정보</div>
                <div class="intro-title">자기 소개</div>
                <div class="intro">
                    <textarea name="" id="" rows="7"></textarea>
                </div>
                <div class="time-title">활동 시간대</div>
                <div class="time">
                    <span><input type="time" id="from"></span>
                    <span>~</span>
                    <span><input type="time" id="to"></span>
                </div>

                <button class="btn-submit">Edit Profile</button>
            </div>
        </form>


        <!-- 잔디 -->
        <div class="grass-field"> 내가 심은 기록 보기
            <div class="grass">요 안에다가 넣으심 됩니당</div>
        </div>
    </div>
    </div>
</body>

</html>