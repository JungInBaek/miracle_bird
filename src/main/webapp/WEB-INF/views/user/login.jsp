<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <link href="resources/css/login.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css">
    <link
        href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap"
        rel="stylesheet">
</head>
<body>
    <!-- 타이틀 -->
    <div class="bg_yellow">
        <span class="welcome">Welcome<br>Back!</span>
    </div>

    <!-- 본문(로그인) -->
    <div class="bg_white">
        <div class="login_content">

            <div class="login_title">Login</div>

            <!-- 폼(양식) -->
            <form action="">
                <label for="user_email">User Email</label>
                <div class="email">
                    <span class="email-box">
                        <input type="text" id="user_email" placeholder="이메일을 입력해주세요.">
                    </span>
                </div>

                <label for="user_pw">User Password</label>
                <div class="password">
                    <span class="pw-box">
                        <input type="password" id="user_pw" placeholder="비밀번호를 입력해주세요.">
                    </span>
                </div>
                
                <div class="pw_lost">
                    <a href="#">
                        비밀번호를 잊으셨나요?
                    </a>
                </div>
                
                <button class="btn">Login</button>
            </form>

            <div>새로 오셨나요?
                <span><a href="#">회원가입하기</a></span>
            </div>

            <!-- 구분선 -->
            <div class="line"></div>
            
            <a href="/miraclebird/instaLogin">
            <button class="btn-gray">
                <img src="resources/img/instagram.svg" alt="인스타그램 로고">
                <span>인스타그램으로 시작하기</span>
            </button>
            </a>
        </div>
    </div>
</body>
</html>