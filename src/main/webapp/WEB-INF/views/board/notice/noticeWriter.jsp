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
<title>Insert title here</title>
</head>
<body>
<div>
	<form action="${contextPath}/noticeDone.do" method="post">
	<input type="hidden" name="members_nickname" value="${MDTO.members_nickname}">
	<input type="hidden" name="members_id" value="${MDTO.members_id}">
	<!--제목입력란 -->
	<span>
		<input type="text" placeholder="제목" name="notice_title">
	</span>
	<p>
	<!--내용 입력란 -->
	<span>
		<textarea rows="50" cols="50" placeholder="내용을 입력하세요" name="notice_content" id="notice_content"></textarea>
	</span>
	
	<button type="submit">글 등록</button>
	</form>
</div>
</body>
</html>