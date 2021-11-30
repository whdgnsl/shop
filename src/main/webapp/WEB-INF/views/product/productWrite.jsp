<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%--  contextPath를  변수명이 contextPath에 담는 jstl의 core부분 --%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" media="all" type="text/css" href="${contextPath}/resources/css/product/productWriter.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div class="content">

   <form action="${contextPath}/productWriteSuccess.do" method="post" enctype="multipart/form-data">
   
	   	<select name="product_kind" id="product_kind" class="product_kind">
	   		<option selected="selected" value="종류">종류</option>
	   		<option value="입호흡액상">입호흡</option>
	   		<option value="폐호흡액상">폐호흡</option>
	   		<option value="기기">기기</option>
	   		<option value="기타">기타</option>
	   	</select>
   	
   		<input type="text" name="product_name" id="product_name"  style="margin-bottom:20px" required placeholder="상품명"><br/>
     	<input type="text" name="product_stock" id="product_stock"  style="margin-bottom:20px" required placeholder="수량">
     	<input type="text" name="product_price" id="product_price"  style="margin-bottom:20px" required placeholder="가격"><br/>
     	<textarea id="product_mainInfo" name="product_mainInfo" style="width:700px;height:600px; margin-bottom:20px" required placeholder="상품 설명"></textarea>
      
       <div class="inputArea">
           <div style="padding-right:170px">메인 이미지</div>
          <input type="file" id="productImg" name="MainFile" style="margin-bottom:20px"/>
          <div class="select_img"><img  src="" /></div>
       </div>
       
       <div class="inputSubArea">
           <div style="padding-right:160px">상세 이미지</div>
          <input type="file" id="productSubImg" name="SubFile" multiple/>
          <div id="select_SubImg" style="padding-left:10px; padding-right:10px;"></div>
      </div>
      
      <!-- <div class="inputSubArea">
         <label for="productSubImg">영화 서브 이미지</label>
         <input type="file" id="productSubImg" name="SubFile" accept="image/*" onchange="setThumbnail(event);" multiple/> 
         <div id="select_SubImg" style="padding-left:10px"></div>
      </div>    -->
      
      <div class="sq">
      	<button type="submit" id="write" value="등록">등록</button>
      	<button type="button" id="write" onclick="location.href='${contextPath}/product.do'" value="취소">취소</button>
      </div>
         
      
      
    </form>   
    
</div>         
</body>
</html>