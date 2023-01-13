<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../resources/css/partyFindList99.css" />
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"/>
    <title>파티 목록 화면</title>
</head>

<body>
    <!-- 헤더 -->
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
    <div class="contents">
    	<!-- 좌측 섹션 -->
        <div class="left">
            <div class="page-title">Party List</div>
            <div class="page-info">늘 계획만 세우고 실천에 옮기는 데 실패하셨나요? 더이상 혼자 고민하지 마세요. 원하는 파티에 참여하여 미라클 모닝을 함께 실현하세요!</div>

            <div class="search">
                <span>Search</span>
                <span class="underline"><input type="text"></span>
                <button><img src="resources/img/search.svg" alt="search"></button>
            </div>

            <div class="btn-container">
                <a class="btn">
                    <button>
                        <img src="resources/img/apply.svg" alt="apply">
                    </button>
                    <span>파티 신청 현황</span>
                </a>
                <a class="btn">
                    <button>
                        <img src="resources/img/create.svg" alt="create">
                    </button>
                    <span>파티 생성</span>
                </a>
                <a class="btn">
                    <button>
                        <img src="resources/img//write.svg" alt="write">
                    </button>
                    <span>파티 모집글 생성</span>
                </a>
            </div>
        </div>

		<!-- 우측 섹션 -->
        <div class="right">
            <a href="#" class="info">
                <div class="info-top">
                    <span>Activity</span>
                    <span>운동</span>
                </div>
                <div class="info-middle">
                    <div class="time">05:00 ~ 07:00</div>
                    <div class="title">지옥에서 돌아온 닭</div>
                </div>
                <div class="info-bottom">
                    <img src="./img/arrow.svg" alt="enter">
                </div>
            </a>
        <div class="right">
            <a href="#" class="info">
                <div class="info-top">
                    <span>Activity</span>
                    <span>운동</span>
                </div>
                <div class="info-middle">
                    <div class="time">05:00 ~ 07:00</div>
                    <div class="title">지옥에서 돌아온 닭</div>
                </div>
                <div class="info-bottom">
                    <img src="./img/arrow.svg" alt="enter">
                </div>
            </a>

        </div>
    </div>
</body>

</html>