<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>미라클 스토어</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/store.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css">
    <link
        href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap"
        rel="stylesheet">
</head>

<body>
    <!-- 프로필 -->
    <div class="profile">
        <div class="circle-container">
            <img src="../resources/img/profile.png" alt="">
        </div>
        <div class="account">@Hongildong</div>
        <div class="point-container">
            <img src="../resources/img/money.svg" alt="저금통" class="point-icon">
            <span class="point">5,000</span>
        </div>
        <div class="category">
            <div>
                <a href="#">
                    <div class="color-box category-item">
                        <img src="../resources/img/palette.svg" alt="색상" class="color-icon">
                        <span class="color-text">컬러</span>
                    </div>
                </a>
                <a href="#">
                    <div class="speech-bubble category-item">
                        <img src="../resources/img/bubble.svg" alt="말풍선" class="bubble-icon mouseover">
                        <span class="bubble-text mouseover">말풍선</span>
                    </div>
                </a>
                <a href="#">
                    <div class="character category-item">
                        <img src="../resources/img/character.svg" alt="캐릭터" class="character-icon mouseover">
                        <span class="character-text mouseover">캐릭터</span>
                    </div>
                </a>
            </div>
            <div class="btn-container">
                <a href="">
                    <div class="add-point btn">
                        <img src="../resources/img/add-coin.svg" alt="포인트" class="add-icon mouseover">
                        <span class="add-text mouseover">포인트 충전</span>
                    </div>
                </a>
                <a href="">
                    <div class="buy-history btn">
                        <img src="../resources/img/list.svg" alt="포인트" class="add-icon mouseover">
                        <span class="add-text mouseover">구매 내역</span>
                    </div>
                </a>
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

        <!-- 컨텐츠 -->
        <div class="contents-title">Colors</div>
        <div class="item-container">
            <div class="item">
                <div class="item-image"></div>
                <div class="item-text">
                    <div class="item-text-title">빨강</div>
                    <div class="item-price">₩800</div>
                </div>
                <div class="item-buy">구매하기</div>
            </div>
            <div class="item">
                <div class="item-image"></div>
                <div class="item-text">
                    <div class="item-text-title">노랑</div>
                    <div class="item-price">₩800</div>
                </div>
                <div class="item-buy">구매하기</div>
            </div>
            <div class="item">
                <div class="item-image"></div>
                <div class="item-text">
                    <div class="item-text-title">초록</div>
                    <div class="item-price">₩800</div>
                </div>
                <div class="item-buy">구매하기</div>
            </div>
            <div class="item">
                <div class="item-image"></div>
                <div class="item-text">
                    <div class="item-text-title">민트</div>
                    <div class="item-price">₩800</div>
                </div>
                <div class="item-buy">구매하기</div>
            </div>
            <div class="item">
                <div class="item-image"></div>
                <div class="item-text">
                    <div class="item-text-title">파랑</div>
                    <div class="item-price">₩800</div>
                </div>
                <div class="item-buy">구매하기</div>
            </div>
            <div class="item">
                <div class="item-image"></div>
                <div class="item-text">
                    <div class="item-text-title">보라</div>
                    <div class="item-price">₩800</div>
                </div>
                <div class="item-buy">구매하기</div>
            </div>
        </div>

        <ul class="pages">
            <li><a href="#" class="page">1</a></li>
        </ul>
    </div>
</body>

</html>