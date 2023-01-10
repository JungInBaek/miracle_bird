<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/css/communityDetail.css" />
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <link
        href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap”
        rel=“stylesheet”>
    <link rel=“stylesheet”
    href=“https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css”>
    <script src="https://unpkg.com/@yaireo/tagify"></script>
<script src="https://unpkg.com/@yaireo/tagify/dist/tagify.polyfills.min.js"></script>
<link href="https://unpkg.com/@yaireo/tagify/dist/tagify.css" rel="stylesheet" type="text/css" />
    <title>커뮤니티 상세보기</title>
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
    <div class="back">
        <h1 style="text-align: center; line-height: 70px; font-weight: bold;">
            Community
        </h1>
    </div>
    <div class="container">
        <div class="search">
            <input type="text" placeholder="검색어를 입력해주세요." class="searchInput"/>
            <a href="#">
                <img src="resources/img/search-normal.png"class="searchBtn">
            </a>
        </div>
        <div class="mainContent">
            <div class="profile">
                <img src="resources/img/profile.png" class="img">
                <div class="userInfo">
                    <a>사용자 이름</a>
                    <br>
                    <a>작성 날짜</a>
                </div>
            </div>
            <div class="content-text">
                <div class="contentInfo">
                    <h5>
                        제목
                        예전에 한 때 홈페이지에 항상 퀵메뉴가 있던 시절이 있었는데,
                        예전에 한 때 홈페이지에 항상 퀵메뉴가 있던 시절이 있었는데,
                        예전에 한 때 홈페이지에 항상 퀵메뉴가 있던 시절이 있었는데,
                    </h5>
                </a>
                </div>
                <hr style="border: 3px solid #Ffb100; margin: 10px; background-color: #ffb100;">
                <div class="boardInfo">예전에 한 때 홈페이지에 항상 퀵메뉴가 있던 시절이 있었는데,
    
                    없어지는 듯 하다가 요새 다시 보이는 듯 하다.
                    
                    
                    아무래도 쇼핑몰이나 고객의 요구에 빨리 응해야하는 사이트에서는 퀵메뉴가 필수불가결한 요소인 것 같다.
                    
                    보통 오른쪽에 완전히 고정해두는 형태(position:absolute)로 넣을 수도 있지만 완전 고정해두면 좀 유연성이 없어보이고(?)
                    
                    너무 큰 사이즈로 넣는다면 사이트의 다른 구성요소보다 더 이목이 집중되는 느낌...
                    요새는 아래처럼 작은메뉴를 만들어 스크롤 내릴때 마다 부드럽게 따라오는 형태로 많이 사용하는 것 같다.
                    
                    jquery를 활용하면 부드럽게 따라오는 메뉴를 만들 수 있다.</div>
                    <div class="btnUpdate">
                        <button class="update">수정</button>
                        <button class="delete">삭제</button>
                    </div>
                    <hr style="border: 3px solid #Ffb100; margin: 10px; background-color: #ffb100;">
                    <div class="another">
                        <div class="previous">
                            <img src="resources/img/arrow-left.png" width="30px" style="margin-right: 10px;">
                            이전글
                        </div>
                        <div class="next">
                            다음글
                            <img src="resources/img/arrow-right.png" width="30px" style="margin-left: 10px;">
                        </div>
                    </div>
                    <hr class="commentHr">
                    <div class="commentTitle">
                        <img src="resources/img/message-text.png">
                        comment
                    </div>
                    <div class="containerForm">
                        <form name="commentInsertForm" action="">
                            <div class="input-group">
                                <input type="hidden" name="bno" value="${detail.bno}"/>
                                <input type="text" class="comment" style="border-radius: 10px 0px 0px 10px; border: #Ffb100 2px solid; padding: 5px;"name="comment" placeholder="내용을 입력하세요.">
                                <span>
                                    <button class="commentBtn" type="button">등록</button>
                                </span>
                            </div>
                        </form>
                    </div>
                    <div class="container">
                        <div class="commentList"></div>
                    </div>
                </div>
        </div>

</body>
</html>