<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="resources/css/create.css" rel="stylesheet" type="text/css">
    <link
        href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap”
        rel=“stylesheet”>
    <link rel=“stylesheet”
    href=“https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css”>
    <title>파티 생성</title>
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
                    <li class="nav-item"><button>LOGIN</button></a></li>
                </ul>
            </nav>
        </div>
    </header>
    <div class="box">
        <div class="partyInfo">
            <!-- form action 넣기 -->
            <form action="/miraclebird/party/create" method="post">
                <table class="party">
                    <tbody>
                        <tr>
                            <td><img src="resources/img/activity.png" class="img" /></td>
                            <td><a>Party</a></td>
                            <td><input class="inputBox" name="name" placeholder="파티 명을 입력해주세요."></td>
                        </tr>
                        <div class="dropdownP">
                            <tr>
                                <td><img src="resources/img/time.png" class = "img" /></td>
                                <td><a>TIME</a></td>
                                <td>
                                    <input type="time" name="miracleStartTime" min="04:00:00" max="12:00:00" class="inputTime" />
                                    <a>-</a>
                                    <input type="time" name="miracleEndTime" min="04:00:00" max="12:00:00" class="inputTime" />
                                </td>
                            </tr>
                        </div>
                            <tr>
                            <td><img src="resources/img/activity.png" class="img" /></td>
                            <td><a>ACTIVITY</a></td>
                            <td><input class="inputBox" placeholder="파티 활동을 입력해주세요." name="activity"></td>
                        </tr>
                        <tr>
                            <td><img src="resources/img/profile-2user.png" class="img" /></td>
                            <td><a>PEOPLE</a></td>
                            <td><input class="inputBox" placeholder="파티 인원을 입력해주세요."></td>
                        </tr>
                        <tr>
                            <td><img src="resources/img/medal.png" class="img" name="info" /></td>
                            <td><a>WELCOME</a></td>
                            <td><textarea class="partyT" placeholder="파티를 간단하게 소개해주세요."></textarea></td>
                        </tr>
                    </tbody>
                </table>
        </div>
        <div class="partyBtn">
            <button class="create">CREATE</button>
            <button class="cancle"><a href="/miraclebird/recruit/list">CANCLE</a></button>
        </div>
    </form>
</div>
<hr>
<form action="/miraclebird/party/create" method="post">
파티명 : <input type="text" name="name" /> <br/>
한줄소개 : <input type="text" name="info" /> <br/>
미라클활동 시간 : <input type="time" name="miracleStartTime" min="04:00:00" max="12:00:00" /> ~ <input type="time" name="miracleEndTime" min="04:00:00" max="12:00:00" /> <br />
미라클 활동 : <input type="text" name="activity" /> <br />
<button>생성</button>
</form>
<a href="/miraclebird/recruit/list">취소</a>

</body>
</html>