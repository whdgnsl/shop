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
		return "/member/login";
	}
	
	
	
	//로그인
	@RequestMapping(value ="/member/loginPath.do", method = {RequestMethod.POST})
	public ModelAndView login(HttpServletRequest request, 
						HttpServletResponse response,
						@RequestParam Map<String ,Object> memberInfo,
						RedirectAttributes rdAttr) throws Exception {
		
		System.out.println("memberInfo == "+memberInfo);
		MemberDTO memberDTO = memberService.login(memberInfo);
		
		//3.Model
		ModelAndView mv = new ModelAndView();
		if(memberDTO!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("MID", memberDTO.getMembers_id());
			session.setAttribute("MDTO", memberDTO);
			session.setAttribute("isLogin",true);
			mv.setViewName("redirect:/main.do");
		}else{
			mv.setViewName("redirect:/loginFail.do");
		}
		
		//4.View
		return mv;
	}
	
	@RequestMapping("/loginFail.do")
	public String loginFail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		return "loginFail";
	}
	
	
	//濡쒓렇�븘�썐
	@RequestMapping(value ="/logout.do", method = {RequestMethod.GET})
	public ModelAndView logout(HttpServletRequest request, 
						HttpServletResponse response,
						@RequestParam Map<String ,Object> memberInfo,
						RedirectAttributes rdAttr, ModelAndView mv) throws Exception {
		//1.�뙆�씪誘명꽣諛쏄린
		
		//2.鍮꾩쫰�땲�뒪濡쒖쭅�닔�뻾
		HttpSession session = request.getSession();
		session.removeAttribute("MID");
		session.removeAttribute("MDTO");
		session.removeAttribute("isLogin");
		
		//硫붿씤�럹�씠吏�濡� 由щ떎�씠�젆�듃 諛⑹떇�쑝濡� �씠�룞
		mv.setViewName("redirect:/");
		return mv;
	}
	
	//�쉶�썝媛��엯
	@RequestMapping("joinmembership.do")
	public String joinMembership(HttpServletRequest request, HttpServletResponse response) {
		
	return "joinMembership";
	}
	
	//�쉶�썝媛��엯
	@RequestMapping(value ="joinsuccess.do")
	public String joinMember(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("info") MemberDTO memberDTO) {
		String tel2 = request.getParameter("members_tel2");
		String tel3 = request.getParameter("members_tel3");
		
		String members_tel = memberDTO.getMembers_tel()+tel2+tel3;
		memberDTO.setMembers_tel(members_tel);
		memberService.joinMember(memberDTO);
		return "joinSuccess";
	}
	
	//留덉씠�럹�씠吏�
	@RequestMapping(value = "myPage.do")
	public ModelAndView myPage(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("info") MemberDTO memberDTO) {
		System.out.println(memberDTO);
		MemberDTO myInfo = memberService.myPage(memberDTO);
		ModelAndView mv = new ModelAndView("myPage");
		mv.addObject("myInfo", myInfo);
		return mv;
	}
	
}
