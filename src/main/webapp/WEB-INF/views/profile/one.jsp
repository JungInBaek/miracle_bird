<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
유저네임(인스타아이디) : <br>
미라클 포인트 : ${vo.miraclePoint }<br>
미라클 타임 : ${vo.miracleStartTime } ~ ${vo.miracleEndTime }<br>
자기소개 : ${vo.bio }<br>
프로필 이미지 <br>
<img src="resources/profile/${vo.profileImg}">