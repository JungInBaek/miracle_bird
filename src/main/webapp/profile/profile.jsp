<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내 프로필</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/profile.css">
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
                    <li class="nav-item"><a href="#">JOIN</a></li>
                    <li class="nav-item"><a href="#">MY PARTY</a></li>
                    <li class="nav-item"><a href="#">PROFILE</a></li>
                    <li class="nav-item"><a href="#">STORE</a></li>
                    <li class="nav-item"><button>LOGIN</button></li>
                </ul>
            </nav>
        </div>
    </header>

    <!-- 바디 -->
    <div class="info">
        <form action="">
            <!-- 좌측 정보 -->
            <div class="info-left">
                <div class="image-resizing">
                    <img src="../resources/img/profile.png" alt="프로필 사진" class="image-box">
                </div>
                <input type="file" name="file" id="file" accept="image/*">
                <label for="file">
                    <div class="btn-upload">사진 업로드</div>
                </label>
                <div class="intro-text">
                    <textarea name="" id="" rows="10"></textarea>
                </div>
                <div class="time-title">활동 시간대</div>
                <div class="time">
                    <span><input type="time" id="from"></span>
                    <span>~</span>
                    <span><input type="time" id="to"></span>
                </div>
            </div>

            <!-- 우측 정보 -->
            <div class="info-right">
                <div class="top">
                    <div>개인정보 수정</div>
                    <table>
                        <tr>
                            <th>Name</th>
                            <td>홍길동</td>
                        </tr>
                        <tr>
                            <th>Email</th>
                            <td>example@example.com</td>
                        </tr>
                        <tr>
                            <th>User Name</th>
                            <td><span><input type="text"></span></td>
                        </tr>
                        <tr>
                            <th>Password</th>
                            <td><span><input type="password"></span></td>
                        </tr>
                    </table>
                </div>

                <div class="bottom">
                    <button class="btn">Edit Profile</button>
                    <button class="btn">구매 내역</button>
                </div>
            </div>
        </form>
    </div>


    <script>

        const fileDOM = document.querySelector('#file');
        const preview = document.querySelector('.image-box');

        fileDOM.addEventListener('change', () => {
            const reader = new FileReader();
            reader.onload = ({ target }) => {
                preview.src = target.result; // src 값 변경
            };
            reader.readAsDataURL(fileDOM.files[0]); // readAsDataURL 메소드의 인자인 file 객체를 base64 형태로 변환
        });

    </script>
</body>

</html>