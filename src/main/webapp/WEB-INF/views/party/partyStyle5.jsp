<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <link href="resources/css/partyStyle5.css" rel="stylesheet" type="text/css">
    <link
        href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap”
        rel=“stylesheet”>
    <link rel=“stylesheet”
    href=“https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css”>
    <title>Party Style</title>
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
    <div >
        <div class="cate">
            <button class="btn" id="area1">Main</button>
            <button class="btn">Feed</button>
            <button class="btn">Community</button>
            <button class="btn" id="here" onload="backChange()" style="background-color:#ffb100">Style</button>
            <button class="btn">People</button>
            <button class="btn">Applicants</button>
        </div>
    <div class="mainInfo">
        <div class="main">
            <div class="mainContent">
                <div class="content">
                    <div class="container">
                        <div class="image-upload" id="image-upload">
                
                            <form method="post" enctype="multipart/form-data">
                                <div class="button">
                                    <label for="chooseFile" style="font-weight: bold; font-size: 20px;">
                                        Party Image Change
                                    </label>
                                </div>
                                <input type="file" id="chooseFile" name="chooseFile" accept="image/*" onchange="loadFile(this)">
                            </form>
                
                            <div class="fileContainer">
                                <div class="fileInput">
                                    <p>FILE NAME: </p>
                                    <p id="fileName"></p>
                                </div>
                                <div class="buttonContainer">
                                    <div class="submitButton" id="submitButton">SUBMIT</div>
                                </div>
                            </div>
                        </div>
                        <div class="image-show" id="image-show"></div>
                        <br>
                        <br>
                        <form>
                            <div class="IntroParty">
                                <label style="font-size: 20px; font-weight: bold;">Party Intro Change </label><br>
                                <input type="text" style="border-radius: 30px; border: 2px solid #FFb100; width: 500px; height: 40px; margin-top: 30px; padding: 10px; margin-right: 10px;">
                                <button style="border-radius: 30px; border: none; background-color: #FFb100; height: 42px; width: 100px; color: white; font-weight: bold; font-size: 15px;">SUBMIT</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="mainText" onload="backChange()" id="bg">
                <a><marquee>환영합니다. 지옥에서 돌아온 닭 파티룸입니다.</marquee> </a>
            </div>
        </div>
    </div>
    </div>

    <script lang="javascript">
        function loadFile(input) {
    var file = input.files[0];	//선택된 파일 가져오기

    //미리 만들어 놓은 div에 text(파일 이름) 추가
    var name = document.getElementById('fileName');
    name.textContent = file.name;

  	//새로운 이미지 div 추가
    var newImage = document.createElement("img");
    newImage.setAttribute("class", 'img');

    //이미지 source 가져오기
    newImage.src = URL.createObjectURL(file);   

    newImage.style.width = "70%";
    newImage.style.height = "70%";
    newImage.style.visibility = "hidden";   //버튼을 누르기 전까지는 이미지를 숨긴다
    newImage.style.objectFit = "contain";

    //이미지를 image-show div에 추가
    var container = document.getElementById('image-show');
    container.appendChild(newImage);
};

var submit = document.getElementById('submitButton');
submit.onclick = showImage;     //Submit 버튼 클릭시 이미지 보여주기

function showImage() {
    var newImage = document.getElementById('image-show').lastElementChild;
  
    //이미지는 화면에 나타나고
    newImage.style.visibility = "visible";
  
    //이미지 업로드 버튼은 숨겨진다
    document.getElementById('image-upload').style.visibility = 'hidden';

    document.getElementById('fileName').textContent = null;     //기존 파일 이름 지우기
}

    </script>

    <script lang="javascript">
        function colorChange(){
            var area = document.getElementById("area");
            var area1 = document.getElementById("area1");
            var color = document.getElementById("color");
            area.style.backgroundColor = color.value;
            area1.style.backgroundColor = color.value;
        };
    </script>
    
    <script lang="javascript">

        function backChange(){
            // 데이터에 있는 색상 코드 입력
            var Acolor = new Array('red', 'orange', 'green'); 
            var Bcolor = Math.floor(Math.random() * Acolor.length);
            var Ccolor = Acolor[Bcolor]; 
            document.getElementById('bg').style.background=Ccolor;
            document.getElementById('here').style.background=Ccolor;
            }  
            setInterval(backChange,2000);

    </script>
</body>
</html>