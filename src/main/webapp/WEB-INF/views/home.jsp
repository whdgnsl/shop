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
<style>
*{
	background-color: #C7C2C2;
}
</style>
</head>
<body>
</body>
</html>
