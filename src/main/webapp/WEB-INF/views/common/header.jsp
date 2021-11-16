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
	<link rel="stylesheet" media="all" type="text/css" href="${contextPath}/resources/css/module/header.css" />
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<div class="frame">
	<c:if test="${MDTO==null}">
		<ul id="main-menu">
			<li>
				<a id="logoImg-a" href="${contextPath}/">
					<img id="logoImg" src="${contextPath}/resources/css/img/vpae-logo.png">
				</a>
			</li>
		</ul>
	</c:if>
	<c:if test="${MDTO!=null}">
		<ul id="main-menu">
			<li>
				<a id="logoImg-a" href="${contextPath}/main.do">
					<img id="logoImg" src="${contextPath}/resources/css/img/vpae-logo.png">
				</a>
			</li>
		</ul>
	</c:if>
	
</div>
</html>