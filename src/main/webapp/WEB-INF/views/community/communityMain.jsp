<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/css/communityMain.css" />
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <link
        href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap”
        rel=“stylesheet”>
    <link rel=“stylesheet”
    href=“https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css”>
    <script src="https://unpkg.com/@yaireo/tagify"></script>
<script src="https://unpkg.com/@yaireo/tagify/dist/tagify.polyfills.min.js"></script>
<link href="https://unpkg.com/@yaireo/tagify/dist/tagify.css" rel="stylesheet" type="text/css" />
    <title>커뮤니티 메인</title>
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
        <div class="bestContent">
            <div class="bestTitle">
                <img src="resources/img/photo.png" width="30px" height="30px" style="margin-right: 20px;">
                <a style="font-size: 20px; font-weight: bolder;">
                    인기글
                </a>
            </div>
            <hr>
            <ol type="1">
                <li>1위 인기글</li>
                <li>2위 인기글</li>
                <li>3위 인기글</li>
                <li>4위 인기글</li>
                <li>5위 인기글</li>
            </ol>
        </div>
        <div class="notice">
            <div class="import">
                <img src="resources/img/sun.png">
                <a style="margin: 0px 50px 0px 20px; font-weight: bold;">공지</a>
                <a style="margin: 0px 50px 0px 40px;">공지 제목</a>
                <a>작성자</a>
            </div>
            <div class="import">
                <img src="resources/img/sun.png">
                <a style="margin: 0px 50px 0px 20px; font-weight: bold;">공지</a>
                <a style="margin: 0px 50px 0px 40px;">공지 제목</a>
                <a>작성자</a>
            </div>
        </div>
        <div class="totalContent">
            Total : <a>총 게시물 수</a>
        </div>
        <div class="content-text" onClick="location.href='communityMainDetail.html'">
            <div class="contentInfo"></a>
                <img src="resources/img/profile.png" class="img">
                <div class="userInfo">
                    <li>사용자 이름</li>
                    <li>작성 날짜</li>
                </div>
            </div>
            <div class="boardInfo">예전에 한 때 홈페이지에 항상 퀵메뉴가 있던 시절이 있었는데,

                없어지는 듯 하다가 요새 다시 보이는 듯 하다.
                
                
                아무래도 쇼핑몰이나 고객의 요구에 빨리 응해야하는 사이트에서는 퀵메뉴가 필수불가결한 요소인 것 같다.
                
                보통 오른쪽에 완전히 고정해두는 형태(position:absolute)로 넣을 수도 있지만 완전 고정해두면 좀 유연성이 없어보이고(?)
                
                너무 큰 사이즈로 넣는다면 사이트의 다른 구성요소보다 더 이목이 집중되는 느낌...
                요새는 아래처럼 작은메뉴를 만들어 스크롤 내릴때 마다 부드럽게 따라오는 형태로 많이 사용하는 것 같다.
                
                jquery를 활용하면 부드럽게 따라오는 메뉴를 만들 수 있다.</div>
            <div class="comment">
                <img src="resources/img/message-text.png">
                댓글 수
            </div>
        </div>

        <div class="content-text">
            <div class="contentInfo"></a>
                <img src="resources/img/profile.png" class="img">
                <div class="userInfo">
                    <li>사용자 이름</li>
                    <li>작성 날짜</li>
                </div>
            </div>
            <div class="boardInfo">예전에 한 때 홈페이지에 항상 퀵메뉴가 있던 시절이 있었는데,

                없어지는 듯 하다가 요새 다시 보이는 듯 하다.
                
                아무래도 쇼핑몰이나 고객의 요구에 빨리 응해야하는 사이트에서는 퀵메뉴가 필수불가결한 요소인 것 같다.
                
                보통 오른쪽에 완전히 고정해두는 형태(position:absolute)로 넣을 수도 있지만 완전 고정해두면 좀 유연성이 없어보이고(?)
                
                너무 큰 사이즈로 넣는다면 사이트의 다른 구성요소보다 더 이목이 집중되는 느낌...
                
                요새는 아래처럼 작은메뉴를 만들어 스크롤 내릴때 마다 부드럽게 따라오는 형태로 많이 사용하는 것 같다.
                
                jquery를 활용하면 부드럽게 따라오는 메뉴를 만들 수 있다.</div>
            <div class="comment">
                <img src="resources/img/message-text.png">
                댓글 수
            </div>
        </div>
    </div>
    <!-- 모달창 -->
    <div id="wrap">
        <section class="contentModal">
            <div class="containerModal">
                <div>
                <button class="createBtn"><img src="resources/img/add-circle.png"  onClick="javascript:popOpen();"></button>
                </div>
            </div>
        </section>   
        </div>
        <form action="" method="POST" >
            <div class="modal-bg" onClick="javascript:popClose();"></div>
            <div class="modal-wrap">
                modal sample
                <button class="modal-close" onClick="javascript:popClose();">&times;</button>
            </div>
