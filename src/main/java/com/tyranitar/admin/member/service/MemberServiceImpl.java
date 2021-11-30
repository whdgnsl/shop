package com.tyranitar.admin.member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.tyranitar.admin.member.dao.MemberDAO;
import com.tyranitar.member.dto.MemberDTO;

@Service("adMemberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Override
	public List<MemberDTO> memberList()throws Exception {
		
		List<MemberDTO> list = memberDAO.memberList();
		
		return list;
	}
	
	@Override
	public MemberDTO memberOne(int members_no) throws Exception {
		
		MemberDTO memberDTO = memberDAO.memberOne(members_no);
		
		return memberDTO;
	}

	@Override
	public void memberMdDone(MemberDTO memberDTO) throws Exception {
		
		memberDAO.memberMdDone(memberDTO);
		
	}
}
