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
	<form>
		<table>
			<tr>
				<td style="border: 1px solid black;">
					상품 이미지
				</td>
				<td style="border: 1px solid black;">
					상품 정보
				</td>
				<td style="border: 1px solid black;">
					판매가
				</td>
				<td style="border: 1px solid black;">
					적립금
				</td>
				<td style="border: 1px solid black;">
					배송 구분
				</td>
				<td style="border: 1px solid black;">
					합계
				</td>
			</tr>
			<tr>
				<td style="border: 1px solid black;">
					<img class="top_main_image" src="${contextPath}/thumbnails.do?product_no=${productInfo.productDTOImageMain.product_no}&product_image_fileName=${productInfo.productDTOImageMain.product_image_fileName}">
				</td>
				<td style="border: 1px solid black;">
					[${productInfo.productDTO.product_kind}]${productInfo.productDTO.product_name}
				</td>
				<td style="border: 1px solid black;">
					<c:set var="price" value="${productInfo.productDTO.product_price}"/>
					<fmt:formatNumber value="${price}" pattern="#,###"/>원
				</td>
				<td style="border: 1px solid black;">
					<c:set var="point" value="${productInfo.productDTO.product_price}" />
					<fmt:formatNumber value="${point * 0.01}" pattern="0" />원
					
				</td>
				<td style="border: 1px solid black;">
					<c:set var="st" value="3000" />
					<fmt:formatNumber value="${st}" pattern="#,###" />원
				</td>
				<td style="border: 1px solid black;">
					<fmt:formatNumber value="${price}" pattern="#,###"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="6" style="border: 1px solid black;">
					상품구매금액 <fmt:formatNumber value="${price}" pattern="#,###"/> + 배송비 <fmt:formatNumber value="${st}" pattern="#,###" /> = <fmt:formatNumber value="${price+st}" pattern="#,###"/>원
				</td>
			</tr>
		</table>
		
		<table>
			<tr>
				<td>
					배송지 선택 
				</td>
				<td>
					<input type="radio">기존
					<input type="radio">새로운
				</td>
			</tr>
			<tr>
				<td>
					받는 분
				</td>
				<td>
					<input type="text">새로운
				</td>
			</tr>
			<tr>
				<td>
					주소
				</td>
				<td>
					<input type="text">새로운
				</td>
			</tr>
			<tr>
				<td>
					휴대전화
				</td>
				<td>
					<input type="text">tel
					<input type="text">tel
					<input type="text">tel
				</td>
			</tr>
			<tr>
				<td>
					이메일
				</td>
				<td>
					<input type="text">tel
					<input type="text">tel
					<input type="text">tel
				</td>
			</tr>
			<tr>
				<td>
					배송 메시지
				</td>
				<td>
					<input type="text">tel
				</td>
			</tr>
		</table>
	</form>
</body>
</html>