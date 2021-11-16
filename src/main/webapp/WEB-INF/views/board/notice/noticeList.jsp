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
<link rel="stylesheet" media="all" type="text/css" href="${contextPath}/resources/css/board/noticeList.css" />
</head>
<body>


<!-- 메인컨텐츠 영역 -->
<div class="content">
	<div class="noticeTitle">Notice</div>
	<div id="main">
		<span id="notice_no">No</span>
		<span id="notice_title">Title</span>
		<span id="notice_count">Count</span>
	</div>
	
	<c:forEach items="${notice}" var="notice" varStatus="status">
		<div id="main">
			<span id="notice_no_re">${status.count}</span>
			<span id="notice_title_re">${notice.notice_title}</span>
			<span id="notice_count_re">${notice.notice_count}</span>
		</div>
	</c:forEach>
</div>
</body>
</html>