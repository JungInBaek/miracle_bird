<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>파티 모집글 상세보기</title>
    <link rel="stylesheet" href="../resources/css/partyFindDetail99.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css">
    <link href="https://fonts.googleapis.com/css2 family=Noto+Sans+KR:wght@100;300;400;500;700;900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
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
            <div class="party-title">지옥에서 돌아온 닭</div>
            <div class="party-info">미라클 활동 시간이 저희 파티와 맞고 헬스를 통해 이루고 싶은 목표가 있지만 혼자서 실천하기
                힘드신 분들을 모집합니다! 저희와 추구하는 방향이 비슷하시면 누구든 가입이 가능합니다!</div>
            <div class="btn-box"><button>JOIN</button></div>
        </div>

        <div class="party-details">
            <div class="activity detail">Activity
                <div>운동</div>
            </div>
            <div class="time detail">Time
                <div>05:00 ~ 07:00</div>
            </div>
            <div class="people detail">People
                <div>5인 이내</div>
            </div>
        </div>
    </div>

    <img src="../resources/img/bird.png" alt="새" class="bird">
</body>
</html>