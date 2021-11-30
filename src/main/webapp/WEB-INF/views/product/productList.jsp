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

<!-- 메인컨텐츠 영역 -->
<div class="content">
		
		<div class="button">
			<c:if test="${memberDTO.members_kind=='운영자'}">
				<button onclick="location.href='${contextPath}/productWrite.do'">새 글 작성</button>
			</c:if>
		</div>

		<c:forEach  var="productList"  items="${productList}">
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
		</c:forEach>
		
</div>	
	
</body>
</html>