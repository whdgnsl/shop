package com.tyranitar.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tyranitar.board.dto.BoardDTO;
import com.tyranitar.board.dto.BoardListDTO;
import com.tyranitar.board.service.BoardService;
import com.tyranitar.member.dto.MemberDTO;


@Controller("boardController")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardDTO boardDTO;

	@RequestMapping("noticeDetail.do")
	public ModelAndView noticeDetail(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, @Param("boardDTO")BoardDTO boardDTO) {
		
		BoardDTO noticeDetail = boardService.noticeDetail(boardDTO);
		
		mv.addObject("detail",noticeDetail);
		mv.setViewName("noticeDetail");
		
		HttpSession session = request.getSession();

		MemberDTO vo =(MemberDTO)session.getAttribute("MDTO");
		Boolean isLogin = (Boolean)session.getAttribute("isLogin");
		
		mv.addObject("memberDTO", vo);
		mv.addObject("isLogin", isLogin);
		System.out.println("###################################mv = " +mv);
		return mv;
	}
	
	//글 등록 폼 
	@RequestMapping("noticeWriter.do")
	public String noticeWriter(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) {
		HttpSession session = request.getSession();
		session.getAttribute("MID");
		session.getAttribute("MDTO");
		session.getAttribute("isLogin");
		
		MemberDTO memberDto =(MemberDTO)session.getAttribute("MDTO");
		Boolean isLogin = (Boolean)session.getAttribute("isLogin");
		mv.addObject("memberDTO", memberDto);
		mv.addObject("isLogin", isLogin);
		
		
		return "noticeWriter";
	}
	
	//글 등록
	@RequestMapping("noticeDone.do")
	public ModelAndView noticeDone(HttpServletRequest request, HttpServletResponse response, @Param("boardDTO")BoardDTO boardDTO, ModelAndView mv) {
		
		boardService.noticeDone(boardDTO);
		mv.setViewName("redirect:/notice.do");
		
		HttpSession session = request.getSession();
		MemberDTO memberDto =(MemberDTO)session.getAttribute("MDTO");
		Boolean isLogin = (Boolean)session.getAttribute("isLogin");
		mv.addObject("memberDTO", memberDto);
		mv.addObject("isLogin", isLogin);
		
		return mv;
	}
	
	//글 리스트
	@RequestMapping(value = "notice.do", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView notice(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		
		String pageNoVal = request.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoVal!=null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		BoardListDTO boardListDTO = boardService.noticePage(pageNo);
		
		ModelAndView mv = new ModelAndView("noticeList");
		HttpSession session = request.getSession();
		MemberDTO memberDto =(MemberDTO)session.getAttribute("MDTO");
		Boolean isLogin = (Boolean)session.getAttribute("isLogin");
		mv.addObject("memberDTO", memberDto);
		mv.addObject("isLogin", isLogin);
		mv.addObject("boardListDTO",boardListDTO);
		
		return mv;
		
	}
	
}
