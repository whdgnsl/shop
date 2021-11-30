package com.tyranitar.member.controller;

import java.util.Map;

import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tyranitar.member.dto.MemberDTO;
import com.tyranitar.member.service.MemberService;

@Controller("memberController")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberDTO memberDTO;

	// 암호화 기능
	@Inject
	BCryptPasswordEncoder pwdEncoder;

	@RequestMapping("/")
	public String main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String result = request.getParameter("loginResult");
		return "/member/login";
	}

	// 로그인
	@RequestMapping(value = "/member/loginPath.do", method = { RequestMethod.POST })
	public ModelAndView login(MemberDTO vo, HttpSession session, RedirectAttributes rttr, ModelAndView mv) throws Exception {
		logger.info("post login");

		session.getAttribute("member");
		MemberDTO login = memberService.login(vo);
		boolean pwdMatch = pwdEncoder.matches(vo.getMembers_pw(), login.getMembers_pw());

		if (login != null && pwdMatch == true) {
			session.setAttribute("member", login);
			session.setAttribute("MID", login.getMembers_id());
			session.setAttribute("MDTO", login);
			session.setAttribute("isLogin",true);
			mv.setViewName("redirect:/main.do");
			
		} else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			mv.setViewName("redirect:/loginFail.do");
		}
		return mv;
	}

	@RequestMapping("/loginFail.do")
	public String loginFail(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "loginFail";
	}

	// 로그아웃
	@RequestMapping(value = "/logout.do", method = { RequestMethod.GET })
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response,
			@RequestParam Map<String, Object> memberInfo, RedirectAttributes rdAttr, ModelAndView mv) throws Exception {

		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("MID");
		session.removeAttribute("MDTO");
		session.removeAttribute("isLogin");

		mv.setViewName("redirect:/");
		return mv;
	}

	// 회원가입 폼
	@RequestMapping("joinmembership.do")
	public String joinMembership(HttpServletRequest request, HttpServletResponse response) {

		return "joinMembership";
	}

	// 아이디 중복 확인
	@ResponseBody
	@RequestMapping(value = "idChk.do")
	public int idChk(MemberDTO memberDTO) {
		int result = memberService.idChk(memberDTO);
		return result;
	}

	// 닉네임 중복 확인
	@ResponseBody
	@RequestMapping(value = "nickNameChk.do")
	public int nickNameChk(MemberDTO memberDTO) {
		int result = memberService.nickNameChk(memberDTO);
		return result;
	}

	// 이메일 중복 확인
	@ResponseBody
	@RequestMapping(value = "emailChk.do")
	public int emailChk(MemberDTO memberDTO) {
		int result = memberService.emailChk(memberDTO);
		return result;
	}

	// 회원가입 성공
	@RequestMapping(value = "joinsuccess.do")
	public String joinMember(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("info") MemberDTO memberDTO) {

		String addr_1 = request.getParameter("members_addr_1");
		String addr_2 = request.getParameter("members_addr_2");
		String addr_3 = request.getParameter("members_addr_3");
		String members_addr = addr_1 + " " + addr_2 + addr_3;

		String tel2 = request.getParameter("members_tel2");
		String tel3 = request.getParameter("members_tel3");
		String members_tel = memberDTO.getMembers_tel() + tel2 + tel3;

		String inputPass = memberDTO.getMembers_pw();
		String members_pw = pwdEncoder.encode(inputPass);

		String email_1 = request.getParameter("members_email_1");
		String email_2 = request.getParameter("members_email_2");
		String members_email = email_1 + email_2;

		memberDTO.setMembers_tel(members_tel);
		memberDTO.setMembers_addr(members_addr);
		memberDTO.setMembers_email(members_email);
		memberDTO.setMembers_pw(members_pw);

		memberService.joinMember(memberDTO);

		return "joinSuccess";
	}

	// 마이페이지
	@RequestMapping(value = "myPage.do")
	public ModelAndView myPage(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("info") MemberDTO vo) {
		System.out.println(vo);
		MemberDTO myInfo = memberService.myPage(vo);
		ModelAndView mv = new ModelAndView("myPage");
		mv.addObject("myInfo", myInfo);
		return mv;
	}

}
