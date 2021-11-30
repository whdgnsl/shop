<%@ page language="java" 		  contentType="text/html; charset=utf-8"
				  pageEncoding="utf-8"  isELIgnored="false" %>
<%--  tiles를 사용하기위한 taglib 지시어--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%--   jstl를 사용하기위한 taglib 지시어--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--  contextPath를  변수명이 contextPath에 담는 jstl의 core부분 --%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" media="all" type="text/css" href="${contextPath}/resources/css/admin/memberList.css"/>
<script type="text/javascript">
function button(no){
	var members_no = no;
	window.open("<c:url value='/memberChange.do?members_no="+members_no+"'/>","회원 정보 변경","width=500px, height=700px");
}
</script>
</head>
<body>
<div class="content">
	<table class="memberTable">
		<tr>
			<td id="members_no_top" style="background-color: #222;">
				<p style="background-color: #222;">번호</p>
			</td>
			<td id="members_full_name_top" style="background-color: #222;">
				<p style="background-color: #222;">이름</p>
			</td>
			<td id="member_id_top" style="background-color: #222;">
				<p style="background-color: #222;">아이디</p>
			</td>
			<td id="members_tel_top" style="background-color: #222;">
				<p style="background-color: #222;">전화번호</p>
			</td>
			<td id="members_point_top" style="background-color: #222;">
				<p style="background-color: #222;">보유 포인트</p>
			</td>
			<td id="members_email_top" style="background-color: #222;">
				<p style="background-color: #222;">이메일</p>
			</td>
			<td id="members_addr_top" style="background-color: #222;">
				<p style="background-color: #222;">주소</p>
			</td>
			<td id="members_date_top" style="background-color: #222;">
				<p style="background-color: #222;">가입날짜</p>
			</td>
			<td id="members_kind_top" style="background-color: #222;">
				<p style="background-color: #222;">등급</p>
			</td>
			<td id="null_top" style="background-color: #222;">
				<p style="background-color: #222;"></p>
			</td>
		</tr>
		
		<c:forEach items="${memberList}" var="member">
			<tr>
				<td id="members_no">
					<p>${member.members_no}</p>
				</td>
				<td id="members_full_name">
					<p>${member.members_full_name}</p>
				</td>
				<td id="member_id">
					<p>${member.members_id}</p>
				</td>
				<td id="members_tel">
					<p>${member.members_tel}</p>
				</td>
				<td id="members_point">
					<p>${member.members_point}</p>
				</td>
				<td id="members_email">
					<p>${member.members_email}</p>
				</td>
				<td id="members_addr">
					<p>${member.members_addr}</p>
				</td>
				<td id="members_date">
					<p><fmt:formatDate value="${member.members_date}" pattern="yyyy.MM.dd HH:mm"/></p>
				</td>
				<td id="members_kind">
					<p>${member.members_kind}</p>
				</td>
				<td id="null">
					<button>탈퇴</button>
					<button  onclick="button(${member.members_no});">변경</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>