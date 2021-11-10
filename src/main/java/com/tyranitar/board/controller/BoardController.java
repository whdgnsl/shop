package com.tyranitar.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tyranitar.board.dto.BoardDTO;
import com.tyranitar.board.service.BoardService;


@Controller("boardController")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardDTO boardDTO;

	@RequestMapping("notice.do")
	public ModelAndView notice(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		List<BoardDTO> noticeList = boardService.noticeList();
		
		ModelAndView mv = new ModelAndView("noticeList");
		
		mv.addObject("notice",noticeList);
		
		return mv;
		
	}
	
}
