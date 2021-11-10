package com.tyranitar.member.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tyranitar.member.dto.MemberDTO;
import com.tyranitar.member.service.MemberService;

@Controller("memberController")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberDTO memberDTO;
	
	
	@RequestMapping("/")
	public String main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String result = request.getParameter("loginResult");
		//기존방식에서는 /member폴더/loginForm.jsp문서를 뜻하는거지만
		//tiles를 이용하면
		//tiles_member.xml에서 정의한
		//<definition name="member/loginForm">에서의
		//name속성값인 "member
		return "/member/login";
	}
	
	
	
	//로그인
	@RequestMapping(value ="/member/loginPath.do", method = {RequestMethod.POST})
	public ModelAndView login(HttpServletRequest request, 
						HttpServletResponse response,
						@RequestParam Map<String ,Object> memberInfo,
						RedirectAttributes rdAttr) throws Exception {
		//1.파라미터받기
		
		//2.비즈니스로직수행
		System.out.println("memberInfo == "+memberInfo);
		MemberDTO memberDTO = memberService.login(memberInfo);
		
		//3.Model
		ModelAndView mv = new ModelAndView();
		//로그인 성공시 세션에 로그인한 유저 정보+sendRedirect이용 회원목록 페이지로 이동
		if(memberDTO!=null) {
			HttpSession session = request.getSession();
			//session.setAttribute(키명, memberDTO.getId());//DTO에서 특정 field만 세션에저장
			//session.setAttribute(키명, memberDTO);//DTO자체를 세션에 저장
			session.setAttribute("MID", memberDTO.getMembers_id());
			session.setAttribute("MDTO", memberDTO);
			session.setAttribute("isLogin",true);
			mv.setViewName("redirect:/");
		}else{//로그인 실패시 sendRedirect이용 로그인폼페이지로 이동
			//요청함수의 RedirectAttributes은 이다이렉트시 가져사는 파라미터
			//여기에서는 "loginResult"라는 키명으로
			//String타입의 loginFail 값이 사용되었다.
//			rdAttr.addAttribute("loginResult","loginFail");
			mv.setViewName("redirect:/loginFail.do");
		}
		//4.View
		return mv;
	}
	
	@RequestMapping("/loginFail.do")
	public String loginFail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//메인페이지로 리다이렉트 방식으로 이동
		
		return "loginFail";
	}
	
	
	//로그아웃
	@RequestMapping(value ="/logout.do", method = {RequestMethod.GET})
	public ModelAndView logout(HttpServletRequest request, 
						HttpServletResponse response,
						@RequestParam Map<String ,Object> memberInfo,
						RedirectAttributes rdAttr, ModelAndView mv) throws Exception {
		//1.파라미터받기
		
		//2.비즈니스로직수행
		HttpSession session = request.getSession();
		session.removeAttribute("MID");
		session.removeAttribute("MDTO");
		session.removeAttribute("isLogin");
		
		//메인페이지로 리다이렉트 방식으로 이동
		mv.setViewName("redirect:/");
		return mv;
	}
	
	//회원가입
	@RequestMapping("joinmembership.do")
	public String joinMembership(HttpServletRequest request, HttpServletResponse response) {
		
	return "joinMembership";
	}
	
	//회원가입
	@RequestMapping(value ="joinsuccess.do")
	public String joinMember(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("info") MemberDTO memberDTO) {
		String tel2 = request.getParameter("members_tel2");
		String tel3 = request.getParameter("members_tel3");
		
		String members_tel = memberDTO.getMembers_tel()+tel2+tel3;
		memberDTO.setMembers_tel(members_tel);
		memberService.joinMember(memberDTO);
		return "joinSuccess";
	}
	
	//마이페이지
	@RequestMapping(value = "myPage.do")
	public ModelAndView myPage(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("info") MemberDTO memberDTO) {
		System.out.println(memberDTO);
		MemberDTO myInfo = memberService.myPage(memberDTO);
		ModelAndView mv = new ModelAndView("myPage");
		mv.addObject("myInfo", myInfo);
		return mv;
	}
	
}
