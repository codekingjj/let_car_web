<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/style/homeHeader.css">
</head>
<body>
	<div class="container">
		<div class="logo">
			<h5>메가 No1</h5>
			<h2>메가 렌트카</h2>
		</div>
		<div class="navi">
			<a href="/carInfo">렌터카 종류</a>
			<a href="/carInfo">렌터카 예약</a>
			<a href="/board">공지사항</a>
			<a href="/board">게시판</a>
			<a href="/mypage">마이페이지</a>
		<a href="/join">회원가입</a>
		
		<c:choose>
			<c:when test="${empty user }">
				<button onclick="location.href='/login'">로그인</button>
			</c:when>
			<c:otherwise>
				<button onclick="location.href='/logout'">로그아웃</button>
			</c:otherwise>
		</c:choose>
		</div>
	</div>
</body>
</html>