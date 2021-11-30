package com.tyranitar.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyranitar.board.dto.BoardDTO;

@Repository("boardDAO")
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardDTO> noticeList() {
		
		List<BoardDTO> noticeList = sqlSession.selectList("board.noticeList");
		
		return noticeList;
	}

	public void boardDTO(BoardDTO boardDTO) {
		
		sqlSession.insert("board.noticeDone",boardDTO);
	}

	public BoardDTO noticeDetail(BoardDTO boardDTO) {
		
		BoardDTO noticeDetail = sqlSession.selectOne("board.noticeDetail", boardDTO);
		
		return noticeDetail;
	}
	
	public int noticeCount() {
		int count = sqlSession.selectOne("board.noticeCount");
		return count;
	}
	
	public List<BoardDTO> noticePage(int startRow, int size){
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		int start = startRow + 1;
		int end = startRow+size;
		map.put("start", start);
		map.put("end", end);
		List<BoardDTO> noticePage = sqlSession.selectList("board.noticePage", map);
		
		return noticePage;
	}

}
