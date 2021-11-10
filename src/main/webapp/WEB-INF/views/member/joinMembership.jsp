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
<meta charset="UTF-8">
</head>
<body>
	<div class="content">
		<form method="post" id="joinmember" name="joinmember" action="${contextPath}/joinsuccess.do">
			<div>
				이름<input type="text" name="members_full_name">
			</div>
			<div>
				아이디<input type="text" name="members_id">
			</div>
			<div>
				비밀번호<input type="password" name="members_pw">
			</div>
			<div>
				닉네임<input type="text" name="members_nickname">
			</div>
			<div>
				이메일<input type="text" name="members_email">
			</div>
			<div>
				전화번호<input type="tel" name="members_tel"> - <input type="tel" name="members_tel2"> - <input type="tel" name="members_tel3">
			</div>
			<div>
				주소<input type="text" name="members_addr">
			</div>
			<div>
				<button type="submit">회원가입</button>
				<button type="button" id="joincancel" onclick="location.href='${contextPath}/'" >취소</button>
			</div>
		</form>
	</div>
</body>
</html>