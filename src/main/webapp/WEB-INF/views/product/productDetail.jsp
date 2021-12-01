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
<link rel="stylesheet" media="all" type="text/css" href="${contextPath}/resources/css/product/productDetail.css"/>
<script type="text/javascript" src="${contextPath}/resources/js/productDetail.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
		$(function(){
			$("#sub_images").on("click",function(){
				var width = document.getElementById('sub_images').naturalWidth;
				var height = document.getElementById('sub_images').naturalHeight;
				alert(width);
				alert(height);
				
			})
		})
	</script>
<body>
	<div class="content">
	<div class="top_box">
		<div class="img_content">
			<img class="top_main_image" src="${contextPath}/thumbnails.do?product_no=${map.productDTOImageMain.product_no}&product_image_fileName=${map.productDTOImageMain.product_image_fileName}">
		</div>
	
		<table class="topTable">
			<tr>
				<td id="product_name">
					<span>상품명  </span>
				</td>
				<td id="product_name">
					<span>[${map.productDTO.product_kind}]${map.productDTO.product_name}</span>
				</td>
				<tr>
				<td id="product_quick">
					<span>배송정보  </span>
				</td>
				<td id="product_quick">
					<span>국내배송</span>
				</td>
				</tr>
				<tr>
				<td id="product_quick_info">
					<span>배송방법</span>
				</td>
				<td id="product_quick_info">
					<span>로젠택배</span>
				</td>
				</tr>
				<tr>
				<td id="product_quick_price">
					<span>배송비  </span>
				</td>
				<td id="product_quick_price">
					<span>5,000원</span>
				</td>
				</tr>
				<tr>
					<td colspan="2" class="product_choi">
						수량 
						<a href="#" id="product_dow"><</a>
							<input type="text" id="product_st" value="1">
						<a href="#" id="product_dow">></a>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="product_price">
						<span id="price_name">총 상품 가격 : </span><fmt:formatNumber value="${map.productDTO.product_price}" pattern="#,###" />원
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="button" onclick="location.href='${contextPath}/order.do?product_no=${map.productDTO.product_no}'">주문하기</button>
						<button type="button">장바구니</button>
					</td>
				</tr>
		</table>
	</div>
		<table class="btm_table">
			<tr>
				<td style="margin: 0 auto">
					<c:forEach items="${map.productDTOImage}" var="img">
							<img src="${contextPath}/thumbnails.do?product_no=${img.product_no}&product_image_fileName=${img.product_image_fileName}" id="sub_images" onclick="window()">
					</c:forEach>
				</td>
			</tr>
		</table>
		
	</div>
	
</body>
</html>