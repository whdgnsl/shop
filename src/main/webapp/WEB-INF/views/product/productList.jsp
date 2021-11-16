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
<link rel="stylesheet" media="all" type="text/css" href="${contextPath}/resources/css/product/productList.css" />
</head>
<body>



<div id="content">	
	<div id="main">
			<c:forEach  var="productList"  items="${productList}">
				<div id="product">
					<span>
						<a href="${contextPath}/productDetail.do?product_no=${productList.product_no}">
							<img class="productImg" src="${contextPath}/thumbnails.do?product_no=${productList.product_no}&product_image_fileName=${productList.product_image_fileName}">
						</a>
					
						<div id="product">
							<span>[${productList.product_kind}]</span> 
							<span>${productList.product_name}</span>
						</div>
					</span>
				</div>
			</c:forEach>
		<c:if test="${memberDTO.members_kind=='ad'}">
			<div id="WriteForm">
		   		<h2><a href="${contextPath}/productWrite.do">작성</a></h2> 
			</div>
		</c:if>
	</div>
</div>
</body>
</html>