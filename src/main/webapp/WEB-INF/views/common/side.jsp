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
	 			<c:if test="${MDTO==null}">
		 			<li id="real-sub-menu7">
		 				<form name="logForm" id="logForm" class="logForm" method="post" action="${contextPath}/member/loginPath.do">
								<div id="id" class="box">
<!-- 									<span>ID</span> -->
										<input type="text" id="members_id" name="members_id" placeholder="ID"> 
								</div>
								<div id="pw" class="box">
<!-- 									<span>PW</span> -->
										<input type="password" id="members_pw" name="members_pw" placeholder="PW">
								</div>
									<button type="submit" class="login" id="logForm" name="logForm"  >LOGIN</button>
									<button type="button" id="membership" onclick="location.href='${contextPath}/joinmembership.do'" >JOIN</button>
							</form>
						</li>
					</c:if>
					
					<c:if test="${MDTO != null}">
						<li>
							<div class="loginmember">
								<span class="membersNickName">${MDTO.members_nickname}님</span><br>
								<span class="membersPoint">${MDTO.members_point} 포인트</span>
								<span class="myPage" onClick="location.href='${contextPath}/myPage.do?members_no=${MDTO.members_no}'">My Page</span>
								<span class="membersList">주문내역</span>
								<span class="logout" onclick="location.href='${contextPath}/logout.do'">로그아웃</span>
							</div>
						</li>
					</c:if>
					
					<li><a href="${contextPath}/product.do" id="real-sub-menu1">Store</a></li>
					<li><a href="${contextPath}/notice.do" id="real-sub-menu2">Notice</a></li>
					<li><a href="#" id="real-sub-menu3">Review</a></li>
					<li><a href="#" id="real-sub-menu4">Free</a></li>
					<li><a href="#" id="real-sub-menu5">CS</a></li>
				</ul>
			</li>
		</ul>
</div>
</html>