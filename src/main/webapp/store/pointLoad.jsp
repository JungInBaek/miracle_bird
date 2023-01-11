<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>포인트 충전소</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pointLoad.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css">
    <link
        href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap"
        rel="stylesheet">
</head>

<body>
    <!-- 프로필 -->
    <div class="profile">
        <div class="circle-container">
            <img src="./img/profile.png" alt="">
        </div>
        <div class="name">홍길동</div>
        <div class="account">@Hongildong</div>
        <div class="point-container">
            <img src="./img/money.svg" alt="저금통" class="point-icon">
            <span class="point">5,000</span>
        </div>
        <div class="category">
            <div>
                <a href="#">
                    <div class="color category-item">
                        <img src="./img/palette.svg" alt="색상" class="color-icon mouseover">
                        <span class="color-text mouseover">컬러</span>
                    </div>
                </a>
                <a href="#">
                    <div class="speech-bubble category-item">
                        <img src="./img/bubble.svg" alt="말풍선" class="bubble-icon mouseover">
                        <span class="bubble-text mouseover">말풍선</span>
                    </div>
                </a>
            </div>
            <a href="#">
                <div class="add-point category-item">
                    <img src="img/add-coin.svg" alt="포인트" class="add-icon mouseover">
                    <span class="add-text mouseover">포인트 충전</span>
                </div>
            </a>
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
                        <li class="nav-item"><a href="#">JOIN</a></li>
                        <li class="nav-item"><a href="#">MY PARTY</a></li>
                        <li class="nav-item"><a href="#">PROFILE</a></li>
                        <li class="nav-item"><a href="#">STORE</a></li>
                        <li class="nav-item"><button>LOGIN</button></a></li>
                    </ul>
                </nav>
            </div>
        </header>

        <!-- 컨텐츠 -->
        <div class="contents-inner">
            <div class="contents-title">포인트 충전소</div>
            <div class="contents">
                <div class="content">
                    <div class="content-image">
                        <span class="point">1,000 P</span>
                        <img src="./img/천.png" alt="천원">
                    </div>
                    <div class="content-text">
                        <button>구매하기</button>
                    </div>
                </div>
                <div class="content">
                    <div class="content-image">
                        <span class="point">5,000 P</span>
                        <img src="./img/오천.png" alt="오천원">
                    </div>
                    <div class="content-text">
                        <button>구매하기</button>
                    </div>
                </div>
                <div class="content">
                    <div class="content-image">
                        <span class="point">10,000 P</span>
                        <img src="./img/만.png" alt="만원">
                    </div>
                    <div class="content-text">
                        <button>구매하기</button>
                    </div>
                </div>
                <div class="content">
                    <div class="content-image">
                        <span class="point">50,000 P</span>
                        <img src="./img/오만.png" alt="오만원">
                    </div>
                    <div class="content-text">
                        <button>구매하기</button>
                    </div>
                </div>
            </div>
        </div>
        
    </div>
</body>

</html>