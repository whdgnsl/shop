<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title></title>
	<link rel="stylesheet" media="all" type="text/css" href="${contextPath}/resources/css/module/side.css" />
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/side.js"></script> 
</head>
<div class="sideBar">
	<ul class="sub-menu">
		<li class="menu">
			<a href="javascript:void()" class="menu-trigger">Menu</a>
	 			<ul class="hide">
					
					<c:if test="${MDTO != null && MDTO.members_kind!='운영자'}">
						<li>
							<div class="loginmember">
								<span class="membersNickName">${MDTO.members_nickname}님</span><br>
								<span class="membersPoint">${MDTO.members_point} 포인트</span>
								<span class="myPage" onClick="location.href='${contextPath}/myPage.do?members_no=${MDTO.members_no}'">My Page</span>
								<span class="orderList">주문내역</span>
								<span class="logout" onclick="location.href='${contextPath}/logout.do'">로그아웃</span>
							</div>
						</li>
					</c:if>
					
					<c:if test="${MDTO.members_kind=='운영자'}">
						<li>
							<div class="loginmember">
								<span class="membersNickName">${MDTO.members_full_name}님</span>
								<span class="membersPoint">ADMIN</span></br>
<%-- 								<span class="memberMG" onClick="location.href='${contextPath}/membersMG.do'">회원 관리</span> --%>
								<button id="button" class="memberMG" onClick="location.href='${contextPath}/membersMG.do'">회원 관리</button>
<%-- 								<span class="orderMG" onClick="location.href='${contextPath}/membersMG.do'">주문 관리</span> --%>
								<button id="button" class="orderMG" onClick="location.href='${contextPath}/membersMG.do'">주문 관리</button>
<%-- 								<span class="logout" onclick="location.href='${contextPath}/logout.do'">로그아웃</span> --%>
								<button id="button" class="logout" onclick="location.href='${contextPath}/logout.do'">로그아웃</button>
							</div>
						</li>
					</c:if>
					
					<li>
						<button id="sub-menu-button" onClick="location.href='${contextPath}/product.do'">Store</button>
					</li>
					<li>
<%-- 						<a href="${contextPath}/notice.do" id="real-sub-menu2">Notice</a> --%>
						<button id="sub-menu-button" onClick="location.href='${contextPath}/notice.do'">Notice</button>
					</li>
					<li>
						<button id="sub-menu-button" onClick="location.href='${contextPath}/notice.do'">Review</button>
					</li>
					<li>
						<button id="sub-menu-button" onClick="location.href='${contextPath}/notice.do'">Free</button>
					</li>
					<li>
						<button id="sub-menu-button" onClick="location.href='${contextPath}/notice.do'">CS</button>
					</li>
					
				</ul>
			</li>
		</ul>
</div>
</html>