<!-- //modal 영역 -->
            <div class="modal-bg" onClick="javascript:popClose();"></div>
            <div class="modal-wrap">
                <span>
                    <h4 style="text-align: center; padding: 10px; display: inline;">글쓰기</h4>
                    <button class="modal-close" onClick="javascript:popClose();">&times;</button>
                </span>
                <hr>
                <!-- 해시태그 입력 -->
                <img src="resources/img/hashtag.png" style="margin: 0px 20px 0px 30px;">
                <a style="font-size: 17px; font-weight: bold; color: darkgray;">태그 입력</a>
                <div class="contentTag">
                    <div style="display: flex;">
                        <input type="text" id="tag" size="10" placeholder="태그입력" />
                    </div>
                    <ul id="tag-list">
                    </ul>
                </div>
                <!-- 글 내용 입력 -->
                <textarea placeholder="새로운 내용을 남겨주세요!">
                </textarea>
                <!-- 이미지 입력 -->
                <div class="container">
                    <div class="image-upload" id="image-upload">
                
                        <form method="post" enctype="multipart/form-data">
                            <div class="buttonImg">
                                <label for="chooseFile">
                                    <img src="resources/img/gallery.png" width="30px" height="30px" style="margin: 10px;">
                                    <a style="font-size: 17px; font-weight: bold;">이미지 추가 </a>
                                </label>
                            </div>
                            <input type="file" id="chooseFile" name="chooseFile" accept="image/*" onchange="loadFile(this)">
                        </form>
                
                        <div class="fileContainer">
                            <div class="fileInput">
                                <p>FILE NAME: </p>
                                <p id="fileName"></p>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 입력 완료 시 버튼 -->
                <button type="submit" class="complete">작성하기</button>
            </div>
        </form>
        
    <script lang="javascript">
        function popOpen() {
            var modalPop = $('.modal-wrap');
            var modalBg = $('.modal-bg'); 
            
            $(modalPop).show();
            $(modalBg).show();
            document.body.style.overflow = "hidden";
        }
        
        function popClose() {
            var modalPop = $('.modal-wrap');
            var modalBg = $('.modal-bg');
            
            $(modalPop).hide();
            $(modalBg).hide();
            document.body.style.overflow = "unset";
        }

        const $topBtn = document.querySelector(".createBtn");

        $topBtn.onclick = () => {
            window.scrollTo({top:0, behavior: "smooth"});
        }

    </script>
    <script lang="javascript">
        
        $(document).ready(function () {
            var tag = {};
            var counter = 0;

            function addTag(value) {
                tag[counter] = value; 
                counter++; 
            }
            
            function marginTag() {
                return Object.values(tag).filter(function (word) {
                    return word !== "";
                });
            }
            $("#tag").on("keyup", function (e) {
                var self = $(this);
                console.log("keypress");
                
                if (e.key === "Enter" || e.keyCode == 32) {
                    var tagValue = self.val(); // 값 가져오기
                    if (tagValue !== "") {
                        var result = Object.values(tag).filter(function (word) {
                return word === tagValue;
            })

            if (result.length == 0) {
                $("#tag-list").append("<li class='tag-item'>" + tagValue + "<span class='del-btn' idx='" + counter + "'>x</span></li>");
                addTag(tagValue);
                self.val("");
            } else {
                alert("태그값이 중복됩니다.");
            }
        }
        e.preventDefault(); 
        }
    });
    $(document).on("click", ".del-btn", function (e) {
        var index = $(this).attr("idx");
        tag[index] = "";
        $(this).parent().remove();
    });
})
</script>



<script lang="javascript">
    function showImage() {
    var newImage = document.getElementById('image-show').lastElementChild;
    newImage.style.visibility = "visible";
    document.getElementById('image-upload').style.visibility = 'hidden';
    document.getElementById('fileName').textContent = null;     //기존 파일 이름 지우기
}

    function loadFile(input) {
    var file = input.files[0];

    var name = document.getElementById('fileName');
    name.textContent = file.name;

    var newImage = document.createElement("img");
    newImage.setAttribute("class", 'img');

    newImage.src = URL.createObjectURL(file);   

    newImage.style.width = "70%";
    newImage.style.height = "70%";
    newImage.style.visibility = "hidden";   //버튼을 누르기 전까지는 이미지 숨기기
    newImage.style.objectFit = "contain";

    var container = document.getElementById('image-show');
    container.appendChild(newImage);
};

</script>
<script lang="javascript">
    function divClick(){
        var modalPop1 = $('.modal-wrap1');
        var modalBg1 = $('.modal-bg1'); 
            
        $(modalPop1).show();
        $(modalBg1).show();
    }
</script>
</body>
</html>