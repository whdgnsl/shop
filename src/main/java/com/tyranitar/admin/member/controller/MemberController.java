package com.tyranitar.admin.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tyranitar.member.dto.MemberDTO;

public interface MemberController {

	public ModelAndView memberList(HttpServletRequest request, HttpServletResponse response, ModelAndView mv)throws Exception;
	
	public ModelAndView memberOne(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, @RequestParam("members_no")int members_no)throws Exception;
	
	public ResponseEntity memberMdDone(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, @ModelAttribute("memberInfo")MemberDTO memberDTO)throws Exception;
	
}
