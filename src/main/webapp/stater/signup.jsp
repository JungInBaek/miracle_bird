<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/signup.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css">
    <link
        href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap"
        rel="stylesheet">
</head>
<body>
    <!-- 타이틀 -->
    <div class="bg_yellow">
        <span class="welcome">Create an<br>account</span>
    </div>

    <!-- 본문(회원가입) -->
    <div class="bg_white">

        <!-- 본문 -->
        <div class="signup_content">

            <!-- 폼(양식) -->
            <form action="">
                <div class="email">
                    <span class="email-box">
                        <input type="text" id="user_email" placeholder="Email">
                    </span>
                </div>

                <div class="password">
                    <span class="pw-box">
                        <input type="text" id="user_pw" placeholder="Password">
                    </span>
                </div>

                <div class="name">
                    <span class="name-box">
                        <input type="text" id="name" placeholder="Name">
                    </span>
                </div>

                <div class="user-name">
                    <span class="user-name-box">
                        <input type="text" id="user_name" placeholder="User Name">
                    </span>
                </div>
                
                <!-- 회원가입 버튼 -->
                <button class="btn">Sign up</button>
            </form>
            
        </div>

    </div>
</body>
</html>