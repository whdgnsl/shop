package com.tyranitar.admin.member.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.tyranitar.member.dto.MemberDTO;

public interface MemberDAO {

	public List<MemberDTO> memberList()throws Exception;

	public MemberDTO memberOne(int members_no)throws Exception;

	public void memberMdDone(MemberDTO memberDTO)throws Exception;

	
}
