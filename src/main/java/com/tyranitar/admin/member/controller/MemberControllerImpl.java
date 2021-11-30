package com.tyranitar.admin.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tyranitar.admin.member.service.MemberService;
import com.tyranitar.member.dto.MemberDTO;

@Controller("adMemberController")
public class MemberControllerImpl implements MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberDTO memberDTO;
	
	
	//회원 리스트
	@Override
	@RequestMapping("membersMG.do")
	public ModelAndView memberList(HttpServletRequest request, HttpServletResponse response, ModelAndView mv)throws Exception {
		
		List<MemberDTO> list = memberService.memberList();
		mv.addObject("memberList", list);
		mv.setViewName("adMemberList");
		
		HttpSession session = request.getSession();
		MemberDTO memberDto =(MemberDTO)session.getAttribute("MDTO");
		Boolean isLogin = (Boolean)session.getAttribute("isLogin");
		mv.addObject("memberDTO", memberDto);
		mv.addObject("isLogin", isLogin);
		
		return mv;
	}

	//회원 정보 변경 폼
	@Override
	@RequestMapping("memberChange.do")
	public ModelAndView memberOne(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, @RequestParam("members_no")int members_no) throws Exception {
		MemberDTO memberDTO = memberService.memberOne(members_no);
		System.out.println(memberDTO);
		mv.addObject("memberInfo", memberDTO);
		mv.setViewName("memberChange");
		
		HttpSession session = request.getSession();
		MemberDTO memberDto =(MemberDTO)session.getAttribute("MDTO");
		Boolean isLogin = (Boolean)session.getAttribute("isLogin");
		mv.addObject("memberDTO", memberDto);
		mv.addObject("isLogin", isLogin);
		
		return mv;
	}

	//회원 정보 변경 
	@Override
	@RequestMapping("memberChangeDone.do")
	public ResponseEntity memberMdDone(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, @ModelAttribute("memberInfo")MemberDTO memberDTO) throws Exception {
		String message = null;
		ResponseEntity resEntity = null;
		memberService.memberMdDone(memberDTO);
		mv.setViewName("redirect:membersMG.do");
		
		message = "<script>";
		message +="window.close();";
		message +="</script>";
		resEntity = new ResponseEntity(message, HttpStatus.OK);
		
		return resEntity;
	}


}
