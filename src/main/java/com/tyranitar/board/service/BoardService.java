package com.tyranitar.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyranitar.board.dao.BoardDAO;
import com.tyranitar.board.dto.BoardDTO;
import com.tyranitar.board.dto.BoardListDTO;

@Service("boardService")
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	private int size = 20; //한페이지 출력 개수
	
	public List<BoardDTO> noticeList() {
		
		List<BoardDTO> noticeList =  boardDAO.noticeList();
		
		return noticeList;
	}

	public void noticeDone(BoardDTO boardDTO) {
		
		boardDAO.boardDTO(boardDTO);
	}

	public BoardDTO noticeDetail(BoardDTO boardDTO) {
		
		BoardDTO noticeDetail = boardDAO.noticeDetail(boardDTO);
		
		return noticeDetail;
	}

	public int noticeCount() {
		return boardDAO.noticeCount();
	}
	
	public BoardListDTO noticePage(int pageNo) {
		
		int total = boardDAO.noticeCount();
		List<BoardDTO> content = boardDAO.noticePage((pageNo-1)*size, size);
		return new BoardListDTO(total, pageNo, size, content);
		
	}

}
