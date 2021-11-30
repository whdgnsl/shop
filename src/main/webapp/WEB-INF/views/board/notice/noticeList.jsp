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
<link rel="stylesheet" media="all" type="text/css" href="${contextPath}/resources/css/board/noticeList.css"/>
<script type="text/javascript">
function button(no){
	var members_no = no;
	window.open("<c:url value='/memberChange.do?members_no="+members_no+"'/>","회원 정보 변경","width=500px, height=700px");
}
</script>
</head>
<body>
<div class="content">
	<c:if test="${memberDTO.members_kind=='운영자'}">
		<button onclick="location.href='${contextPath}/noticeWriter.do'">새 글 작성</button>
	</c:if>
	<table class="noticeTable">
		<tr>
			<td id="notice_no">
				<p>글 번호</p>
			</td>
			<td id="notice_title">
				<p>제목</p>
			</td>
			<td id="members_nickname">
				<p>작성자</p>
			</td>
			<td id="notice_date">
				<p>작성일</p>
			</td>
			<td id="notice_count">
				<p>조회수</p>
			</td>
		</tr>
		
		<c:forEach items="${boardListDTO.content}" var="notice" varStatus="status">
			<tr>
				<td id="notice_no_bt">
					<p>${notice.notice_no}</p>
				</td>
				<td id="notice_title_bt">
					<p><a href="${contextPath}/noticeDetail.do?notice_no=${notice.notice_no}" name="notice_title">${notice.notice_title}</a></p>
				</td>
				<td id="members_nickname_bt">
					<p>${notice.members_nickname}</p>
				</td>
				<td id="notice_date_bt">
					<p><fmt:formatDate value="${notice.notice_date}" pattern="yyyy.MM.dd HH:mm"/></p>
				</td>
				<td id="notice_count_bt">
					<p>${notice.notice_count}</p>
				</td>
			</tr>
		</c:forEach>
		
		<tr>
			<td id="paging" colspan="5">
				<c:if test="${boardListDTO.startPage>5}">
					<a href="${contextPath}/notice.do?pageNo=${boardListDTO.startPage-5}">&lt;&lt;prev</a>
				</c:if>
			
				<c:forEach begin="${boardListDTO.startPage}" end="${boardListDTO.endPage}" step="1" var="pNo">
					<a href="${contextPath}/notice.do?pageNo=${pNo}">[${pNo}]</a>
				</c:forEach>
			
				<c:if test="${boardListDTO.endPage<boardListDTO.totalPages}">
					<a href="${contextPath}/notice.do?pageNo=${boardListDTO.startPage+5}">next&gt;&gt;</a>
				</c:if>
			</td>
		</tr>
	</table>
	
</div>
</body>
</html>