<%@ page language="java" 		  contentType="text/html; charset=utf-8"
				  pageEncoding="utf-8"  isELIgnored="false" %>
<%--  tiles를 사용하기위한 taglib 지시어--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%--   jstl를 사용하기위한 taglib 지시어--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--  contextPath를  변수명이 contextPath에 담는 jstl의 core부분 --%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="${contextPath}/resources/js/adMember.js"></script> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${contextPath}/memberChangeDone.do" method="post">
		<table>
			<tr>
				<td>
					회원 번호
				</td>
				<td>
					<input type="box" id="members_no" name="members_no" disabled="disabled" value="${memberInfo.members_no}">
					<input type="hidden" id="members_no" name="members_no" value="${memberInfo.members_no}">
				</td>
			</tr>
			<tr>
				<td>
					회원 이름
				</td>
				<td>
					<input type="box" id="members_full_name" name="members_full_name" disabled="disabled" value="${memberInfo.members_full_name}">
					<input type="hidden" id="members_full_name" name="members_full_name" value="${memberInfo.members_full_name}">
				</td>
			</tr>
			<tr>
				<td>
					회원 아이디
				</td>
				<td>
					<input type="box" id="members_id" name="members_id" disabled="disabled" value="${memberInfo.members_id}">
					<input type="hidden" id="members_id" name="members_id" value="${memberInfo.members_id}">
				</td>
			</tr>
			<tr>
				<td>
					전화번호
				</td>
				<td>
					<input type="box" id="members_tel" name="members_tel" value="${memberInfo.members_tel}">
				</td>
			</tr>
			<tr>
				<td>
					보유 포인트
				</td>
				<td>
					<input type="box" id="members_point" name="members_point" value="${memberInfo.members_point}">
				</td>
			</tr>
			<tr>
				<td>
					이메일
				</td>
				<td>
					<input type="box" id="members_email" name="members_email" value="${memberInfo.members_email}">
				</td>
			</tr>
			<tr>
				<td>
					주소
				</td>
				<td>
					<input type="box" id="members_addr" name="members_addr" value="${memberInfo.members_addr}">
				</td>
			</tr>
			<tr>
				<td>
					등급
				</td>
				<td>
					<select id="members_kind" name="members_kind">
						<option selected="selected">${memberInfo.members_kind}</option>
						
						<c:if test="${memberInfo.members_kind=='운영자'}">
							<option value="일반">일반</option>
							<option value="정지">정지</option>
						</c:if>

						<c:if test="${memberInfo.members_kind=='일반'}">
							<option value="운영자">운영자</option>
							<option value="정지">정지</option>
						</c:if>
						
					</select>
				</td>
			</tr>
		</table>
			<button type="submit" onclick="succ();">변경</button>
	</form>
</body>
</html>