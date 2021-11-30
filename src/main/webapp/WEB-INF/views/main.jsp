<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"  isELIgnored="false" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--  contextPath를  변수명이 contextPath에 담는 jstl의 core부분 --%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%-- 컨트롤러에서 mv.addObject("goodsMap", goodsMap);로 모델을 넘겨 받음 --%>
<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/main.js"></script> 
<link rel="stylesheet" media="all" type="text/css" href="${contextPath}/resources/css/main.css" />
<script type="text/javascript" src="${contextPath}/resources/js/main.js"></script> 
<head>
<meta charset="UTF-8">
</head>
<body>


<div class="content">
		<img id="main_logo" src="${contextPath}/resources/css/img/vpae-logo.png">
		<c:forEach  var="productList"  items="${productList}" varStatus="status">
			<c:set var="product_count" value="${status.count}"/>
			<span class="product">
				<span>
					<a href="${contextPath}/productDetail.do?product_no=${productList.product_no}" id="link">
						<img class="productImg" src="${contextPath}/thumbnails.do?product_no=${productList.product_no}&product_image_fileName=${productList.product_image_fileName}">
					</a>
					<div id="productTitle">
						<a href="${contextPath}/productDetail.do?product_no=${productList.product_no}" id="link">
							<span id="product_kind">[${productList.product_kind}]</span><br/>
							<span id="product_name">${productList.product_name}</span>
						</a><br>
							<span class="product_price"><fmt:formatNumber value="${productList.product_price}" pattern="#,###"/>원</span>
					</div>
				</span>
			</span>
				
		<c:if test="${product_count==14}">
			<span class="product_plus">
				<span>
					<a href="${contextPath}/product.do" id="link">
						<img class="product_plus_img" src="${contextPath}/resources/css/img/icon_more.png">
					</a>
					<%-- <div id="productTitle">
						<a href="${contextPath}/productDetail.do?product_no=${productList.product_no}" id="link">
							<a href="">더보기</a>
							<span id="product_name">${productList.product_name}</span>
						</a><br>
							<span class="product_price"><fmt:formatNumber value="${productList.product_price}" pattern="#,###"/>원</span>
					</div> --%>
				</span>
			</span>
		</c:if>

				
		</c:forEach>
</div>	
</body>
</html>
