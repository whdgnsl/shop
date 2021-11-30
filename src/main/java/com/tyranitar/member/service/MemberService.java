package com.tyranitar.member.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyranitar.member.dao.MemberDAO;
import com.tyranitar.member.dto.MemberDTO;

@Service("memberService")
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	//로그인
	public MemberDTO login(MemberDTO vo) {
		MemberDTO memberDTO = memberDAO.login(vo);
		return memberDTO;
	}
	
	//회원가입
	public void joinMember(MemberDTO memberDTO) {
		memberDAO.joinMember(memberDTO);
	}

	//아이디 중복 확인
	public int idChk(MemberDTO memberDTO) {
		int result = memberDAO.idChk(memberDTO);
		return result;
	}

	//닉네임 중복 확인
	public int nickNameChk(MemberDTO memberDTO) {
		int result = memberDAO.nickNameChk(memberDTO);
		return result;
	}
	
	//이메일 중복 확인
	public int emailChk(MemberDTO memberDTO) {
		
		int result = memberDAO.emailChk(memberDTO);
		return result;
	}
	
	//마이페이지
	public MemberDTO myPage(MemberDTO vo) {
		MemberDTO myInfo = memberDAO.myPage(vo);
		
		return myInfo;
		
	}

}
