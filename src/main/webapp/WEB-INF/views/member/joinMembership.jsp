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
<meta charset="UTF-8">
<link rel="stylesheet" media="all" type="text/css" href="${contextPath}/resources/css/member/joinMembership.css" />
<!-- 우편번호 찾기 API -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/joinMembership.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>

	<div class="content">
	
		<div class="main-form">
			
			<form name="logForm" id="logForm" class="logForm" method="post" action="${contextPath}/joinsuccess.do">
				<table>
					<tr>
						<td colspan="2" id="img_td">
							<a href="${contextPath}/"><img id="logoImg" src="${contextPath}/resources/css/img/vpae-logo.png"></a>
						</td>
					</tr>
					<tr>
						<td id="members_full_name_td">
							<label id="top_name_tool">＊ 이름</label>
							<input type="text" name="members_full_name" id="members_full_name">
						</td>
					</tr>
					
					<!-- 아이디 -->
					<tr>
						<td id="top_name_tool_td" class="members_id_td">
							<label id="top_name_tool">＊아이디</label>
							<input type="text" name="members_id" id="members_id" onchange="idChk();"><span id="id_Chk"></span>
						</td>
					</tr>
					<tr>
						<td colspan="2" style="color:#888; font-size:0.8rem; padding-left:20px;"  class="members_id_bt_td">
							<span>아이디는 4글자 이상 12글자 이하 영문과 숫자만 사용하여 입력해주세요.</span>
						</td>
					</tr>
					
					<!-- 비밀번호 -->
					<tr>
						<td id="top_name_tool_td">
							<label id="top_name_tool">＊비밀번호</label>
							<input type="password" name="members_pw" id="members_pw" onchange="pwChk()"><span id="chkAns_1"></span>
						</td>
					</tr>
					<tr>
						<td id="top_name_tool_td">
							<label id="top_name_tool">＊비밀번호 확인</label>
							<input type="password" name="members_pw_2" id="members_pw_2" onchange="pwChk()"><span id="chkAns_2"></span>
						</td>
					</tr>
					<tr>
						<td colspan="2" style="color:#888; font-size:0.8rem; padding-left:20px; border-bottom: 1px solid #333;">
							<span>비밀번호는 특수문자 및 영문, 숫자를 포함해야합니다. <br> 6글자 이상 16글자 이내로 이용 가능합니다. </span>
						</td>
					</tr>
					
					<!-- 닉네임 -->
					<tr>
						<td id="top_name_tool_td" class="members_nickname_td">
							<label id="top_name_tool">＊닉네임</label>
							<input type="text" name="members_nickname" id="members_nickname" onchange="nickChk()">
							<span id="nick_chk"></span>
						</td>
					</tr>
					<tr>
						<td colspan="2" style="color:#888; font-size:0.8rem; padding-left:20px;border-bottom: 1px solid #333;">
							<span>닉네임은 2글자 이상 8글자 이하 한글과 영문만 이용가능합니다.</span>
						</td>
					</tr>
					
					<tr>
						<td id="top_name_tool_td" style="border-bottom: 1px solid #333;">
							<label id="top_name_tool">＊이메일</label>
							<input type="text" name="members_email_1" id="members_email_1" onchange="emal_chk()">
							<select name="members_email_2" id="members_email_2" onchange="emal_chk()">
								<option selected="selected" value="">선택하세요</option>
								<option>@naver.com</option>
								<option>@daum.com</option>
								<option>@gmail.com</option>
							</select>
							<span id="email_chk_done"></span>
						</td>
					</tr>
					<tr>
						<td id="top_name_tool_td" style="border-bottom: 1px solid #333;">
							<label id="top_name_tool">＊전화번호</label>
								<select name="members_tel" id="members_tel">
									<option selected="selected">010</option>
									<option>011</option>
									<option>017</option>
								</select>
							 - <input type="tel" name="members_tel2" id="members_tel2">
							 - <input type="tel" name="members_tel3" id="members_tel3">
						</td>
					</tr>
					<tr>
						<td id="post_td" >
							<label id="top_name_tool">주소</label>
							<input type="text" id="postcode" name="members_addr_1" placeholder="우편번호">
							<input type="button" onclick="execDaumPostcode()" id="post_select_bt"value="우편번호 찾기"><br>
							
							<label id="top_name_tool"></label>
							<input type="text" id="roadAddress" name="members_addr_2"placeholder="도로명주소" size="60" ><br>
							<input type="hidden" id="jibunAddress" placeholder="지번주소"  size="60">
							<span id="guide" style="color:#999;display:none"></span>
							
							<label id="top_name_tool"></label>
							<input type="text" id="detailAddress" name="members_addr_3" placeholder="상세주소"  size="60"><br>
							<input type="hidden" id="extraAddress" placeholder="참고항목"  size="60">
							<input type="hidden" id="engAddress" placeholder="영문주소"  size="60" ><br>
						</td>
					</tr>
					
					<tr>
						<td>
							<div>
								<button type="button" id="doneBtn" onclick="join()">회원가입</button>
							</div>
							<div>
								<button type="button" id="joincancel" onclick="location.href='${contextPath}/'" >취소</button>
							</div>
						</td>
					</tr>
				</table>
				
				
			</form>
		</div>
	</div>
	
</body>
</html>