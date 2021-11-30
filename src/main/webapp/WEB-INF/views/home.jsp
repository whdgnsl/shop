<%@ page language="java"         contentType="text/html; charset=utf-8"
              pageEncoding="utf-8"  isELIgnored="false" %>
<%--  tiles를 사용하기위한 taglib 지시어--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%--   jstl를 사용하기위한 taglib 지시어--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--  contextPath를  변수명이 contextPath에 담는 jstl의 core부분 --%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%-- 컨트롤러에서 mv.addObject("goodsMap", goodsMap);로 모델을 넘겨 받음 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" media="all" type="text/css" href="${contextPath}/resources/css/home.css" />
</head>
<body>

	<div class="content">
	
		<div class="main-form">
		<img id="logoImg" src="${contextPath}/resources/css/img/vpae-logo.png">
			<form name="logForm" id="logForm" class="logForm" method="post" action="${contextPath}/member/loginPath.do">
				<div id="id" class="box">
					<input type="text" id="members_id" name="members_id" placeholder="ID"> 
				</div>
				<div id="pw" class="box">
					<input type="password" id="members_pw" name="members_pw" placeholder="PW">
				</div>
			<div class="button">
				<button type="submit" class="login" id="logForm" name="logForm"  >LOGIN</button>
				<button type="button" class="membership" id="membership" onclick="location.href='${contextPath}/joinmembership.do'" >JOIN</button>
			</div>
			</form>
		</div>
	</div>
</body>
</html>
