package com.tyranitar.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyranitar.board.dao.BoardDAO;
import com.tyranitar.board.dto.BoardDTO;

@Service("boardService")
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	public List<BoardDTO> noticeList() {
		
		List<BoardDTO> noticeList =  boardDAO.noticeList();
		
		return noticeList;
	}

}
