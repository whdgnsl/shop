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
	public MemberDTO login(Map<String, Object> memberInfo) {
		MemberDTO memberDTO = memberDAO.login(memberInfo);
		return memberDTO;
	}
	
	//회원가입
	public void joinMember(MemberDTO memberDTO) {
		memberDAO.joinMember(memberDTO);
	}

	//마이페이지
	public MemberDTO myPage(MemberDTO memberDTO) {
		MemberDTO myInfo = memberDAO.myPage(memberDTO);
		
		return myInfo;
		
	}
	
}
