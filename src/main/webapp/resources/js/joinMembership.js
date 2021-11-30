
//우편번호 찾기 
function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById("roadAddress").value = roadAddr;
            document.getElementById("jibunAddress").value = data.jibunAddress;
     
            document.getElementById("engAddress").value = data.addressEnglish;
                   
            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
            if(roadAddr !== ''){
                document.getElementById("extraAddress").value = extraRoadAddr;
            } else {
                document.getElementById("extraAddress").value = '';
            }

            var guideTextBox = document.getElementById("guide");
            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            if(data.autoRoadAddress) {
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                guideTextBox.style.display = 'block';

            } else if(data.autoJibunAddress) {
                var expJibunAddr = data.autoJibunAddress;
                guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                guideTextBox.style.display = 'block';
            } else {
                guideTextBox.innerHTML = '';
                guideTextBox.style.display = 'none';
            }
        }
    }).open();
}


//아이디 중복 확인
function idChk(){
	
	var id = document.getElementById('members_id').value;
	var num = id.search(/[0-9]/g);
	var eng = id.search(/[a-z]/ig);
	var spe = id.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
	var kor = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	
	if(id.length<4 || id.length>12){
		alert("아이디는 4글자 이상 12글자 이하로 입력해주세요.");
		$("#members_id").val("");
		$("#members_id").focus();
		return false;
	}else if(spe>0){
		alert("아이디에 특수문자를 포함할 수 없습니다.");
		$("#members_id").val("");
		$("#members_id").focus();
		return false;
	}else if(kor.test(id)==1){
		alert("아이디에 한글을 포함할 수 없습니다.");
		$("#members_id").val("");
		$("#members_id").focus();
		return false;
	}else{
		$.ajax(
				{
					type : "post",
					url	: "idChk.do",
					dataType : "json",
					data : {"members_id" : $("#members_id").val()},
					success : 
						function(data){
						if(data == 1){
							document.getElementById('id_Chk').innerHTML='중복되었습니다.'
								document.getElementById('id_Chk').style.color='red';
						}else if(data == 0){
							$("#id_Chk").attr("value","Y");
							document.getElementById('id_Chk').innerHTML='사용가능합니다.'
								document.getElementById('id_Chk').style.color='blue';
						}
					}
				}
		)
		return true;
	}
	
	
}

//닉네임 중복 확인
function nickChk(){
	var nick = document.getElementById('members_nickname').value;
	
	if(nick.length<2 || nick.length>8){
		alert("닉네임은 2글자 이상 8글자 이내로 입력해주세요");
		$("#members_nickname").val("");
		$("#members_nickname").focus();
		return false;
	}else{
		$.ajax(
				{
					type : "post",
					url	: "nickNameChk.do",
					dataType : "json",
					data : {"members_nickname" : $("#members_nickname").val()},
					success : 
						function(data){
						if(data == 1){
							document.getElementById('nick_chk').innerHTML='중복되었습니다.'
								document.getElementById('nick_chk').style.color='red';
						}else if(data == 0){
							$("#nick_Chk").attr("value","Y");
							document.getElementById('nick_chk').innerHTML='사용가능합니다.'
								document.getElementById('nick_chk').style.color='blue';
						}
					}
				}
		)
		return true;
	}
	
}

//이메일 중복 확인
function emal_chk(){
	
	var email_1 = document.getElementById('members_email_1').value;
	var email_2 = document.getElementById('members_email_2').value;
	if(email_1 != '' && email_2 != ''){
	$.ajax(
			{
				type : "post",
				url	: "emailChk.do",
				dataType : "json",
				data : {"members_email" : $("#members_email_1").val()+ $("#members_email_2").val()},
				success : 
					function(data){
					if(data == 1){
						document.getElementById('email_chk_done').innerHTML='중복되었습니다.'
						document.getElementById('email_chk_done').style.color='red';
					}else if(data == 0){
						document.getElementById('email_chk_done').innerHTML='사용가능합니다.'
						document.getElementById('email_chk_done').style.color='blue';
					}
				}
			});
	}else{
		return null;
	}
}
//비밀번호 확인
function pwChk(){
	var p1 = document.getElementById('members_pw').value;
	var p2 = document.getElementById('members_pw_2').value;
	var num = p1.search(/[0-9]/g);
	var eng = p1.search(/[a-z]/ig);
	var spe = p1.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
	
	//비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다. <br>특수문자는 1개 이상 포함시켜주세요.
	if(p1.length<6 || p1.length>16){
		alert("6글자 이상 16글자 이내로 입력해주세요.");
		$("#members_pw").val("");
		$("#members_pw").focus();
		return false;
	}else if(p1.search(/\s/) != -1){
		alert("비밀번호는 공백을 사용할 수 없습니다.");
		$("#members_pw").val("");
		$("#members_pw").focus();
		return false;
	}else if(num <0 || eng<0 ||spe<0){
		alert("영문, 숫자, 특수문자를 혼합하여 입력해주세요.");
		$("#members_pw").val("");
		$("#members_pw").focus();
		return false;
	}else if(p1 != '' && p2 !=''){
		if(p1 == p2){
			document.getElementById('chkAns_1').innerHTML='';
			document.getElementById('chkAns_2').innerHTML='비밀번호가 일치합니다.';
			document.getElementById('chkAns_2').style.color='blue';
		}
		else if(p1 != p2){
			document.getElementById('chkAns_1').innerHTML='비밀번호가 일치하지 않습니다.';
			document.getElementById('chkAns_2').innerHTML='확인해주세요.';
			document.getElementById('chkAns_1').style.color='red';
			document.getElementById('chkAns_2').style.color='red';
		}
	}else{
		return true;
	}
}



function join(){
	if(confirm("회원 가입 하시겠습니까?")){
		$("#logForm").submit();
	}else{
		return false;
	}
	
}

