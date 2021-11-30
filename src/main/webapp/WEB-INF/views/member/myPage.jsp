<%@ page language="java" 		  contentType="text/html; charset=utf-8"
				  pageEncoding="utf-8"  isELIgnored="false" %>
<%--  tiles를 사용하기위한 taglib 지시어--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%--   jstl를 사용하기위한 taglib 지시어--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--  contextPath를  변수명이 contextPath에 담는 jstl의 core부분 --%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" media="all" type="text/css" href="${contextPath}/resources/css/member/myPage.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>
	<div class="content">
		<span id="select-member">
		
			<span id="top-name" class="top-name">개인 정보</span>
			<br>
			
			<span id="top-kind" class="members_id">아이디</span>
			<span>
				<input type="text" disabled="disabled" value="${myInfo.members_id}"><br>
			</span><br>
			
			<span id="top-kind" class="members_full_name">이름</span>
			<span>
				<input type="text" disabled="disabled" value="${myInfo.members_full_name}"><br>
			</span><br>
			
			<span id="top-kind" class="members_nickname">별명</span>
			<span>
				<input type="text" disabled="disabled" value="${myInfo.members_nickname}"><br>
			</span><br>
			
			<span id="top-kind" class="members_email">본인 이메일</span>
			<span>
				<input type="text" disabled="disabled" value="${myInfo.members_email}"><br>
			</span><br>
			
			<span id="top-kind" class="members_tel">휴대전화</span>
			<span>
				<input type="text" disabled="disabled" value="${myInfo.members_tel}"><br>
			</span><br>
		</span>
		
		<span id="select-addr">
		
			<span id="bt-name" class="bt-name">배송지</span>
			<br>
			
			<span id="addr">
				<input type="text" disabled="disabled" value="${myInfo.members_addr}"><br>
			</span><br>
			
			<span>
				<button>수정</button>
			</span>
		</span>
		
	</div>
</body>
</html>