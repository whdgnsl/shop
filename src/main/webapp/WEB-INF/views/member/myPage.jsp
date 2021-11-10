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
<title>Insert title here</title>
<style type="text/css">
.tttt{
	background-color: red;
}
</style>
</head>
<body>

	<span class="tttt">
		아이디<input type="text" disabled="disabled" value="${myInfo.members_id}">
		이름<input type="text" disabled="disabled" value="${myInfo.members_full_name}">
		별명<input type="text" disabled="disabled" value="${myInfo.members_nickname}">
	</span>
	<div>
		본인 이메일<input type="text" disabled="disabled" value="${myInfo.members_email}">
	</div>
	<div>
		휴대전화<input type="text" disabled="disabled" value="${myInfo.members_tel}">
	</div>

</body>
</html>