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
<link rel="stylesheet" media="all" type="text/css" href="${contextPath}/resources/css/board/noticeDetail.css" />
</head>
<body>
	<!-- 메인컨텐츠 영역 -->
	<div class="content">
		<table>
			<tr>
				<td class="notice_title">
					<span id="notice_title">${detail.notice_title}</span>
					<span id="notice_date"><fmt:formatDate value="${detail.notice_date}" pattern="YYYY.MM.dd HH:mm"/></span>
					<span id="members_nickname">${detail.members_nickname}</span>
					<span id="notice_count">${detail.notice_count}</span>
				</td>
			</tr>
			<tr>
				<td class="notice_content">
					<span id="notice_content">${detail.notice_content}</span>
				</td>
			</tr>
			<tr>
				<td>
					<button onclick="location.href='${contextPath}/notice.do'">목록</button>
					<c:if test="${memberDTO.members_id==detail.members_id}">
					<button>수정</button>
					<button>삭제</button>
					</c:if>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>